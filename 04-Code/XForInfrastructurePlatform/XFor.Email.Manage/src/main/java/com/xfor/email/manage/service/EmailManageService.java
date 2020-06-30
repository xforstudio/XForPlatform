package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.config.EmailConfig;
import com.xfor.email.manage.config.RabbitMQConfig;
import com.xfor.email.manage.config.RedisConfig;
import com.xfor.email.manage.manager.RabbitMQManager;
import com.xfor.email.manage.manager.RedisManager;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.*;
import com.xfor.infrastructure.core.email.repository.IEmailMessageRepository;
import com.xfor.infrastructure.core.email.repository.IEmailActionRepository;
import com.xfor.infrastructure.core.email.repository.IEmailTemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 *
 */
@Component
public class EmailManageService extends BaseService {

    private static final Logger _logger = LoggerFactory.getLogger(EmailManageService.class);

    @Autowired
    private IEmailMessageRepository emailMessageRepository;
    @Autowired
    private IEmailActionRepository emailActionRepository;
    @Autowired
    private IEmailTemplateRepository emailTemplateRepository;
    @Autowired
    private IDateTimeProvider dateTimeProvider;
    @Autowired
    private EmailSendService emailSendService;
    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    private RabbitMQManager rabbitMQManager;
    @Autowired
    private RabbitMQConfig rabbitMQConfig;
    @Autowired
    private RedisManager redisManager;
    @Autowired
    private RedisConfig redisConfig;


    public EmailManageService() {
    }

    /* Email */

    public Email createEmail(EmailMessage fields) throws EmailException {
        ServiceContext sctx = this.doGetServiceContext();
        EmailMessage emailMessage = EmailMessage._create(
                fields.getFrom(),
                fields.getTo(),
                fields.getSubject(),
                fields.getContent(),
                fields.getEmailTemplateCode(),
                fields.getEmailTemplateData(),
                this.dateTimeProvider);
        EmailAction emailAction = EmailAction._create(emailMessage, this.dateTimeProvider);
        //保存数据
        this.emailMessageRepository.saveEmailMessage(sctx, emailMessage);
        this.emailActionRepository.saveEmailAction(sctx, emailAction);
        //创建Email
        Email email = Email._create(emailMessage, emailAction);
        return email;
    }

    public boolean removeEmail(Email email) throws EmailException {
        ServiceContext sctx = this.doGetServiceContext();
        boolean result = false;
        //删除EmailMessage
        result = this.emailMessageRepository.removeEmailMessageBySid(sctx, email.getEmailMessage().getSid());
        if (!result) {
            return false;
        }
        result = this.emailActionRepository.removeEmailActionBySid(sctx, email.getEmailAction().getSid());
        return result;
    }

    public Email getEmailByEmailMessageSid(String emailMessageSid) {
        ServiceContext sctx = this.doGetServiceContext();
        EmailMessage emailMessage = this.emailMessageRepository.getEmailMessageBySid(sctx, emailMessageSid);
        EmailAction emailAction = this.emailActionRepository.getEmailActionByEmailMessageSid(sctx, emailMessageSid);
        Email email = Email._create(emailMessage, emailAction);
        return email;
    }

    /* EmailMessage */

    public EmailMessage getEmailMessageBySid(String emailMessageSid) {
        ServiceContext sctx = this.doGetServiceContext();
        EmailMessage result = this.emailMessageRepository.getEmailMessageBySid(sctx, emailMessageSid);
        return result;
    }

    /* EmailAction */

    public EmailAction getEmailActionBySid(String emailActionSid) {
        ServiceContext sctx = this.doGetServiceContext();
        EmailAction result = this.emailActionRepository.getEmailActionBySid(sctx, emailActionSid);
        return result;
    }

    public EmailAction getEmailActionByEmailMessageSid(String emailMessageSid) {
        ServiceContext sctx = this.doGetServiceContext();
        EmailAction result = this.emailActionRepository.getEmailActionByEmailMessageSid(sctx, emailMessageSid);
        return result;
    }

    /* EmailTemplate */

    public EmailTemplate createEmailTemplate(EmailTemplate fields) throws EmailException {
        ServiceContext sctx = this.doGetServiceContext();
        EmailTemplate emailTemplate = EmailTemplate._create(
                fields.getCode(),
                fields.getName(),
                fields.getMemo(),
                fields.getContent(),
                fields.getFileName(),
                fields.getEngineType(),
                this.dateTimeProvider);
        boolean result = this.emailTemplateRepository.saveEmailTemplate(sctx, emailTemplate);
        if (!result) {
            throw new EmailException("保存邮件模板失败");
        }
        return emailTemplate;
    }

    public EmailTemplate getEmailTemplateBySid(String emailTemplateSid) {
        ServiceContext sctx = this.doGetServiceContext();
        EmailTemplate result = this.emailTemplateRepository.getEmailTemplateBySid(sctx, emailTemplateSid);
        return result;
    }

    /* EmailSend */

    public void sendEmail(EmailMessage fields) throws EmailException {

        //创建并保存Email业务数据对象
        Email email = this.createEmail(fields);

        ServiceContext sctx = this.doGetServiceContext();
        //获取模板
        EmailTemplate emailTemplate = this.emailTemplateRepository.getEmailTemplateByCode(
                sctx,
                email.getEmailMessage().getEmailTemplateCode());
        //尝试发送邮件
        try {

            //发送邮件
            this.emailSendService.sendEmail(email.getEmailMessage(), emailTemplate);
            //处理发送成功
            //设置状态
            email.getEmailAction().sendSuccessed(this.dateTimeProvider);
            //保存数据
            this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
        } catch (EmailSendException ex) {
            //处理发送失败

            //设置状态
            email.getEmailAction().sendError(this.dateTimeProvider);
            //保存数据
            this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());

            //重试
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailAsync(EmailMessage fields) throws JsonProcessingException {
        //发送"EmailCreate"消息
        this.rabbitMQManager.sendMessage(this.rabbitMQConfig.getQueueNameEmailCreate(), fields);
    }

    //处理"EmailCreate"消息
    public void onEmailCreate(String content) throws EmailException, JsonProcessingException {
        EmailMessage fields = JsonUtil._stringToObject(content, EmailMessage.class);
        this.onEmailCreate(fields);
    }

    //处理"EmailCreate"消息
    public void onEmailCreate(EmailMessage fields) throws EmailException, JsonProcessingException {
        //创建并保存Email业务数据对象
        Email email = this.createEmail(fields);
        //发送"EmailSend"消息
        this.rabbitMQManager.sendMessage(this.rabbitMQConfig.getQueueNameEmailSend(), email);
    }

    //处理"EmailSend"消息
    public void onEmailSend(String content) throws JsonProcessingException {
        Email email = JsonUtil._stringToObject(content, Email.class);
        this.onEmailSend(email);
    }

    //处理"EmailSend"消息
    public void onEmailSend(Email email) {
        ServiceContext sctx = this.doGetServiceContext();
        //尝试发送邮件
        try {
            EmailTemplate emailTemplate = this.emailTemplateRepository.getEmailTemplateByCode(
                    sctx,
                    email.getEmailMessage().getEmailTemplateCode());
            //发送邮件
            this.emailSendService.sendEmail(email.getEmailMessage(), emailTemplate);
            //处理发送成功
            //设置状态
            email.getEmailAction().sendSuccessed(this.dateTimeProvider);
            //保存数据
            this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
        } catch (EmailSendException ex) {
            //处理发送失败

            //设置状态
            email.getEmailAction().sendError(this.dateTimeProvider);
            //保存数据
            this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
            //将数据放入"SendRetry"缓存队列
            this.redisManager.addListValue(this.redisConfig.getListKeyEmailSendRetry(), email);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrySendEmails() {
        //从Redis缓存中获取并移除队列头部元素
        Email email = (Email)this.redisManager.popListFirst(this.redisConfig.getListKeyEmailSendRetry());
        //增加Retry次数
        email.getEmailAction().increaseSendRetryCount();
        //
        ServiceContext sctx = this.doGetServiceContext();
        //尝试发送邮件
        try {
            EmailTemplate emailTemplate = this.emailTemplateRepository.getEmailTemplateByCode(
                    sctx,
                    email.getEmailMessage().getEmailTemplateCode());
            //发送邮件
            this.emailSendService.sendEmail(email.getEmailMessage(), emailTemplate);
            //处理发送成功
            //设置状态
            email.getEmailAction().sendSuccessed(this.dateTimeProvider);
            //保存数据
            this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
        } catch (EmailSendException ex) {
            //处理发送失败
            if (email.getEmailAction().isSendRetryEnabled(this.emailConfig.getMailSendRetryCountMax())) {
                //设置状态
                email.getEmailAction().sendError(this.dateTimeProvider);
                //保存数据
                this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
                //将数据放入"SendRetry"缓存队列
                this.redisManager.addListValue(this.redisConfig.getListKeyEmailSendRetry(), email);
            } else {
                //设置最终状态：发送失败
                email.getEmailAction().sendFault(this.dateTimeProvider);
                //保存数据
                this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
            }
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrySendEmails(String emailMessageSID, int mailSendRetryCountMax) {
        ServiceContext sctx = this.doGetServiceContext();
        Email email = this.getEmailByEmailMessageSid(emailMessageSID);
        if (email.getEmailAction().hasSendFinished()) {
            return;
        }
        while (email.getEmailAction().increaseSendRetryCount() <= mailSendRetryCountMax) {
            try {
                EmailTemplate emailTemplate = this.emailTemplateRepository.getEmailTemplateByCode(
                        sctx,
                        email.getEmailMessage().getEmailTemplateCode());
                //发送邮件
                this.emailSendService.sendEmail(email.getEmailMessage(), emailTemplate);
                //处理发送成功
                //设置状态
                email.getEmailAction().sendSuccessed(this.dateTimeProvider);
                //保存数据
                this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
                //
                return;
            } catch (EmailSendException ex) {
                //处理发送失败
                if (email.getEmailAction().isSendRetryEnabled(this.emailConfig.getMailSendRetryCountMax())) {
                    //设置状态
                    email.getEmailAction().sendError(this.dateTimeProvider);
                    //保存数据
                    this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
                } else {
                    //设置最终状态：发送失败
                    email.getEmailAction().sendFault(this.dateTimeProvider);
                    //保存数据
                    this.emailActionRepository.saveEmailAction(sctx, email.getEmailAction());
                    //
                    return;
                }
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    //处理"EmailCreate"消息
    public void onEmailCreate(String content) throws EmailException, JsonProcessingException {
        EmailMessage fields = JsonUtil._stringToObject(content, EmailMessage.class);
        this.onEmailCreate(fields);
    }

    //处理"EmailCreate"消息
    public void onEmailCreate(EmailMessage fields) throws EmailException, JsonProcessingException {
        //创建并保存Email业务数据对象
        Email email = this.createEmail(fields);
        //发送邮件发送消息
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
            //发送邮件
            this.emailSendService.sendEmail(email.getEmailMessage());
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
            //TODO:将数据放入"SendRetry"缓存队列
            //this.redisManager.addListValue()
        }
    }
}

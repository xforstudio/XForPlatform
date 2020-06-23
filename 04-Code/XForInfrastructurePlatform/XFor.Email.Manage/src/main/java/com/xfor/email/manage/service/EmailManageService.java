package com.xfor.email.manage.service;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
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

    public EmailManageService() {
    }

    /* Email */

    public Email createEmail(EmailMessage fields) throws EmailException {
        ServiceContext sctx = this.doGetServiceContext();
        EmailMessage emailMessage = EmailMessage._create(
                fields.getFrom(),
                fields.getTo(),
                fields.getContent(),
                fields.getTemplateId(),
                fields.getTemplateData());
        EmailAction emailAction = EmailAction._create(emailMessage);
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
        EmailAction result = this.emailActionRepository.get(sctx, emailActionSid);
        return result;
    }

    /* EmailTemplate */

    public EmailTemplate createEmailTemplate(EmailTemplate fields) throws EmailException {
        ServiceContext sctx = this.doGetServiceContext();
        EmailTemplate emailTemplate = EmailTemplate.

        EmailAction result = this.emailTemplateRepository.saveEmailTemplate(sctx, emailActionSid);
        return result;
        return null;
    }

    public EmailTemplate getEmailTemplateBySid(String emailTemplateSid) {
        return null;
    }
}

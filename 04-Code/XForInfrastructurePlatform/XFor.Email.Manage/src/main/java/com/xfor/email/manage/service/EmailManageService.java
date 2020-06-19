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
    private IEmailActionRepository emailSendRepository;

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
        Email email = Email._create(emailMessage, emailAction);
        return email;
    }

    public boolean removeEmail(Email email) throws EmailException {
        return false;
    }

    public boolean removeEmailByEmailMessageSid(String emailMessageSid) throws EmailException {
        return false;
    }

    /* EmailMessage */

    public EmailMessage getEmailMessageBySid(String emailMessageSid) {
        return null;
    }

    /* EmailAction */

    public EmailAction getEmailActionBySid(String emailActionSid) {
        return null;
    }

    public EmailAction getEmailActionByEmailMessageSid(String emailMessageSid) {
        return null;
    }

    /* EmailTemplate */

    public EmailTemplate createEmailTemplate(EmailTemplate fields) throws EmailException {
        return null;
    }

    public EmailTemplate getEmailTemplateBySid(String emailTemplateSid) {
        return null;
    }
}

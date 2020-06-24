package com.xfor.email.manage.service;

import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class XsltEmailTemplateEngineService implements IEmailTemplateEngineService {

    @Override
    public EmailBody getEmailBody(EmailMessage emailMessage, EmailTemplate emailTemplate) {
        return null;
    }
}

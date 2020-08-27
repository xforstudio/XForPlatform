package com.xfor.email.manage.service.impl;

import com.xfor.email.manage.service.EmailTemplateEngineService;
import com.xfor.infrastructure.core.common.util.XsltUtil;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component("XsltEmailTemplateEngineService")
public class XsltEmailTemplateEngineServiceImpl implements EmailTemplateEngineService {

    @Override
    public EmailBody getEmailBody(EmailMessage emailMessage, EmailTemplate emailTemplate) {
        try {
            String htmlContent = XsltUtil._transform(emailTemplate.getContent(), emailMessage.getEmailTemplateData());
            return EmailBody._createFromHtmlContent(htmlContent);
        } catch (Exception ex) {

        }
        return null;
    }
}

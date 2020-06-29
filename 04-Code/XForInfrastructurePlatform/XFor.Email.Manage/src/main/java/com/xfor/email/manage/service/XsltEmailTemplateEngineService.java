package com.xfor.email.manage.service;

import com.xfor.infrastructure.core.common.util.XsltUtil;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.stereotype.Component;

import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 *
 */
@Component("XsltEmailTemplateEngineService")
public class XsltEmailTemplateEngineService implements IEmailTemplateEngineService {

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

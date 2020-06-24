package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;

/**
 *
 */
@Component
public class ThymeleafEmailTemplateEngineService implements IEmailTemplateEngineService {

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public EmailBody getEmailBody(EmailMessage emailMessage, EmailTemplate emailTemplate) {
        //
        HashMap<String, Object> map = null;
        try {
            map = JsonUtil._stringToObject(emailMessage.getEmailTemplateData(), HashMap.class);
        } catch (JsonProcessingException ex) {
            map = new HashMap<>();
        }
        //创建邮件正文
        Context context = new Context();
        for (String key : map.keySet()) {
            Object value = map.get(key);
            context.setVariable(key, value);
        }
        String emailContent = templateEngine.process(emailMessage.getEmailTemplateCode(), context);
//        context.setVariable("id", "006");
//        String emailContent = templateEngine.process("emailTemplate", context);
        //
        EmailBody emailBody = new EmailBody();
        emailBody.setHtmlContent(emailContent);
        return emailBody;
    }
}

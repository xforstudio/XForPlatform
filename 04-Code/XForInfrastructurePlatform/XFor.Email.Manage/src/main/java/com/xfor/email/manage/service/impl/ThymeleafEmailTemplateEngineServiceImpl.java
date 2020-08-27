package com.xfor.email.manage.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.service.EmailTemplateEngineService;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.HashMap;

/**
 *
 */
@Component("ThymeleafEmailTemplateEngineService")
public class ThymeleafEmailTemplateEngineServiceImpl implements EmailTemplateEngineService {

    @Autowired
    private SpringTemplateEngine templateEngine;

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
        context.setVariables(map);
        //模板解析
        String emailContent = templateEngine.process(emailTemplate.getContent(), context);
        return EmailBody._createFromHtmlContent(emailContent);
    }
}

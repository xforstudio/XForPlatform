package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.stereotype.Component;

import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * 邮件模板引擎服务
 */
@Component
public interface IEmailTemplateEngineService {

    //获取邮件主体内容
    EmailBody getEmailBody(EmailMessage emailMessage, EmailTemplate emailTemplate) throws IOException, TransformerException;
}

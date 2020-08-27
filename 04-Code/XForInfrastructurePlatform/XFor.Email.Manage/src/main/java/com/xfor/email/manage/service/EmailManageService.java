package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.*;
import org.springframework.stereotype.Component;

import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * 邮件管理服务
 */
@Component
public interface EmailManageService {

    /* Email */

    Email createEmail(EmailMessage fields) throws EmailException;

    boolean removeEmail(Email email) throws EmailException;

    Email getEmailByEmailMessageSid(String emailMessageSid);

    /* EmailMessage */

    EmailMessage getEmailMessageBySid(String emailMessageSid);

    /* EmailAction */

    EmailAction getEmailActionBySid(String emailActionSid);

    EmailAction getEmailActionByEmailMessageSid(String emailMessageSid);

    /* EmailTemplate */

    EmailTemplate createEmailTemplate(EmailTemplate fields) throws EmailException;

    EmailTemplate getEmailTemplateBySid(String emailTemplateSid);

    /* EmailSend */

    void sendEmail(EmailMessage fields) throws EmailException;

    void sendEmailAsync(EmailMessage fields) throws JsonProcessingException;

    //处理"EmailCreate"消息
    void onEmailCreate(String content) throws EmailException, JsonProcessingException;

    //处理"EmailCreate"消息
    void onEmailCreate(EmailMessage fields) throws EmailException, JsonProcessingException;

    //处理"EmailSend"消息
    void onEmailSend(String content) throws JsonProcessingException;

    //处理"EmailSend"消息
    void onEmailSend(Email email);

    void retrySendEmails();

    void retrySendEmails(String emailMessageSID, int mailSendRetryCountMax);
}

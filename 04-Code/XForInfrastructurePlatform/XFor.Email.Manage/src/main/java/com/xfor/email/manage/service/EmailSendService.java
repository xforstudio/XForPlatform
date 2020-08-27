package com.xfor.email.manage.service;

import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailSendException;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

/**
 *
 */
@Component
public interface EmailSendService {

    //发送简单邮件
    void sendSimpleMail(String to, String subject, String content);

    //发送Html格式邮件
    void sendMailWithHtml(String from, String to, String subject, String content);

    //发送带附件的邮件
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    //发送带静态资源的邮件
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

    //发送邮件
    void sendEmail(EmailMessage emailMessage, EmailTemplate emailTemplate) throws EmailSendException, IOException, TransformerException;
}

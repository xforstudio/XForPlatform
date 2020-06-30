package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.config.EmailConfig;
import com.xfor.email.manage.config.RabbitMQConfig;
import com.xfor.email.manage.manager.RabbitMQManager;
import com.xfor.infrastructure.core.email.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

@Component
public class EmailSendService {

    private static final Logger _logger = LoggerFactory.getLogger(EmailSendService.class);

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    @Qualifier("ThymeleafEmailTemplateEngineService")
    private IEmailTemplateEngineService emailTemplateEngineService;

    //发送简单邮件
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getMailFrom());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            _logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            _logger.error("发送简单邮件时发生异常！", e);
        }
    }

    //发送Html格式邮件
    public void sendMailWithHtml(String from, String to, String subject, String content) {
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            this.mailSender.send(message);
            _logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            _logger.error("发送html邮件时发生异常！", e);
        }
    }

    //发送带附件的邮件
    public void sendAttachmentsMail(String to, String subject, String content, String filePath){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(this.emailConfig.getMailFrom());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            this.mailSender.send(message);
            _logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            _logger.error("发送带附件的邮件时发生异常！", e);
        }
    }

    //发送带静态资源的邮件
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(this.emailConfig.getMailFrom());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            _logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            _logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }

    //发送邮件
    public void sendEmail(EmailMessage emailMessage, EmailTemplate emailTemplate) throws EmailSendException, IOException, TransformerException {
//        EmailBody emailBody = this.emailTemplateEngineService.getEmailBody(emailMessage, emailTemplate);
//        this.sendMailWithHtml(
//                emailMessage.getFrom(),
//                emailMessage.getTo(),
//                emailMessage.getSubject(),
//                emailBody.getHtmlContent());
    }

}

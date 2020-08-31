package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.service.impl.EmailManageServiceImpl;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.util.IOUtil;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@SpringBootTest
class EmailManageServiceImplTest {

    @Autowired
    private EmailManageServiceImpl emailManageService;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    private EmailMessage doMakeEmailMessage() throws JsonProcessingException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("NAME", "liux");
        map.put("CODE", "FX10000001");
        String emailTemplateData = JsonUtil._objectToString(map);
        EmailMessage fields = EmailMessage._create(
                "597834341@qq.com",
                "3606737347@qq.com",
                "Thymeleaf测试",
                "",
                "ET_TH_0001",
                emailTemplateData,
                dateTimeProvider);
        return fields;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sendEmail() throws EmailException, JsonProcessingException {
        EmailMessage fields = this.doMakeEmailMessage();
        this.emailManageService.sendEmail(fields);
    }

    @Test
    void sendEmailAsync() throws JsonProcessingException {
        EmailMessage fields = this.doMakeEmailMessage();
        this.emailManageService.sendEmailAsync(fields);
    }

    @Test
    void createEmailTemplate() throws FileNotFoundException, UnsupportedEncodingException, EmailException {
        //创建Thymeleaf模板
        String filePath_thymeleaf = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Thymeleaf\\TemplateContent.html";
        String emailTemplateContent_thymeleaf = IOUtil._readAllText(filePath_thymeleaf);
        EmailTemplate fields_thymeleaf = EmailTemplate._create(
                "ET_TH_0001",
                "Thymeleaf模板0001",
                "",
                emailTemplateContent_thymeleaf,
                "",
                EmailTemplateEngineEnum.Thymeleaf,
                this.dateTimeProvider);
        this.emailManageService.createEmailTemplate(fields_thymeleaf);

        //创建Xlst模板
        String filePath_xslt = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Xslt\\TemplateContent.xsl";
        String emailTemplateContent_xslt = IOUtil._readAllText(filePath_xslt);
        EmailTemplate fields_xslt = EmailTemplate._create(
                "ET_XT_0001",
                "Xslt模板0001",
                "",
                emailTemplateContent_xslt,
                "",
                EmailTemplateEngineEnum.Xslt,
                this.dateTimeProvider);
        this.emailManageService.createEmailTemplate(fields_xslt);
    }

    @Test
    void onEmailSend() throws JsonProcessingException {
        EmailMessage emailMessage = this.doMakeEmailMessage();
        EmailAction emailAction = EmailAction._create(emailMessage, this.dateTimeProvider);
        Email email = Email._create(emailMessage, emailAction);
        String content = JsonUtil._objectToString(email);
        //
        this.emailManageService.onEmailSend(content);
    }
}
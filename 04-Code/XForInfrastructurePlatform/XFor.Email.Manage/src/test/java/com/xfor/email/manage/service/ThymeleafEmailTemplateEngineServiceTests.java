package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.util.IOUtil;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import com.xfor.infrastructure.core.email.model.EmailTemplateEngineEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThymeleafEmailTemplateEngineServiceTests {

    @Autowired
    private ThymeleafEmailTemplateEngineService emailTemplateEngineService;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEmailBody() throws JsonProcessingException, FileNotFoundException, UnsupportedEncodingException {
        //数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("NAME", "liux");
        map.put("CODE", "FX10000001");
        String emailTemplateData = JsonUtil._objectToString(map);
        //模板
        String filePath = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Thymeleaf\\TemplateContent.html";
        String emailTemplateContent = IOUtil._readAllText(filePath);
        //
        EmailMessage emailMessage = EmailMessage._create(
                "597834341@qq.com",
                "3606737347@qq.com",
                "Thymeleaf测试",
                "",
                "ET_TH_0001",
                emailTemplateData,
                dateTimeProvider);
        EmailTemplate emailTemplate = EmailTemplate._create(
                "ET_TH_0001",
                "TH模板0001",
                "",
                emailTemplateContent,
                "template.html",
                EmailTemplateEngineEnum.Thymeleaf,
                this.dateTimeProvider);
        //
        EmailBody emailBody = this.emailTemplateEngineService.getEmailBody(emailMessage, emailTemplate);
        String filePath_html = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Thymeleaf\\Publish.html";
        IOUtil._writeAllText(filePath_html, emailBody.getHtmlContent());
    }
}
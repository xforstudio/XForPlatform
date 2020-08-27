package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.service.impl.XsltEmailTemplateEngineServiceImpl;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.util.IOUtil;
import com.xfor.infrastructure.core.email.model.EmailBody;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import com.xfor.infrastructure.core.email.model.EmailTemplateEngineEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class XsltEmailTemplateEngineServiceImplTests {

    @Autowired
    private XsltEmailTemplateEngineServiceImpl emailTemplateEngineService;
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
        String filePath_templateData = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Xslt\\TemplateData.xml";
        String emailTemplateData = IOUtil._readAllText(filePath_templateData);;
        //模板
        String filePath_templateContent = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Xslt\\TemplateContent.xsl";
        String emailTemplateContent = IOUtil._readAllText(filePath_templateContent);
        //
        EmailMessage emailMessage = EmailMessage._create(
                "597834341@qq.com",
                "3606737347@qq.com",
                "Xslt测试",
                "",
                "ET_XT_0001",
                emailTemplateData,
                dateTimeProvider);
        EmailTemplate emailTemplate = EmailTemplate._create(
                "ET_XT_0001",
                "XT模板0001",
                "",
                emailTemplateContent,
                "",
                EmailTemplateEngineEnum.Xslt,
                this.dateTimeProvider);
        EmailBody emailBody = this.emailTemplateEngineService.getEmailBody(emailMessage, emailTemplate);
        String filePath_html = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.Email.Manage\\Xslt\\Publish.html";
        IOUtil._ensureFileDelete(filePath_html);
        IOUtil._writeAllText(filePath_html, emailBody.getHtmlContent());
    }
}
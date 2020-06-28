package com.xfor.email.manage.service;

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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class XsltEmailTemplateEngineServiceTests {

    @Autowired
    private XsltEmailTemplateEngineService emailTemplateEngineService;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEmailBody() {

        String emailTemplateContent = "";
        EmailTemplate emailTemplate = EmailTemplate._create(
                "ET_XT_0001",
                "Xsl模板0001",
                "",
                emailTemplateContent,
                "",
                EmailTemplateEngineEnum.Xslt,
                this.dateTimeProvider);
        String emailTemplateData = "";
        EmailMessage emailMessage = EmailMessage._create(
                "597834341@qq.com",
                "",
                "XSLT测试",
                "",
                "ET_XT_0001",
                emailTemplateData,
                this.dateTimeProvider);
        EmailBody emailBody = this.emailTemplateEngineService.getEmailBody(emailMessage, emailTemplate);
        String htmlContent = emailBody.getHtmlContent();
        //
        //TODO:保存为html文件
    }
}
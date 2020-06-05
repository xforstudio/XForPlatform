package com.xfor.email.manage.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailSendServiceTests {

    @Autowired
    private EmailSendService emailSendService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sendSimpleMail() {
        String mailTo = "liux1@mail.neea.edu.cn";
        String mailSubject = "MailTestFromQQ";
        String mailContent = "这是一个来自QQ的测试邮件";
        //
        this.emailSendService.sendSimpleMail(mailTo, mailSubject, mailContent);
        //
        Assert.isTrue(true, "");
    }
}
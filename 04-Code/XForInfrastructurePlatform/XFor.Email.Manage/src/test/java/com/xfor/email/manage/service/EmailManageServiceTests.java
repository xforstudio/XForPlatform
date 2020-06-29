package com.xfor.email.manage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.email.model.EmailException;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailManageServiceTests {

    @Autowired
    private EmailManageService emailManageService;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sendEmail() throws EmailException {
        EmailMessage fields = EmailMessage._create(
                "",
                "",
                "",
                "",
                "",
                "",
                this.dateTimeProvider);
        this.emailManageService.sendEmail(fields);
    }

    @Test
    void sendEmailAsync() throws JsonProcessingException {
        EmailMessage fields = EmailMessage._create(
                "",
                "",
                "",
                "",
                "",
                "",
                this.dateTimeProvider);
        this.emailManageService.sendEmailAsync(fields);
    }
}
package com.xfor.email.manage.manager;

import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailQueueManagerTests {

    @Autowired
    private EmailQueueManager emailQueueManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sendEmail() {
        EmailMessage emailMsg = new EmailMessage();
        emailMsg.setSid("email_message_0001");
        //
        this.emailQueueManager.sendEmail(emailMsg);
        //
        Assert.isTrue(true, "");
    }
}
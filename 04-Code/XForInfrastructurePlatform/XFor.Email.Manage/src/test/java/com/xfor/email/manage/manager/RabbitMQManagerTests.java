package com.xfor.email.manage.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.email.model.Email;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RabbitMQManagerTests {

    @Autowired
    private RabbitMQManager rabbitMQManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sendEmail() throws JsonProcessingException {
        EmailMessage emailMsg = new EmailMessage();
        emailMsg.setSid("email_message_0001");
        Email email = new Email();
        email.setEmailMessage(emailMsg);
        String queueName = "";
        //
        this.rabbitMQManager.sendMessage(queueName, email);
        //
        Assert.isTrue(true, "");
    }
}
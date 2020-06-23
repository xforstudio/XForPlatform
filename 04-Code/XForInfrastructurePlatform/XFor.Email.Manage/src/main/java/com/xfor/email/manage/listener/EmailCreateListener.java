package com.xfor.email.manage.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.config.RabbitMQConfig;
import com.xfor.email.manage.manager.RabbitMQManager;
import com.xfor.email.manage.service.EmailManageService;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.Email;
import com.xfor.infrastructure.core.email.model.EmailAction;
import com.xfor.infrastructure.core.email.model.EmailException;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "XFor.MQ.Email.Create")
@Component
public class EmailCreateListener {

    private static final Logger _logger = LoggerFactory.getLogger(EmailCreateListener.class);

    @Autowired
    private EmailManageService emailManageService;

    @RabbitHandler
    public void onReceiveMessage(String content) throws JsonProcessingException, EmailException {
        this.emailManageService.onEmailCreate(content);
    }
}

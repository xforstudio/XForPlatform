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

import java.text.DateFormat;
import java.util.Date;

@RabbitListener(queues = "XFor.MQ.Email.Create")
@Component
public class EmailCreateListener {

    private static final Logger _logger = LoggerFactory.getLogger(EmailCreateListener.class);

    @Autowired
    private EmailManageService emailManageService;
    @Autowired
    private DateFormat dateFormat;

    @RabbitHandler
    public void onReceiveMessage(String content) throws JsonProcessingException, EmailException {
        //响应"EmailCreate"消息
        _logger.info("开始EmailCreateListener  " + this.dateFormat.format(new Date()));
        this.emailManageService.onEmailCreate(content);
        _logger.info("结束EmailCreateListener  " + this.dateFormat.format(new Date()));
    }
}

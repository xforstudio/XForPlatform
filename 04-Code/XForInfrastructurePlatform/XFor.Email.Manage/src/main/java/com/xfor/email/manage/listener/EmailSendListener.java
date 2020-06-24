package com.xfor.email.manage.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.service.EmailManageService;
import com.xfor.email.manage.service.EmailSendService;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.Email;
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

/**
 *
 */
@RabbitListener(queues = "XFor.MQ.Email.Send")
@Component
public class EmailSendListener {

    private static final Logger _logger = LoggerFactory.getLogger(EmailSendListener.class);

    @Autowired
    private EmailManageService emailManageService;
    @Autowired
    private DateFormat dateFormat;

    @RabbitHandler
    public void onReceiveMessage(String content) throws JsonProcessingException {
        //响应"EmailSend"消息
        _logger.info("开始EmailSendListener  " + this.dateFormat.format(new Date()));
        this.emailManageService.onEmailSend(content);
        _logger.info("结束EmailSendListener  " + this.dateFormat.format(new Date()));
    }
}

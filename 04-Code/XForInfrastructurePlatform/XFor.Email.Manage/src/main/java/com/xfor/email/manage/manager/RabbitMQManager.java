package com.xfor.email.manage.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.email.manage.config.RabbitMQConfig;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
//@RabbitListener(queues = "XFor.Email.MQ")
@Component
public class RabbitMQManager {

    @Autowired
    private RabbitMQConfig rabbitConfig;
    @Autowired
    private AmqpTemplate rabbitTemplate;

//    public void sendEmail(EmailMessage emailMessage) throws JsonProcessingException {
//        System.out.println("Sender: " + emailMessage.getSid());
//        String queueName = rabbitConfig.getEmailQueueName();
//        String content = JsonUtil._objectToString(emailMessage);
//        this.rabbitTemplate.convertAndSend(queueName, content);
//    }

//    @RabbitHandler
//    public void onReceiveEmail(String emailMessageContent) throws JsonProcessingException {
//        System.out.println("Receiver: " + emailMessageContent);
//        EmailMessage emailMessage = JsonUtil._stringToObject(emailMessageContent, EmailMessage.class);
//        System.out.println("Receiver: " + emailMessage.getSid());
//    }

    public void sendMessage(String queueName, String content) {
        this.rabbitTemplate.convertAndSend(queueName, content);
    }

    public void sendMessage(String queueName, Object obj) throws JsonProcessingException {
        String content = JsonUtil._objectToString(obj);
        this.rabbitTemplate.convertAndSend(queueName, content);
    }
}

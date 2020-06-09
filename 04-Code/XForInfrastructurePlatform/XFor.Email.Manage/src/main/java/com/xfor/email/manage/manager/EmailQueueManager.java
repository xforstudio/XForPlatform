package com.xfor.email.manage.manager;

import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@RabbitListener(queues = "XFor.Email.MQ")
@Component
public class EmailQueueManager {

    @Autowired
    private RabbitMQConfig rabbitConfig;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendEmail(EmailMessage emailMessage) {
        System.out.println("Sender: " + emailMessage.getSid());
        this.rabbitTemplate.convertAndSend(rabbitConfig.getEmailQueueName(), emailMessage);
    }

    @RabbitHandler
    public void onReceiveEmail(EmailMessage emailMessage) {
        System.out.println("Receiver: " + emailMessage.getSid());
    }
}

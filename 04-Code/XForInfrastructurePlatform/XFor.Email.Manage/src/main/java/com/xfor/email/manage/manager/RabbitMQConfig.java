package com.xfor.email.manage.manager;

import lombok.Data;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
public class RabbitMQConfig {

    //@Value("${xfor.email.mq.name}")
    private String emailQueueName = "XFor.Email.MQ";

    @Bean
    public Queue Queue() {
        return new Queue(this.emailQueueName);
    }

}

package com.xfor.email.manage.config;

import lombok.Data;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
public class RabbitMQConfig {

    //@Value("${xfor.email.mq.name}")
    private String queueNameEmailCreate = "XFor.MQ.Email.Create";

    private String queueNameEmailSend = "XFor.MQ.Email.Send";

    @Bean
    public Queue queueEmailCreate() {
        return new Queue(this.queueNameEmailCreate);
    }

    @Bean
    public Queue queueEmailSend() {
        return new Queue(this.queueNameEmailSend);
    }

}

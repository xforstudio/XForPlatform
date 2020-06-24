package com.xfor.email.manage.config;

import com.xfor.email.manage.job.EmailSendJob;
import com.xfor.email.manage.job.EmailSendRetryJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetailEmailSend(){
        return JobBuilder.newJob(EmailSendJob.class).storeDurably().build();
    }

    @Bean
    public Trigger triggerEmailSend(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailEmailSend())
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail jobDetailEmailSendRetry(){
        return JobBuilder.newJob(EmailSendRetryJob.class).storeDurably().build();
    }

    @Bean
    public Trigger triggerEmailSendRetry(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailEmailSend())
                .withSchedule(scheduleBuilder)
                .build();
    }
}

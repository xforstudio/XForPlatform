package com.xfor.email.manage.config;

import com.xfor.email.manage.job.EmailSendJob;
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
}

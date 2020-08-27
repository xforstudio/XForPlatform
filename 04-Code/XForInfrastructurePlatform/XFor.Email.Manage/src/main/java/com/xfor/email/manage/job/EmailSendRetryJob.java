package com.xfor.email.manage.job;

import com.xfor.email.manage.service.EmailManageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.DateFormat;
import java.util.Date;

/**
 * 邮件发送重试定时任务
 */
public class EmailSendRetryJob extends QuartzJobBean {

    private static final Logger _logger = LoggerFactory.getLogger(EmailSendRetryJob.class);

    @Autowired
    private EmailManageService emailManageService;
    @Autowired
    private DateFormat dateFormat;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //重试发送邮件
        _logger.info("开始EmailSendRetryJob  " + this.dateFormat.format(new Date()));
        this.emailManageService.retrySendEmails();
        _logger.info("结束EmailSendRetryJob  " + this.dateFormat.format(new Date()));
    }
}

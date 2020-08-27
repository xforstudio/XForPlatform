package com.xfor.email.manage.job;

import com.xfor.email.manage.service.EmailManageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.DateFormat;

/**
 * 邮件发送定时任务
 */
public class EmailSendJob extends QuartzJobBean {

    @Autowired
    private EmailManageService emailManageService;
    @Autowired
    private DateFormat dateFormat;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("EmailSendJob ---- " + sdf.format(new Date()));
    }
}

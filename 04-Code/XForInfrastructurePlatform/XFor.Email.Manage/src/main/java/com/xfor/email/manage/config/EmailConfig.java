package com.xfor.email.manage.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Data
@Component
public class EmailConfig {

    //@Value("${xfor.email.from.addr}")
    private String mailFrom = "597834341@qq.com";

    //发送失败重试次数上限
    private int mailSendRetryCountMax = 3;

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}

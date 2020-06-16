package com.xfor.email.manage.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmailConfig {

    //@Value("${xfor.email.from.addr}")
    private String mailFrom = "597834341@qq.com";
}

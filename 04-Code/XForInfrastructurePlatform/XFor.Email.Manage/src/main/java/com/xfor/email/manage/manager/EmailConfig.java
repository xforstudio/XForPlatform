package com.xfor.email.manage.manager;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmailConfig {

    //@Value("${mail.fromMail.addr}")
    private String mailFrom = "597834341@qq.com";
}

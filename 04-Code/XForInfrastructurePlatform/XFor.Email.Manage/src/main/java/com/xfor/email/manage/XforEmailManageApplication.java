package com.xfor.email.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xfor"})
public class XforEmailManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforEmailManageApplication.class, args);
    }

}

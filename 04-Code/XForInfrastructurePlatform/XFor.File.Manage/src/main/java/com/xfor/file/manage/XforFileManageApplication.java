package com.xfor.file.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xfor"})
public class XforFileManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforFileManageApplication.class, args);
    }

}

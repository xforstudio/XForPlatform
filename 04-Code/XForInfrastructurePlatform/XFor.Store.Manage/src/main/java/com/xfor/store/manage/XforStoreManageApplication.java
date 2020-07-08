package com.xfor.store.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xfor"})
public class XforStoreManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforStoreManageApplication.class, args);
    }

}

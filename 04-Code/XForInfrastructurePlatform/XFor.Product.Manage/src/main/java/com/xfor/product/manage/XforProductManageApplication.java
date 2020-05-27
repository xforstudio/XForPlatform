package com.xfor.product.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xfor"})
public class XforProductManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforProductManageApplication.class, args);
    }

}

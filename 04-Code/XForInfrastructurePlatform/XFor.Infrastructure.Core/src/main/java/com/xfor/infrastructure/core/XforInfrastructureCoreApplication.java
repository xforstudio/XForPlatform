package com.xfor.infrastructure.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class XforInfrastructureCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforInfrastructureCoreApplication.class, args);
    }

}


//@SpringBootApplication(scanBasePackages = {"com.xfor"})
//public class XforPassportManageApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(XforPassportManageApplication.class);
//    }
//
//    public static void main(String[] args) {
//
//        //Boolean result = StringUtil._isNullOrWhiteSpace("abc");
//
//        SpringApplication.run(XforPassportManageApplication.class, args);
//    }
//
//}

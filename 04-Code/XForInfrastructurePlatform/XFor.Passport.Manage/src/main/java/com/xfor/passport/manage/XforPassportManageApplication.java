package com.xfor.passport.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.xfor"})
//@PropertySource(value = "classpath:application-passport.properties")
public class XforPassportManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(XforPassportManageApplication.class, args);
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

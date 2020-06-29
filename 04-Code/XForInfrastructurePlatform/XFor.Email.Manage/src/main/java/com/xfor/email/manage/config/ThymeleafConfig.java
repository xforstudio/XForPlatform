package com.xfor.email.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean("springTemplateEngine")
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //方言
        IDialect springStandardDialect = new SpringStandardDialect();
        templateEngine.setDialect(springStandardDialect);
        //字符串解析器
        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setCacheable(true);  //使用缓存
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);
        //
        return templateEngine;
    }
}

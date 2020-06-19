package com.xfor.infrastructure.core.email.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import com.xfor.infrastructure.core.email.repository.IEmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisEmailTemplateRepository implements IEmailTemplateRepository {

    @Autowired
    private IEmailTemplateMyBatisDAO emailTemplateMyBatisDAO;

    public MyBatisEmailTemplateRepository() {
    }

    @Override
    public EmailTemplate getEmailTemplateBySid(ServiceContext sctx, String sid) {
        return null;
    }

    @Override
    public boolean saveEmailTemplate(ServiceContext sctx, EmailTemplate emailTemplate) {
        return false;
    }
}

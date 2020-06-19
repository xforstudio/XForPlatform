package com.xfor.infrastructure.core.email.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.repository.IEmailMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisEmailMessageRepository implements IEmailMessageRepository {

    @Autowired
    private IEmailMessageMyBatisDAO emailMessageMyBatisDAO;

    public MyBatisEmailMessageRepository() {
    }

    @Override
    public EmailMessage getEmailMessageBySid(ServiceContext sctx, String sid) {
        return null;
    }

    @Override
    public boolean saveEmailMessage(ServiceContext sctx, EmailMessage emailMessage) {
        return false;
    }
}

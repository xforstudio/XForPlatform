package com.xfor.infrastructure.core.email.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailAction;
import com.xfor.infrastructure.core.email.repository.IEmailActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisEmailActionRepository implements IEmailActionRepository {

    @Autowired
    private IEmailActionMyBatisDAO emailSendMyBatisDAO;

    public MyBatisEmailActionRepository() {
    }

    @Override
    public EmailAction getEmailActionBySid(ServiceContext sctx, String sid) {
        return null;
    }

    @Override
    public boolean saveEmailAction(ServiceContext sctx, EmailAction emailAction) {
        return false;
    }
}

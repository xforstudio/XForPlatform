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
        EmailMessage result = this.emailMessageMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public boolean saveEmailMessage(ServiceContext sctx, EmailMessage emailMessage) {
        int result = this.emailMessageMyBatisDAO.updateById(emailMessage);
        if(result <= 0) {
            result = this.emailMessageMyBatisDAO.insert(emailMessage);
        }
        return result > 0;
    }

    @Override
    public boolean removeEmailMessageBySid(ServiceContext sctx, String sid) {
        int result = this.emailMessageMyBatisDAO.deleteById(sid);
        return result > 0;
    }
}

package com.xfor.infrastructure.core.email.dao.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import com.xfor.infrastructure.core.email.dao.EmailMessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class EmailMessageDAOImpl implements EmailMessageDAO {

    @Autowired
    private EmailMessageRepository emailMessageRepository;

    @Override
    public EmailMessage getEmailMessageBySid(ServiceContext sctx, String sid) {
        EmailMessage result = this.emailMessageRepository.selectById(sid);
        return result;
    }

    @Override
    public boolean saveEmailMessage(ServiceContext sctx, EmailMessage emailMessage) {
        int result = this.emailMessageRepository.updateById(emailMessage);
        if(result <= 0) {
            result = this.emailMessageRepository.insert(emailMessage);
        }
        return result > 0;
    }

    @Override
    public boolean removeEmailMessageBySid(ServiceContext sctx, String sid) {
        int result = this.emailMessageRepository.deleteById(sid);
        return result > 0;
    }
}

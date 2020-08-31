package com.xfor.infrastructure.core.email.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailAction;
import com.xfor.infrastructure.core.email.dao.EmailActionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class EmailActionDAOImpl implements EmailActionDAO {

    @Autowired
    private EmailActionRepository emailActionRepository;

    @Override
    public EmailAction getEmailActionBySid(ServiceContext sctx, String sid) {
        EmailAction result = this.emailActionRepository.selectById(sid);
        return result;
    }

    @Override
    public EmailAction getEmailActionByEmailMessageSid(ServiceContext sctx, String emailMessageSid) {
        QueryWrapper<EmailAction> wrapper = new QueryWrapper<>();
        wrapper.eq("EMAIL_MESSAGE_SID", emailMessageSid);
        EmailAction result = this.emailActionRepository.selectOne(wrapper);
        return result;
    }

    @Override
    public boolean saveEmailAction(ServiceContext sctx, EmailAction emailAction) {
        int result = this.emailActionRepository.updateById(emailAction);
        if(result <= 0) {
            result = this.emailActionRepository.insert(emailAction);
        }
        return result > 0;
    }

    @Override
    public boolean removeEmailActionBySid(ServiceContext sctx, String sid) {
        int result = this.emailActionRepository.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeEmailActionByEmailMessageSid(ServiceContext sctx, String emailMessageSid) {
        QueryWrapper<EmailAction> wrapper = new QueryWrapper<>();
        wrapper.eq("EMAIL_MESSAGE_SID", emailMessageSid);
        int result = this.emailActionRepository.delete(wrapper);
        return result > 0;
    }
}

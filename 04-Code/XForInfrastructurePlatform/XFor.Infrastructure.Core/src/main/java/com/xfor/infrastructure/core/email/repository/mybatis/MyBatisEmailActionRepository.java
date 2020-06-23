package com.xfor.infrastructure.core.email.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailAction;
import com.xfor.infrastructure.core.email.repository.IEmailActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisEmailActionRepository implements IEmailActionRepository {

    @Autowired
    private IEmailActionMyBatisDAO emailActionMyBatisDAO;

    public MyBatisEmailActionRepository() {
    }

    @Override
    public EmailAction getEmailActionBySid(ServiceContext sctx, String sid) {
        EmailAction result = this.emailActionMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public EmailAction getEmailActionByEmailMessageSid(ServiceContext sctx, String emailMessageSid) {
        QueryWrapper<EmailAction> wrapper = new QueryWrapper<>();
        wrapper.eq("EMAIL_MESSAGE_SID", emailMessageSid);
        EmailAction result = this.emailActionMyBatisDAO.selectOne(wrapper);
        return result;
    }

    @Override
    public boolean saveEmailAction(ServiceContext sctx, EmailAction emailAction) {
        int result = this.emailActionMyBatisDAO.updateById(emailAction);
        if(result <= 0) {
            result = this.emailActionMyBatisDAO.insert(emailAction);
        }
        return result > 0;
    }

    @Override
    public boolean removeEmailActionBySid(ServiceContext sctx, String sid) {
        int result = this.emailActionMyBatisDAO.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeEmailActionByEmailMessageSid(ServiceContext sctx, String emailMessageSid) {
        QueryWrapper<EmailAction> wrapper = new QueryWrapper<>();
        wrapper.eq("EMAIL_MESSAGE_SID", emailMessageSid);
        int result = this.emailActionMyBatisDAO.delete(wrapper);
        return result > 0;
    }
}

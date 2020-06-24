package com.xfor.infrastructure.core.email.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        EmailTemplate result = this.emailTemplateMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public EmailTemplate getEmailTemplateByCode(ServiceContext sctx, String code) {
        QueryWrapper<EmailTemplate> wrapper = new QueryWrapper<>();
        wrapper.eq("CODE", code);
        EmailTemplate result = this.emailTemplateMyBatisDAO.selectOne(wrapper);
        return result;
    }


    @Override
    public boolean saveEmailTemplate(ServiceContext sctx, EmailTemplate emailTemplate) {
        int result = this.emailTemplateMyBatisDAO.updateById(emailTemplate);
        if(result <= 0) {
            result = this.emailTemplateMyBatisDAO.insert(emailTemplate);
        }
        return result > 0;
    }

    @Override
    public boolean removeEmailTemplateBySid(ServiceContext sctx, String sid) {
        int result = this.emailTemplateMyBatisDAO.deleteById(sid);
        return result > 0;
    }
}

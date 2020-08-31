package com.xfor.infrastructure.core.email.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import com.xfor.infrastructure.core.email.dao.EmailTemplateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class EmailTemplateDAOImpl implements EmailTemplateDAO {

    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    @Override
    public EmailTemplate getEmailTemplateBySid(ServiceContext sctx, String sid) {
        EmailTemplate result = this.emailTemplateRepository.selectById(sid);
        return result;
    }

    @Override
    public EmailTemplate getEmailTemplateByCode(ServiceContext sctx, String code) {
        QueryWrapper<EmailTemplate> wrapper = new QueryWrapper<>();
        wrapper.eq("CODE", code);
        EmailTemplate result = this.emailTemplateRepository.selectOne(wrapper);
        return result;
    }


    @Override
    public boolean saveEmailTemplate(ServiceContext sctx, EmailTemplate emailTemplate) {
        int result = this.emailTemplateRepository.updateById(emailTemplate);
        if(result <= 0) {
            result = this.emailTemplateRepository.insert(emailTemplate);
        }
        return result > 0;
    }

    @Override
    public boolean removeEmailTemplateBySid(ServiceContext sctx, String sid) {
        int result = this.emailTemplateRepository.deleteById(sid);
        return result > 0;
    }
}

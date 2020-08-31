package com.xfor.infrastructure.core.email.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface EmailTemplateDAO {

    EmailTemplate getEmailTemplateBySid(ServiceContext sctx, String sid);

    EmailTemplate getEmailTemplateByCode(ServiceContext sctx, String code);

    boolean saveEmailTemplate(ServiceContext sctx, EmailTemplate emailTemplate);

    boolean removeEmailTemplateBySid(ServiceContext sctx, String sid);
}

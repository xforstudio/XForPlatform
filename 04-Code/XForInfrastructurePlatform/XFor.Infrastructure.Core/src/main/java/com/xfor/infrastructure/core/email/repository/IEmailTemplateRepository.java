package com.xfor.infrastructure.core.email.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface IEmailTemplateRepository {

    EmailTemplate getEmailTemplateBySid(ServiceContext sctx, String sid);

    boolean saveEmailTemplate(ServiceContext sctx, EmailTemplate emailTemplate);
}

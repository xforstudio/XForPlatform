package com.xfor.infrastructure.core.email.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailMessage;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface EmailMessageDAO {

    EmailMessage getEmailMessageBySid(ServiceContext sctx, String sid);

    boolean saveEmailMessage(ServiceContext sctx, EmailMessage emailMessage);

    boolean removeEmailMessageBySid(ServiceContext sctx, String sid);
}

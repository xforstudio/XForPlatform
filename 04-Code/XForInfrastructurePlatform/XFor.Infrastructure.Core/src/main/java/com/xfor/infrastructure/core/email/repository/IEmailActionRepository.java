package com.xfor.infrastructure.core.email.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.email.model.EmailAction;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface IEmailActionRepository {

    EmailAction getEmailActionBySid(ServiceContext sctx, String sid);

    EmailAction getEmailActionByEmailMessageSid(ServiceContext sctx, String emailMessageSid);

    boolean saveEmailAction(ServiceContext sctx, EmailAction emailAction);

    boolean removeEmailActionBySid(ServiceContext sctx, String sid);

    boolean removeEmailActionByEmailMessageSid(ServiceContext sctx, String emailMessageSid);
}

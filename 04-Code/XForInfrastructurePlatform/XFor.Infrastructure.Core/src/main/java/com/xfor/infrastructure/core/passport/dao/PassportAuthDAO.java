package com.xfor.infrastructure.core.passport.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface PassportAuthDAO {

    String getLoginTokenByPassportAuthCode(ServiceContext sctx, String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(ServiceContext sctx, String loginToken, String categoryID);
}

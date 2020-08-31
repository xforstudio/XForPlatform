package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.dao.PassportAuthDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PassportAuthDAOImpl implements PassportAuthDAO {

    @Autowired
    private PassportAuthRepository passportAuthRepository;

    public String getLoginTokenByPassportAuthCode(
            ServiceContext sctx,
            String passportAuthCode,
            String categoryID) {
        //throw new UnsupportedOperationException();
        String loginToken = this.passportAuthRepository.findLoginTokenByPassportAuthCodeAndCategoryID(
                passportAuthCode,
                categoryID);
        return loginToken;
    }

    public String getPassportAuthCodeByLoginToken(
            ServiceContext sctx,
            String loginToken,
            String categoryID) {
        //throw new UnsupportedOperationException();
        String passportAuthCode = this.passportAuthRepository.findPassportAuthCodeByLoginTokenAndCategoryID(
                loginToken,
                categoryID);
        return passportAuthCode;
    }
}

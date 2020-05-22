package com.xfor.infrastructure.core.passport.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisPassportAuthRepository implements IPassportAuthRepository {

    @Autowired
    private IPassportAuthMyBatisDAO passportAuthMyBatisDAO;

    public MyBatisPassportAuthRepository() {
    }

    public String getLoginTokenByPassportAuthCode(
            ServiceContext sctx,
            String passportAuthCode,
            String categoryID) {
        //throw new UnsupportedOperationException();
        String loginToken = this.passportAuthMyBatisDAO.findLoginTokenByPassportAuthCodeAndCategoryID(
                passportAuthCode,
                categoryID);
        return loginToken;
    }

    public String getPassportAuthCodeByLoginToken(
            ServiceContext sctx,
            String loginToken,
            String categoryID) {
        //throw new UnsupportedOperationException();
        String passportAuthCode = this.passportAuthMyBatisDAO.findPassportAuthCodeByLoginTokenAndCategoryID(
                loginToken,
                categoryID);
        return passportAuthCode;
    }
}

package com.xfor.passport.manage.service.impl;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.dao.PassportAuthCategoryDAO;
import com.xfor.infrastructure.core.passport.dao.PassportAuthDAO;
import com.xfor.passport.manage.service.PassportAuthManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassportAuthManageServiceImpl extends BaseService implements PassportAuthManageService {

    @Autowired
    private PassportAuthDAO passportAuthRepository;
    @Autowired
    private PassportAuthCategoryDAO passportAuthCategoryRepository;

    @Override
    public String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID) {
        ServiceContext sctx = this.doGetServiceContext();
        String result = this.passportAuthRepository.getLoginTokenByPassportAuthCode(
                sctx,
                passportAuthCode,
                categoryID);
        return result;
    }

    @Override
    public String getPassportAuthCodeByLoginToken(String loginToken, String categoryID) {
        ServiceContext sctx = this.doGetServiceContext();
        String result = this.passportAuthRepository.getPassportAuthCodeByLoginToken(
                sctx,
                loginToken,
                categoryID);
        return result;
    }
}

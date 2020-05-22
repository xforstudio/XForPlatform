package com.xfor.passport.manage.service;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthCategoryRepository;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportAuthManageService extends BaseService {

    @Autowired
    private IPassportAuthRepository passportAuthRepository;
    @Autowired
    private IPassportAuthCategoryRepository passportAuthCategoryRepository;

    public PassportAuthManageService() {
        super();
    }

    public String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID) {
        ServiceContext sctx = this.doGetServiceContext();
        String result = this.passportAuthRepository.getLoginTokenByPassportAuthCode(
                sctx,
                passportAuthCode,
                categoryID);
        return result;
    }

    public String getPassportAuthCodeByLoginToken(String loginToken, String categoryID) {
        ServiceContext sctx = this.doGetServiceContext();
        String result = this.passportAuthRepository.getPassportAuthCodeByLoginToken(
                sctx,
                loginToken,
                categoryID);
        return result;
    }
}

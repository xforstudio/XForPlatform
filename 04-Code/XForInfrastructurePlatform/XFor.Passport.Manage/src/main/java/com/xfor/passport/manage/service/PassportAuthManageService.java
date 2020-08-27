package com.xfor.passport.manage.service;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthCategoryRepository;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface PassportAuthManageService {

    String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(String loginToken, String categoryID);
}

package com.xfor.passport.manage.service;

import org.springframework.stereotype.Component;

@Component
public interface PassportAuthManageService {

    String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(String loginToken, String categoryID);
}

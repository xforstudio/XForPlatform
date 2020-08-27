package com.xfor.passport.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.model.TextCaptcha;
import com.xfor.infrastructure.core.common.service.*;
import com.xfor.infrastructure.core.passport.model.*;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthCategoryRepository;
import com.xfor.infrastructure.core.passport.repository.IPassportAuthRepository;
import com.xfor.infrastructure.core.passport.repository.IPassportIDRepository;
import com.xfor.infrastructure.core.passport.repository.IPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface PassportManageService {

    //判断登录标识是否有效
    boolean isLoginTokenValid(String loginToken);

    void verifyLoginToken(String loginToken) throws PassportException;

    void clearLoginTokens(int durationLimit);

    //凭据密码登录
    PassportLoginSession loginByCredAndPwd(String credential, String password) throws PassportException;

    //短信验证码登录
    PassportLoginSession loginBySms(String mobile, String captcha) throws PassportException;

    //登出
    void logout(String loginToken) throws PassportException;

    //发送短信验证码
    void sendSmsCaptchaWithLogin(String mobile);

    //通行证注册
    void registPassport(PassportRegist passportRegist) throws PassportException;

    //重置密码（手机认证）
    void resetPasswordWithMobile(String newPwd, String mobile, String captcha) throws PassportException;

    //重置密码（邮箱认证）
    void resetPasswordWithEmail(String newPwd, String email, String captcha) throws PassportException;

    //发送重置密码短信验证码
    void sendSmsCaptchaWithResetPassword(String mobile);

    //发送重置密码邮件验证码
    void sendEmailCaptchaWithResetPassword(String email);

    Passport getPassportByPassportSID(String passportSID);

    String getPassportSIDByLoginToken(String loginToken);

    Passport getPassportByLoginToken(String loginToken);

    //设置用户信息
    void setPassportUser(PassportUser passportUser) throws PassportException;

    //设置用户名
    void setUsername(PassportCredential passportCredential) throws PassportException;

    //设置手机
    void setMobile(PassportCredential passportCredential) throws PassportException;

    //发送设置手机短信验证码
    void sendSmsCaptchaWithSetMobile(String mobile);

    //设置邮箱
    void setEmail(PassportCredential passportCredential) throws PassportException;

    //发送设置邮箱邮件验证码
    void sendEmailCaptchaWithSetEmail(String email);

    //设置密码
    void setPassword(String passportSID, String pwdNew);

    String getLoginTokenByPassportAuthCode(String passportAuthCode, String categoryID);

    String getPassportAuthCodeByLoginToken(String loginToken, String categoryID);
}

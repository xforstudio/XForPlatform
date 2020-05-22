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
import org.springframework.stereotype.Service;

@Service
public class PassportManageService extends BaseService {

    @Autowired
    private IPassportRepository passportRepository;
    @Autowired
    private IPassportAuthRepository passportAuthRepository;
    @Autowired
    private IPassportAuthCategoryRepository passportAuthCategoryRepository;
    @Autowired
    private IPassportIDRepository passportIDRepository;
    @Autowired
    private ISmsService smsService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private ITextCaptchaLogService textCaptchaLogService;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    public PassportManageService() {
        super();
    }

    //发送短信验证码
    protected void doSendSmsCaptcha(String mobile, String category) {
        //发送验证码
        String captcha = TextCaptcha._newNumCode();
        this.smsService.send(mobile, captcha);
        this.textCaptchaLogService.setCaptcha(category, mobile, captcha);
    }

    //发送邮件验证码
    protected void doSendEmailCaptcha(String email, String category) {
        //发送验证码
        String captcha = TextCaptcha._newNumCode();
        this.emailService.send(email, captcha);
        this.textCaptchaLogService.setCaptcha(category, email, captcha);
    }

    //判断登录标识是否有效
    public boolean isLoginTokenValid(String loginToken) {
        ServiceContext sctx = this.doGetServiceContext();
        Boolean isValid = this.passportRepository.existsLoginToken(sctx, loginToken);
        return isValid;
    }

    public void verifyLoginToken(String loginToken) throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        Boolean isValid = this.passportRepository.existsLoginToken(sctx, loginToken);
        if (!isValid) {
            throw new PassportException("会话标识无效");
        }
    }

    public void clearLoginTokens(int durationLimit) {
        return;
    }

    //凭据密码登录
    public PassportLoginSession loginByCredAndPwd(String credential, String password)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //获取Passport
        Passport passport = this.passportRepository.getPassportByCredential(sctx, credential);
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //验证密码
        if (!passport.matchPassword(password)) {
            throw new PassportException("密码错误");
        }
        //登录
        PassportLoginSession loginSession = passport.login(this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
        //
        return loginSession;
    }

    //短信验证码登录
    public PassportLoginSession loginBySms(String mobile, String captcha)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //检查验证码
        String captcha_pre = this.textCaptchaLogService.pickCaptcha("_login", mobile);
        if (captcha == null || captcha != captcha_pre) {
            throw new PassportException("验证码无效");
        }
        //获取通行证
        Passport passport = this.passportRepository.getPassportByMobile(sctx, mobile);
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //登录
        PassportLoginSession loginSession = passport.login(this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
        //
        return loginSession;
    }

    //登出
    public void logout(String loginToken)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportByLoginToken(sctx, loginToken);
        if (passport == null) {
            throw new PassportException("登录会话标识无效");
        }
        //登出
        passport.logout(loginToken);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //发送短信验证码
    public void sendSmsCaptchaWithLogin(String mobile) {
        this.doSendSmsCaptcha(mobile,"_login");
    }

    //通行证注册
    public void registPassport(PassportRegist passportRegist)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //有效性验证
        passportRegist.validate();
        //业务验证（手机）
        if (passportRegist.isMobileSet()) {
            boolean existsMobile = this.passportRepository.existsMobile(sctx, passportRegist.getMobile());
            if (existsMobile) {
                throw new PassportException("手机号已存在");
            }
        }
        //业务验证（邮箱）
        if (passportRegist.isEmailSet()) {
            boolean existsEmail = this.passportRepository.existsEmail(sctx, passportRegist.getEmail());
            if (existsEmail) {
                throw new PassportException("邮箱已存在");
            }
        }
        //创建通行证
        Passport passport = passportRegist.createPassport(this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //重置密码（手机认证）
    public void resetPasswordWithMobile(String newPwd, String mobile, String captcha)
            throws PassportException {
        //检查验证码
        String captcha_pre = this.textCaptchaLogService.pickCaptcha("_reset_pwd_mobile", mobile);
        if (captcha == null || captcha != captcha_pre) {
            throw new PassportException("验证码无效");
        }
        //
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportByMobile(sctx, mobile);
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //设置密码
        passport.setPassword(newPwd, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //重置密码（邮箱认证）
    public void resetPasswordWithEmail(String newPwd, String email, String captcha)
            throws PassportException {
        //检查验证码
        String captcha_pre = this.textCaptchaLogService.pickCaptcha("_reset_pwd_email", email);
        if (captcha == null || captcha != captcha_pre) {
            throw new PassportException("验证码无效");
        }
        //
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportByEmail(sctx, email);
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //设置密码
        passport.setPassword(newPwd, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //发送重置密码短信验证码
    public void sendSmsCaptchaWithResetPassword(String mobile) {
        this.doSendSmsCaptcha(mobile, "_reset_pwd_mobile");
    }

    //发送重置密码邮件验证码
    public void sendEmailCaptchaWithResetPassword(String email) {
        this.doSendEmailCaptcha(email, "_reset_pwd_email");
    }

    public Passport getPassportByPassportSID(String passportSID) {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportBySID(sctx, passportSID);
        return passport;
    }

    public String getPassportSIDByLoginToken(String loginToken) {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportByLoginToken(sctx, loginToken);
        return passport != null ? passport.getSID() : null;
    }

    public Passport getPassportByLoginToken(String loginToken) {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportByLoginToken(sctx, loginToken);
        return passport;
    }

    //设置用户信息
    public void setPassportUser(PassportUser passportUser) throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportBySID(sctx, passportUser.getPassportSID());
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //设置用户信息
        passport.setPassportUser(passportUser, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //设置用户名
    public void setUsername(PassportCredential passportCredential)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //验证用户名
        boolean existsUsername = this.passportRepository.existsUsername(sctx, passportCredential.getUsername());
        if (existsUsername) {
            throw new PassportException("用户名已存在");
        }
        //获取通行证
        Passport passport = this.passportRepository.getPassportBySID(sctx, passportCredential.getPassportSID());
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //设置用户名
        passport.setUsername(passportCredential.getUsername(), this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //设置手机
    public void setMobile(PassportCredential passportCredential)
            throws PassportException {
        //检查验证码
        String captcha_pre = this.textCaptchaLogService.pickCaptcha("_set_mobile", passportCredential.getMobile());
        if (!passportCredential.matchMobileCaptcha(captcha_pre)) {
            throw new PassportException("验证码无效");
        }
        //
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportBySID(sctx, passportCredential.getPassportSID());
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //设置手机
        passport.setMobile(passportCredential.getMobile(), PassportCheckStateEnum.Checked, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //发送设置手机短信验证码
    public void sendSmsCaptchaWithSetMobile(String mobile) {
        this.doSendSmsCaptcha(mobile, "_set_mobile");
    }

    //设置邮箱
    public void setEmail(PassportCredential passportCredential)
            throws PassportException {
        //检查验证码
        String captcha_pre = this.textCaptchaLogService.pickCaptcha("_set_email", passportCredential.getEmail());
        if (!passportCredential.matchEmailCaptcha(captcha_pre)) {
            throw new PassportException("验证码无效");
        }
        //
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportBySID(sctx, passportCredential.getPassportSID());
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //设置邮箱
        passport.setEmail(passportCredential.getEmail(), PassportCheckStateEnum.Checked, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
    }

    //发送设置邮箱邮件验证码
    public void sendEmailCaptchaWithSetEmail(String email) {
        this.doSendEmailCaptcha(email, "_set_email");
    }

    //设置密码
    public void setPassword(String passportSID, String pwdNew) {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.getPassportBySID(sctx, passportSID);
        //设置新密码
        passport.setPassword(pwdNew, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.savePassport(sctx, passport);
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

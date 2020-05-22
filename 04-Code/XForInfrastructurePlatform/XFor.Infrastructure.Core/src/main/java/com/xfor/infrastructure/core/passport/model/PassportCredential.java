package com.xfor.infrastructure.core.passport.model;

import com.xfor.infrastructure.core.common.util.StringUtil;

/**
 * 通行证凭据
 */
public class PassportCredential {

    private String passportSID;
    private String username;
    private String mobile;
    private String mobileCaptcha;
    private String email;
    private String emailCaptcha;

    public PassportCredential() {
    }

    public Boolean matchMobileCaptcha(String captcha) {
        return StringUtil._equals(this.getMobileCaptcha(), captcha);
    }

    public Boolean matchEmailCaptcha(String captcha) {
        return StringUtil._equals(this.getEmailCaptcha(), captcha);
    }

    public String getPassportSID() {
        return passportSID;
    }

    public void setPassportSID(String passportSID) {
        this.passportSID = passportSID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileCaptcha() {
        return mobileCaptcha;
    }

    public void setMobileCaptcha(String mobileCaptcha) {
        this.mobileCaptcha = mobileCaptcha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCaptcha() {
        return emailCaptcha;
    }

    public void setEmailCaptcha(String emailCaptcha) {
        this.emailCaptcha = emailCaptcha;
    }
}

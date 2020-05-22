package com.xfor.passport.manage.controller.api;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.model.*;
import com.xfor.passport.manage.service.PassportManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassportManageApiController {

    @Autowired
    private PassportManageService passportManageService;

    public PassportManageApiController() {
    }

    @RequestMapping("/login")
    public String login() {
        return "login ok";
    }

    @PostMapping(value = "/isLoginTokenValid", produces = "application/json;charset=UTF-8")
    public boolean isLoginTokenValid(@RequestParam String loginToken) {
        return this.passportManageService.isLoginTokenValid(loginToken);
    }

    @PostMapping(value = "/verifyLoginToken", produces = "application/json;charset=UTF-8")
    public void verifyLoginToken(@RequestParam String loginToken)
            throws PassportException {
        this.passportManageService.verifyLoginToken(loginToken);
    }

    @PostMapping(value = "/clearLoginTokens", produces = "application/json;charset=UTF-8")
    public void clearLoginTokens(@RequestParam int durationLimit) {
        this.passportManageService.clearLoginTokens(durationLimit);
    }

    @PostMapping(value = "/loginByCredAndPwd", produces = "application/json;charset=UTF-8")
    public PassportLoginSession loginByCredAndPwd(@RequestParam String credential, @RequestParam String password)
            throws PassportException {
        return this.passportManageService.loginByCredAndPwd(credential, password);
    }

    @PostMapping(value = "/loginBySms", produces = "application/json;charset=UTF-8")
    public PassportLoginSession loginBySms(@RequestParam String mobile, @RequestParam String captcha)
            throws PassportException {
        return this.passportManageService.loginBySms(mobile, captcha);
    }

    @PostMapping(value = "/logout", produces = "application/json;charset=UTF-8")
    public void logout(@RequestParam String loginToken)
            throws PassportException {
        this.passportManageService.logout(loginToken);
    }

    @PostMapping(value = "/sendSmsCaptchaWithLogin", produces = "application/json;charset=UTF-8")
    public void sendSmsCaptchaWithLogin(@RequestParam String mobile) {
        this.passportManageService.sendSmsCaptchaWithLogin(mobile);
    }

    @PostMapping(value = "/registPassport", produces = "application/json;charset=UTF-8")
    public void registPassport(@RequestBody PassportRegist passportRegist)
            throws PassportException {
        this.passportManageService.registPassport(passportRegist);
    }

    @PostMapping(value = "/resetPasswordWithMobile", produces = "application/json;charset=UTF-8")
    public void resetPasswordWithMobile(@RequestParam String newPwd, @RequestParam String mobile, @RequestParam String captcha)
            throws PassportException {
        this.passportManageService.resetPasswordWithMobile(newPwd, mobile, captcha);
    }

    @PostMapping(value = "/resetPasswordWithEmail", produces = "application/json;charset=UTF-8")
    public void resetPasswordWithEmail(@RequestParam String newPwd, @RequestParam String email, @RequestParam String captcha)
            throws PassportException {
        this.passportManageService.resetPasswordWithEmail(newPwd, email, captcha);
    }

    @PostMapping(value = "/sendSmsCaptchaWithResetPassword", produces = "application/json;charset=UTF-8")
    public void sendSmsCaptchaWithResetPassword(@RequestParam String mobile) {
        this.passportManageService.sendSmsCaptchaWithResetPassword(mobile);
    }

    @PostMapping(value = "/sendEmailCaptchaWithResetPassword", produces = "application/json;charset=UTF-8")
    public void sendEmailCaptchaWithResetPassword(@RequestParam String email) {
        this.passportManageService.sendEmailCaptchaWithResetPassword(email);
    }

    @PostMapping(value = "/getPassportByPassportSID", produces = "application/json;charset=UTF-8")
    public Passport getPassportByPassportSID(@RequestParam String passportSID) {
        return this.passportManageService.getPassportByPassportSID(passportSID);
    }

    @PostMapping(value = "/getPassportSIDByLoginToken", produces = "application/json;charset=UTF-8")
    public String getPassportSIDByLoginToken(@RequestParam String loginToken) {
        return this.passportManageService.getPassportSIDByLoginToken(loginToken);
    }

    @PostMapping(value = "/getPassportByLoginToken", produces = "application/json;charset=UTF-8")
    public Passport getPassportByLoginToken(@RequestParam String loginToken) {
        return this.passportManageService.getPassportByLoginToken(loginToken);
    }

    @PostMapping(value = "/setPassportUser", produces = "application/json;charset=UTF-8")
    public void setPassportUser(@RequestBody PassportUser passportUser)
            throws PassportException {
        this.passportManageService.setPassportUser(passportUser);
    }

    @PostMapping(value = "/setUsername", produces = "application/json;charset=UTF-8")
    public void setUsername(@RequestBody PassportCredential passportCredential)
            throws PassportException {
        this.passportManageService.setUsername(passportCredential);
    }

    @PostMapping(value = "/setMobile", produces = "application/json;charset=UTF-8")
    public void setMobile(@RequestBody PassportCredential passportCredential)
            throws PassportException {
        this.passportManageService.setMobile(passportCredential);
    }

    @PostMapping(value = "/sendSmsCaptchaWithSetMobile", produces = "application/json;charset=UTF-8")
    public void sendSmsCaptchaWithSetMobile(@RequestParam String mobile) {
        this.passportManageService.sendSmsCaptchaWithSetMobile(mobile);
    }

    @PostMapping(value = "/setEmail", produces = "application/json;charset=UTF-8")
    public void setEmail(@RequestBody PassportCredential passportCredential)
            throws PassportException {
        this.passportManageService.setEmail(passportCredential);
    }

    @PostMapping(value = "/sendEmailCaptchaWithSetEmail", produces = "application/json;charset=UTF-8")
    public void sendEmailCaptchaWithSetEmail(@RequestParam String email) {
        this.passportManageService.sendEmailCaptchaWithSetEmail(email);
    }

    @PostMapping(value = "/setPassword", produces = "application/json;charset=UTF-8")
    public void setPassword(@RequestParam String passportSID, @RequestParam String pwdNew) {
        this.passportManageService.setPassword(passportSID, pwdNew);
    }
}

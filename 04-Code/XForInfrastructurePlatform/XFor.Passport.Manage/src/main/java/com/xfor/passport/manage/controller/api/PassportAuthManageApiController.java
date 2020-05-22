package com.xfor.passport.manage.controller.api;

import com.xfor.passport.manage.service.PassportAuthManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassportAuthManageApiController {

    @Autowired
    private PassportAuthManageService passportAuthManageService;

    public PassportAuthManageApiController() {
    }

    @PostMapping(value = "/getLoginTokenByPassportAuthCode", produces = "application/json;charset=UTF-8")
    public String getLoginTokenByPassportAuthCode(@RequestParam String passportAuthCode, @RequestParam String categoryID) {
        var result = this.passportAuthManageService.getLoginTokenByPassportAuthCode(passportAuthCode, categoryID);
        return result;
    }

    @PostMapping(value = "/getPassportAuthCodeByLoginToken", produces = "application/json;charset=UTF-8")
    public String getPassportAuthCodeByLoginToken(@RequestParam String loginToken, @RequestParam String categoryID) {
        var result = this.passportAuthManageService.getPassportAuthCodeByLoginToken(loginToken, categoryID);
        return result;
    }
}

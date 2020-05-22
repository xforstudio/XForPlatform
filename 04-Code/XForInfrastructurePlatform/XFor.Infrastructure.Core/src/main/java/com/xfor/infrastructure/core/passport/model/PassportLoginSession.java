package com.xfor.infrastructure.core.passport.model;

import java.util.Date;

/**
 * 通行证登录会话
 */
public class PassportLoginSession {

    private String loginToken;
    private Date loginTime;

    public PassportLoginSession() {
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}

package com.xfor.infrastructure.core.passport.model;

import com.xfor.infrastructure.core.common.model.SexEnum;

/**
 * 通行证用户信息
 */
public class PassportUser {

    private String passportSID;
    private String name;
    private int sex;

    public PassportUser() {
    }

    public String getPassportSID() {
        return passportSID;
    }

    public void setPassportSID(String passportSID) {
        this.passportSID = passportSID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}

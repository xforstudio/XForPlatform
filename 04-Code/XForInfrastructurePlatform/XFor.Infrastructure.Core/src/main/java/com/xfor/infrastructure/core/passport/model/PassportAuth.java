package com.xfor.infrastructure.core.passport.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 通行证授权
 */
@Entity
public class PassportAuth {

    private String sid;
    private String passportSID;  //通行证唯一标识
    private String categoryID;  //授权类别标识
    private int state = PassportAuthStateEnum.None;  //授权状态
    private String code;  //授权码

    public PassportAuth() {
    }

    @Id
    public String getSID() {
        return sid;
    }

    public void setSID(String sid) {
        this.sid = sid;
    }

    public String getPassportSID() {
        return passportSID;
    }

    public void setPassportSID(String passportSID) {
        this.passportSID = passportSID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

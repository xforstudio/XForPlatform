package com.xfor.infrastructure.core.passport.model;

import com.xfor.infrastructure.core.common.model.IDTypeNOEnum;

/**
 * 通行证证件
 */
public class PassportID {

    private String sid;
    private String passportSID;  //通行证唯一标识
    private int idTypeNO;  //证件类型编号
    private String idCode;  //证件号
    private boolean primary;  //是否为首选证件

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

    public int getIDTypeNO() {
        return idTypeNO;
    }

    public void setIDTypeNO(int idTypeNO) {
        this.idTypeNO = idTypeNO;
    }

    public String getIDCode() {
        return idCode;
    }

    public void setIDCode(String idCode) {
        this.idCode = idCode;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}

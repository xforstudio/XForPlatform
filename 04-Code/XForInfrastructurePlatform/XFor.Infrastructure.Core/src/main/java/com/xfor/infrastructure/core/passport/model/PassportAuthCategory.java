package com.xfor.infrastructure.core.passport.model;

/**
 * 通行证授权类别
 */
public class PassportAuthCategory {

    private String id;  //标识
    private String name;  //名称
    private PassportAuthCategoryStateEnum state;  //授权类别状态
    private String license;  //许可证
    private String salt;  //盐值
    private String rsaPublicKey;  //RSA公钥
    private String rsaPrivateKey;  //RSA私钥

    public PassportAuthCategory() {
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassportAuthCategoryStateEnum getState() {
        return state;
    }

    public void setState(PassportAuthCategoryStateEnum state) {
        this.state = state;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRSAPublicKey() {
        return rsaPublicKey;
    }

    public void setRSAPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getRSAPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRSAPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }
}

package com.xfor.infrastructure.core.passport.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xfor.infrastructure.core.common.model.*;
import com.xfor.infrastructure.core.common.util.RandomUtil;
import com.xfor.infrastructure.core.common.util.StringUtil;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通行证
 */
@Data
@TableName("PASSPORT")
public class Passport {

    public static void _validatePassword(String password) {
        return;
    }

    public static String _newSID() {
        return SID._newSID();
    }

    public static String _newSN() {
        String timeText = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int seq = RandomUtil._nextInt(1, 999999);
        String seqText = String.format("%06d", seq);
        return timeText + seqText;
    }

    @TableId("SID") // 数据库主键字段
    private String sid;  //唯一标识
    @TableField("SN")
    private String sn;  //编号
    @TableField("NAME")
    private String name;  //姓名
    @TableField("SEX")
    private int sex;  //性别
    @TableField("ID_TYPE_NO")
    private int idTypeNO;  //首选证件类型编号
    @TableField("ID_CODE")
    private String idCode;  //首选证件号
    @TableField("MOBILE")
    private String mobile;  //手机号码
    @TableField("MOBILE_CHECK_STATE")
    private int mobileCheckState;  //手机号验证状态
    @TableField("MOBILE_CHECK_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date mobileCheckTime;  //手机号验证时间
    @TableField("EMAIL")
    private String email;  //电子邮件
    @TableField("EMAIL_CHECK_STATE")
    private int emailCheckState;  //电子邮件验证状态
    @TableField("EMAIL_CHECK_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date emailCheckTime;  //电子邮件验证时间
    @TableField("USERNAME")
    private String username;
    @TableField("PASSWORD")
    private String password;
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date createTime;
    @TableField("MODIFY_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date modifyTime;
    @TableField("LOGIN_TOKEN")
    private String loginToken;
    @TableField("LOGIN_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date loginTime;

    public Passport() {
    }

    public Passport(String sid) {
        this.setSID(sid);
    }

    public void validatePassword() {
        _validatePassword(this.getPassword());
    }

    public PassportUser getPassportUser() {
        PassportUser passportUser = new PassportUser();
        passportUser.setPassportSID(this.getSID());
        passportUser.setName(this.getName());
        passportUser.setSex(this.getSex());
        return passportUser;
    }

    public void setPassportUser(PassportUser passportUser, IDateTimeProvider dateTimeProvider) {
        this.setName(passportUser.getName());
        this.setSex(passportUser.getSex());
    }

    public void setUsername(String username, IDateTimeProvider dateTimeProvider) {
        this.setUsername(username);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public void setMobile(String mobile, int checkState, IDateTimeProvider dateTimeProvider) {
        this.setMobile(mobile);
        this.setMobileCheckState(checkState);
        this.setMobileCheckTime(dateTimeProvider.getNow());
        this.setModifyTime(this.getMobileCheckTime());
    }

    public void setEmail(String email, int checkState, IDateTimeProvider dateTimeProvider) {
        this.setEmail(email);
        this.setEmailCheckState(checkState);
        this.setEmailCheckTime(dateTimeProvider.getNow());
        this.setModifyTime(this.getEmailCheckTime());
    }

    public void setPassword(String password, IDateTimeProvider dateTimeProvider) {
        _validatePassword(password);
        this.setPassword(password);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public PassportID getPassportID() {
        PassportID passportID = new PassportID();
        passportID.setPassportSID(this.getSID());
        passportID.setIDTypeNO(this.getIDTypeNO());
        passportID.setIDCode(this.getIDCode());
        passportID.setPrimary(true);
        return passportID;
    }

    public void setPassportSID(PassportID passportID) {
        this.setIDTypeNO(passportID.getIDTypeNO());
        this.setIDCode(passportID.getIDCode());
    }

    public PassportLoginSession createLoginSession() {
        PassportLoginSession loginSession = new PassportLoginSession();
        loginSession.setLoginToken(this.getLoginToken());
        loginSession.setLoginTime(this.getLoginTime());
        return loginSession;
    }

    public PassportLoginSession login(IDateTimeProvider dateTimeProvider) {
        this.setLoginToken(Token._newToken());
        this.setLoginTime(dateTimeProvider.getNow());
        return this.createLoginSession();
    }

    public void logout(String loginToken) {
        this.setLoginToken(null);
        this.setLoginTime(null);
    }

    public boolean matchPassword(String password) {
        return StringUtil._equals(this.getPassword(), password);
    }

    public String getSID() {
        return sid;
    }

    public void setSID(String sid) {
        this.sid = sid;
    }

    public String getSN() {
        return sn;
    }

    public void setSN(String sn) {
        this.sn = sn;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getMobileCheckState() {
        return mobileCheckState;
    }

    public void setMobileCheckState(int mobileCheckState) {
        this.mobileCheckState = mobileCheckState;
    }

    public Date getMobileCheckTime() {
        return mobileCheckTime;
    }

    public void setMobileCheckTime(Date mobileCheckTime) {
        this.mobileCheckTime = mobileCheckTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailCheckState() {
        return emailCheckState;
    }

    public void setEmailCheckState(int emailCheckState) {
        this.emailCheckState = emailCheckState;
    }

    public Date getEmailCheckTime() {
        return emailCheckTime;
    }

    public void setEmailCheckTime(Date emailCheckTime) {
        this.emailCheckTime = emailCheckTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

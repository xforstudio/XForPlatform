package com.xfor.infrastructure.core.email.model;

/**
 * 邮件发送状态
 */
public class EmailSendStateEnum {
    public static final int None = 0;
    public static final int SendNot = 1;  //未发送
    public static final int SendError = 2;  //发送错误
    public static final int SendFault = 3;  //发送失败（终态）
    public static final int SendSuccessed = 4;  //发送成功（终态）
}

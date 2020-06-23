package com.xfor.infrastructure.core.email.model;

/**
 * 邮件发送状态
 */
public class EmailSendStateEnum {
    public static final int None = 0;
    public static final int NotSend = 1;  //未发送
    public static final int RetrySend = 2;  //发送重试
    public static final int ErrorSend = 3;  //发送重试
    public static final int OkSend = 4;  //发送成功
}

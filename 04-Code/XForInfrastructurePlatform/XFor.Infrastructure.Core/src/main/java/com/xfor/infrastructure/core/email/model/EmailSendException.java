package com.xfor.infrastructure.core.email.model;

/**
 * 邮件发送异常
 */
public class EmailSendException extends EmailException {

    public EmailSendException() {
        super();
    }

    public EmailSendException(String message) {
        super(message);
    }
}

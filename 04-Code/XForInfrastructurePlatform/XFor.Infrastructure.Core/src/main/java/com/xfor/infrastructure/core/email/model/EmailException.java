package com.xfor.infrastructure.core.email.model;

/**
 * 邮件异常
 */
public class EmailException extends Exception {

    public EmailException() {
        super();
    }

    public EmailException(String message) {
        super(message);
    }
}

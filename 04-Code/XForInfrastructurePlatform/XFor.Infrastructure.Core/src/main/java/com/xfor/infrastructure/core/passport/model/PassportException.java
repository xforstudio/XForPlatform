package com.xfor.infrastructure.core.passport.model;

/**
 * 通行证异常
 */
public class PassportException extends Exception {

    public PassportException() {
        super();
    }

    public PassportException(String message) {
        super(message);
    }
}

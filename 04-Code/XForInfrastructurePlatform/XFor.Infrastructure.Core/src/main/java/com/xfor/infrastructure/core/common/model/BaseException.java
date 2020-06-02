package com.xfor.infrastructure.core.common.model;

import lombok.Data;

@Data
public abstract class BaseException extends Exception {

    private String code;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }
}

package com.xfor.infrastructure.core.file.model;

import com.xfor.infrastructure.core.common.model.BaseException;

/**
 * 文件异常
 */
public class FileException extends BaseException {

    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }
}

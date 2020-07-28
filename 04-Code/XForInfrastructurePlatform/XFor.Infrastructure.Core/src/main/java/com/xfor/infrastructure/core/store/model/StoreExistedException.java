package com.xfor.infrastructure.core.store.model;

import lombok.Data;

/**
 * 商店已存在异常
 */
@Data
public class StoreExistedException extends StoreException {

    private String fieldName;
    private String fieldValue;

    public StoreExistedException() {
        super();
    }

    public StoreExistedException(String message) {
        super(message);
    }

    public StoreExistedException(String fieldName, String fieldValue) {
        super();
        this.setFieldName(fieldName);
        this.setFieldValue(fieldValue);
    }

    @Override
    public String getMessage() {
        String message = "商店已存在，" + fieldName + "【" + fieldValue + "】";
        return message;
    }
}

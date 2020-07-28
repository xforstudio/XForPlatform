package com.xfor.infrastructure.core.store.model;

import lombok.Data;

/**
 * 商店未找到异常
 */
@Data
public class StoreNotFoundException extends StoreException {

    private String fieldName;
    private String fieldValue;

    public StoreNotFoundException() {
        super();
    }

    public StoreNotFoundException(String message) {
        super(message);
    }

    public StoreNotFoundException(String fieldName, String fieldValue) {
        super();
        this.setFieldName(fieldName);
        this.setFieldValue(fieldValue);
    }

    @Override
    public String getMessage() {
        //return super.getMessage();
        String message = "商店未找到，" + fieldName + "【" + fieldValue + "】";
        return message;
    }
}

package com.xfor.infrastructure.core.product.model;

/**
 * 商品异常
 */
public class ProductException extends Exception {

    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }
}

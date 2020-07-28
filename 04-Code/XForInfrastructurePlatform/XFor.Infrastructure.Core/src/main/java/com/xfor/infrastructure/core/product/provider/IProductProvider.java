package com.xfor.infrastructure.core.product.provider;

import com.xfor.infrastructure.core.product.model.Product;

/**
 *
 */
public interface IProductProvider {

    Product getProductBySid(String productSid);
}

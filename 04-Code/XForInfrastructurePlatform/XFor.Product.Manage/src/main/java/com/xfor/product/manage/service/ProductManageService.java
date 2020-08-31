package com.xfor.product.manage.service;

import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductManageService {

    /* Product */

    Product createProduct(Product fields) throws ProductException;

    Product saveProduct(Product fields) throws ProductException;

    boolean removeProductBySid(String productSid);

    Product getProductBySid(String productSid);

    List<Product> getProductsByFilter(String productStoreSid, String filter);

    /* ProductStore */

    /* ProductCategory */

    /* ProductCategoryRela */

    /* ProductTag */
}

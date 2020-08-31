package com.xfor.infrastructure.core.product.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface ProductCategoryDAO {

    List<ProductCategory> getProductCategoriesByStoreSid(ServiceContext sctx, String productStoreSid);

    ProductCategory getProductCategoryByCode(ServiceContext sctx, String productStoreSid, int code);

    boolean saveProductCategory(ServiceContext sctx, ProductCategory productCategory);

    boolean deleteProductCategoryBySid(ServiceContext sctx, String sid);

    boolean deleteProductCategoryByCode(ServiceContext sctx, String productStoreSid, int code);
}

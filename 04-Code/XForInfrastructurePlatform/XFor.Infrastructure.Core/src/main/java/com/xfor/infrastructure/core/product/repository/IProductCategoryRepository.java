package com.xfor.infrastructure.core.product.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IProductCategoryRepository {

    List<ProductCategory> getProductCategoriesByStoreSID(ServiceContext sctx, String productStoreSID);

    ProductCategory getProductCategoryByCode(ServiceContext sctx, String productStoreSID, int code);

    void saveProductCategory(ServiceContext sctx, ProductCategory productCategory);

    boolean deleteProductCategoryBySID(ServiceContext sctx, String sid);

    boolean deleteProductCategoryByCode(ServiceContext sctx, String productStoreSID, int code);
}

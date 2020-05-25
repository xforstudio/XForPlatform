package com.xfor.infrastructure.core.product.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategory;
import com.xfor.infrastructure.core.product.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisProductCategoryRepository implements IProductCategoryRepository {

    @Autowired
    private IProductCategoryMyBatisDAO productCategoryMyBatisDAO;

    public MyBatisProductCategoryRepository() {
    }

    @Override
    public List<ProductCategory> getProductCategoriesByStoreSID(ServiceContext sctx, String productStoreSID) {
        return null;
    }

    @Override
    public ProductCategory getProductCategoryByCode(ServiceContext sctx, String productStoreSID, int code) {
        return null;
    }

    @Override
    public void saveProductCategory(ServiceContext sctx, ProductCategory productCategory) {

    }

    @Override
    public boolean deleteProductCategoryBySID(ServiceContext sctx, String sid) {
        return false;
    }

    @Override
    public boolean deleteProductCategoryByCode(ServiceContext sctx, String productStoreSID, int code) {
        return false;
    }
}

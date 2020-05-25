package com.xfor.infrastructure.core.product.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductStore;
import com.xfor.infrastructure.core.product.repository.IProductStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisProductStoreRepository implements IProductStoreRepository {

    @Autowired
    private IProductStoreMyBatisDAO productStoreMyBatisDAO;

    public MyBatisProductStoreRepository() {
    }

    @Override
    public ProductStore getProductStoreBySID(ServiceContext sctx, String sid) {
        return null;
    }

    @Override
    public List<ProductStore> getProductStoresByOwner(ServiceContext sctx, String owner) {
        return null;
    }

    @Override
    public List<ProductStore> getProductStoresByFilter(ServiceContext sctx, String owner, String filter) {
        return null;
    }

    @Override
    public void saveProductStore(ServiceContext sctx, ProductStore productStore) {

    }

    @Override
    public boolean deleteProductStoreBySID(ServiceContext sctx, String sid) {
        return false;
    }
}

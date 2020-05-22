package com.xfor.infrastructure.core.product.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisProductRepository implements IProductRepository {

    @Autowired
    private IProductMyBatisDAO productMyBatisDAO;

    public MyBatisProductRepository() {
    }


    @Override
    public Product getProductBySID(ServiceContext sctx, String sid) {
        return null;
    }

    @Override
    public List<Product> getProductsByFilter(ServiceContext sctx, String filter) {
        return null;
    }

    @Override
    public String getProductPicturesContentByProductSID(ServiceContext sctx, String productSID) {
        return null;
    }

    @Override
    public boolean existsProductBySID(ServiceContext sctx, String sid) {
        return false;
    }

    @Override
    public void saveProduct(ServiceContext sctx, Product product) {

    }

    @Override
    public void deleteProductBySID(ServiceContext sctx, String sid) {

    }
}

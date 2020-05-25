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
        Product result = this.productMyBatisDAO.findFirstBySID(sid);
        return result;
    }

    @Override
    public List<Product> getProductsByFilter(ServiceContext sctx, String filter) {
        List<Product> result = this.productMyBatisDAO.findAllByFilter(filter);
        return result;
    }

    @Override
    public String getProductPicturesContentByProductSID(ServiceContext sctx, String productSID) {
        String result = this.productMyBatisDAO.findPicturesBySID((productSID));
        return result;
    }

    @Override
    public boolean existsProductBySID(ServiceContext sctx, String sid) {
        boolean result = this.productMyBatisDAO.existsBySID(sid);
        return result;
    }

    @Override
    public boolean saveProduct(ServiceContext sctx, Product product) {
        int result = this.productMyBatisDAO.updateById(product);
        if(result <= 0) {
            result = this.productMyBatisDAO.insert(product);
        }
        return result > 0;
    }

    @Override
    public boolean saveProductPicturesContent(ServiceContext sctx, String sid, String productPicturesContent) {
        Product product = this.productMyBatisDAO.findFirstBySID(sid);
        if (product == null) {
            return false;
        }
        product.setPictures(productPicturesContent);
        int result = this.productMyBatisDAO.updateById(product);
        return result > 0;
    }

    @Override
    public boolean deleteProductBySID(ServiceContext sctx, String sid) {
        int result = this.productMyBatisDAO.deleteBySID(sid);
        return result > 0;
    }
}

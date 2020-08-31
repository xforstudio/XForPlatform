package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategory;
import com.xfor.infrastructure.core.product.dao.ProductCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class ProductCategoryDAOImpl implements ProductCategoryDAO {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryDAOImpl() {
    }

    @Override
    public List<ProductCategory> getProductCategoriesByStoreSid(ServiceContext sctx, String productStoreSid) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid);
        List<ProductCategory> result = this.productCategoryRepository.selectList(wrapper);
        return result;
    }

    @Override
    public ProductCategory getProductCategoryByCode(ServiceContext sctx, String productStoreSid, int code) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid).eq("CODE", code);
        ProductCategory result = this.productCategoryRepository.selectOne(wrapper);
        return result;
    }

    @Override
    public boolean saveProductCategory(ServiceContext sctx, ProductCategory productCategory) {
        int result = this.productCategoryRepository.updateById(productCategory);
        if(result <= 0) {
            result = this.productCategoryRepository.insert(productCategory);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductCategoryBySid(ServiceContext sctx, String sid) {
        int result = this.productCategoryRepository.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean deleteProductCategoryByCode(ServiceContext sctx, String productStoreSid, int code) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid).eq("CODE", code);
        int result = this.productCategoryRepository.delete(wrapper);
        return result > 0;
    }
}

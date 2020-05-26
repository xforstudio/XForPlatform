package com.xfor.infrastructure.core.product.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategory;
import com.xfor.infrastructure.core.product.model.ProductStore;
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
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSID);
        List<ProductCategory> result = this.productCategoryMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public ProductCategory getProductCategoryByCode(ServiceContext sctx, String productStoreSID, int code) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSID).eq("CODE", code);
        ProductCategory result = this.productCategoryMyBatisDAO.selectOne(wrapper);
        return result;
    }

    @Override
    public boolean saveProductCategory(ServiceContext sctx, ProductCategory productCategory) {
        int result = this.productCategoryMyBatisDAO.updateById(productCategory);
        if(result <= 0) {
            result = this.productCategoryMyBatisDAO.insert(productCategory);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductCategoryBySID(ServiceContext sctx, String sid) {
        int result = this.productCategoryMyBatisDAO.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean deleteProductCategoryByCode(ServiceContext sctx, String productStoreSID, int code) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSID).eq("CODE", code);
        int result = this.productCategoryMyBatisDAO.delete(wrapper);
        return result > 0;
    }
}

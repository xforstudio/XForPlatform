package com.xfor.infrastructure.core.product.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductTag;
import com.xfor.infrastructure.core.product.repository.IProductTagRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisProductTagRepository implements IProductTagRepository {

    @Autowired
    private IProductTagMyBatisDAO productTagMyBatisDAO;

    public MyBatisProductTagRepository() {
    }

    @Override
    public List<ProductTag> getProductTagsByStoreSid(ServiceContext sctx, String productStoreSid) {
        QueryWrapper<ProductTag> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid);
        List<ProductTag> result = this.productTagMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public ProductTag getProductTagByCode(ServiceContext sctx, String productStoreSid, int code) {
        QueryWrapper<ProductTag> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid).eq("CODE", code);
        ProductTag result = this.productTagMyBatisDAO.selectOne(wrapper);
        return result;
    }

    @Override
    public boolean saveProductTag(ServiceContext sctx, ProductTag productTag) {
        int result = this.productTagMyBatisDAO.updateById(productTag);
        if(result <= 0) {
            result = this.productTagMyBatisDAO.insert(productTag);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductTagBySid(ServiceContext sctx, String sid) {
        int result = this.productTagMyBatisDAO.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean deleteProductTagByCode(ServiceContext sctx, String productStoreSid, int code) {
        QueryWrapper<ProductTag> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid).eq("CODE", code);
        int result = this.productTagMyBatisDAO.delete(wrapper);
        return result > 0;
    }
}

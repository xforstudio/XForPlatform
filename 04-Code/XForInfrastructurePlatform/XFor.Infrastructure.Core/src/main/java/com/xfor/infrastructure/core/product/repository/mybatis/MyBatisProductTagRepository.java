package com.xfor.infrastructure.core.product.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductTag;
import com.xfor.infrastructure.core.product.repository.IProductTagRepository;
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
    public List<ProductTag> getProductTagsByStoreSID(ServiceContext sctx, String productStoreSID) {
        return null;
    }

    @Override
    public ProductTag getProductTagByCode(ServiceContext sctx, String productStoreSID, int code) {
        return null;
    }

    @Override
    public void saveProductTag(ServiceContext sctx, ProductTag productTag) {

    }

    @Override
    public boolean deleteProductTagBySID(ServiceContext sctx, String sid) {
        return false;
    }

    @Override
    public boolean deleteProductTagByCode(ServiceContext sctx, String productStoreSID, int code) {
        return false;
    }
}

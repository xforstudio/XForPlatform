package com.xfor.infrastructure.core.product.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategoryRela;
import com.xfor.infrastructure.core.product.repository.IProductCategoryRelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisProductCategoryRelaRepository implements IProductCategoryRelaRepository {

    @Autowired
    private IProductCategoryRelaMyBatisDAO productCategoryRelaMyBatisDAO;

    public MyBatisProductCategoryRelaRepository() {
    }

    @Override
    public List<ProductCategoryRela> getProductCategoryRelasByCategoryCode(ServiceContext sctx, int categoryCode) {
        return null;
    }

    @Override
    public List<ProductCategoryRela> getProductCategoryRelasByProductCode(ServiceContext sctx, String productCode) {
        return null;
    }

    @Override
    public void saveProductCategoryRela(ServiceContext sctx, ProductCategoryRela productCategoryRela) {

    }

    @Override
    public boolean deleteProductCategoryRelaBySID(ServiceContext sctx, String sid) {
        return false;
    }
}

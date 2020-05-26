package com.xfor.infrastructure.core.product.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategoryRela;
import com.xfor.infrastructure.core.product.model.ProductStore;
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
    public List<ProductCategoryRela> getProductCategoryRelasByCategoryCode(
            ServiceContext sctx, String productStoreSID, int categoryCode) {
        QueryWrapper<ProductCategoryRela> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSID)
                .eq("CATEGORY_CODE", categoryCode);
        List<ProductCategoryRela> result = this.productCategoryRelaMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public List<ProductCategoryRela> getProductCategoryRelasByProductCode(
            ServiceContext sctx, String productStoreSID, String productCode) {
        QueryWrapper<ProductCategoryRela> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSID)
                .eq("PRODUCT_CODE", productCode);
        List<ProductCategoryRela> result = this.productCategoryRelaMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveProductCategoryRela(ServiceContext sctx, ProductCategoryRela productCategoryRela) {
        int result = this.productCategoryRelaMyBatisDAO.updateById(productCategoryRela);
        if(result <= 0) {
            result = this.productCategoryRelaMyBatisDAO.insert(productCategoryRela);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductCategoryRelaBySID(ServiceContext sctx, String sid) {
        int result = this.productCategoryRelaMyBatisDAO.deleteById(sid);
        return result > 0;
    }
}

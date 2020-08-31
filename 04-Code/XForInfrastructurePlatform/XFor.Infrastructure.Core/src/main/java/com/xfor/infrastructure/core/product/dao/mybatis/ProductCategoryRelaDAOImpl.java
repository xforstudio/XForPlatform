package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategoryRela;
import com.xfor.infrastructure.core.product.dao.ProductCategoryRelaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class ProductCategoryRelaDAOImpl implements ProductCategoryRelaDAO {

    @Autowired
    private ProductCategoryRelaRepository productCategoryRelaRepository;

    @Override
    public List<ProductCategoryRela> getProductCategoryRelasByCategoryCode(
            ServiceContext sctx, String productStoreSid, int categoryCode) {
        QueryWrapper<ProductCategoryRela> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid)
                .eq("CATEGORY_CODE", categoryCode);
        List<ProductCategoryRela> result = this.productCategoryRelaRepository.selectList(wrapper);
        return result;
    }

    @Override
    public List<ProductCategoryRela> getProductCategoryRelasByProductCode(
            ServiceContext sctx, String productStoreSid, String productCode) {
        QueryWrapper<ProductCategoryRela> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_STORE_SID", productStoreSid)
                .eq("PRODUCT_CODE", productCode);
        List<ProductCategoryRela> result = this.productCategoryRelaRepository.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveProductCategoryRela(ServiceContext sctx, ProductCategoryRela productCategoryRela) {
        int result = this.productCategoryRelaRepository.updateById(productCategoryRela);
        if(result <= 0) {
            result = this.productCategoryRelaRepository.insert(productCategoryRela);
        }
        return result > 0;
    }

    @Override
    public boolean deleteProductCategoryRelaBySid(ServiceContext sctx, String sid) {
        int result = this.productCategoryRelaRepository.deleteById(sid);
        return result > 0;
    }
}

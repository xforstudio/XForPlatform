package com.xfor.infrastructure.core.product.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategoryRela;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface ProductCategoryRelaDAO {

    List<ProductCategoryRela> getProductCategoryRelasByCategoryCode(
            ServiceContext sctx, String productStoreSid, int categoryCode);

    List<ProductCategoryRela> getProductCategoryRelasByProductCode(
            ServiceContext sctx, String productStoreSid, String productCode);

    boolean saveProductCategoryRela(ServiceContext sctx, ProductCategoryRela productCategoryRela);

    boolean deleteProductCategoryRelaBySid(ServiceContext sctx, String sid);
}

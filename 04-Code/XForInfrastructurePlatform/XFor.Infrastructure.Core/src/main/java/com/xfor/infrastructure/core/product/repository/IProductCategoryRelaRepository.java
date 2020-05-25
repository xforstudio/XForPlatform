package com.xfor.infrastructure.core.product.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductCategoryRela;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IProductCategoryRelaRepository {

    List<ProductCategoryRela> getProductCategoryRelasByCategoryCode(ServiceContext sctx, int categoryCode);

    List<ProductCategoryRela> getProductCategoryRelasByProductCode(ServiceContext sctx, String productCode);

    void saveProductCategoryRela(ServiceContext sctx, ProductCategoryRela productCategoryRela);

    boolean deleteProductCategoryRelaBySID(ServiceContext sctx, String sid);
}

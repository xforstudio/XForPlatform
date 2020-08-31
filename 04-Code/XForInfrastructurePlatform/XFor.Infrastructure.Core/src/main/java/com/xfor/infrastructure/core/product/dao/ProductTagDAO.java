package com.xfor.infrastructure.core.product.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductTag;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface ProductTagDAO {

    List<ProductTag> getProductTagsByStoreSid(ServiceContext sctx, String productStoreSid);

    ProductTag getProductTagByCode(ServiceContext sctx, String productStoreSid, int code);

    boolean saveProductTag(ServiceContext sctx, ProductTag productTag);

    boolean deleteProductTagBySid(ServiceContext sctx, String sid);

    boolean deleteProductTagByCode(ServiceContext sctx, String productStoreSid, int code);
}

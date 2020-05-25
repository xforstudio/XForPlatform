package com.xfor.infrastructure.core.product.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductTag;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IProductTagRepository {

    List<ProductTag> getProductTagsByStoreSID(ServiceContext sctx, String productStoreSID);

    ProductTag getProductTagByCode(ServiceContext sctx, String productStoreSID, int code);

    void saveProductTag(ServiceContext sctx, ProductTag productTag);

    boolean deleteProductTagBySID(ServiceContext sctx, String sid);

    boolean deleteProductTagByCode(ServiceContext sctx, String productStoreSID, int code);
}

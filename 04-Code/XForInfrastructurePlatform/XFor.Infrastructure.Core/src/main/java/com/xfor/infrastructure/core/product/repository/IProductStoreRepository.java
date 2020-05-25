package com.xfor.infrastructure.core.product.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductStore;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IProductStoreRepository {

    ProductStore getProductStoreBySID(ServiceContext sctx, String sid);

    List<ProductStore> getProductStoresByOwner(ServiceContext sctx, String owner);

    List<ProductStore> getProductStoresByFilter(ServiceContext sctx, String owner, String filter);

    void saveProductStore(ServiceContext sctx, ProductStore productStore);

    boolean deleteProductStoreBySID(ServiceContext sctx, String sid);
}

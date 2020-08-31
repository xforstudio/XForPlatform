package com.xfor.infrastructure.core.product.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.ProductStore;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface ProductStoreDAO {

    ProductStore getProductStoreBySid(ServiceContext sctx, String sid);

    List<ProductStore> getProductStoresByOwner(ServiceContext sctx, String owner);

    List<ProductStore> getProductStoresByFilter(ServiceContext sctx, String owner, String filter);

    boolean saveProductStore(ServiceContext sctx, ProductStore productStore);

    boolean deleteProductStoreBySid(ServiceContext sctx, String sid);
}

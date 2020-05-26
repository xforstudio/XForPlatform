package com.xfor.infrastructure.core.product.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IProductRepository {

    Product getProductBySid(ServiceContext sctx, String sid);

    List<Product> getProductsByFilter(ServiceContext sctx, String productStoreSid, String filter);

    boolean saveProduct(ServiceContext sctx, Product product);

    boolean deleteProductBySid(ServiceContext sctx, String sid);

    int getProductCountByCode(ServiceContext sctx, String productStoreSid, String code);

    int getProductCountByName(ServiceContext sctx, String productStoreSid, String name);

    boolean saveProductPicturesContent(ServiceContext sctx, String sid, String productPicturesContent);
}


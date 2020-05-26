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

    Product getProductBySID(ServiceContext sctx, String sid);

    List<Product> getProductsByFilter(ServiceContext sctx, String productStoreSID, String filter);

    boolean saveProduct(ServiceContext sctx, Product product);

    boolean deleteProductBySID(ServiceContext sctx, String sid);

    boolean saveProductPicturesContent(ServiceContext sctx, String sid, String productPicturesContent);
}


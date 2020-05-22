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

    List<Product> getProductsByFilter(ServiceContext sctx, String filter);

    String getProductPicturesContentByProductSID(ServiceContext sctx, String productSID);

    boolean existsProductBySID(ServiceContext sctx, String sid);

    void saveProduct(ServiceContext sctx, Product product);

    void deleteProductBySID(ServiceContext sctx, String sid);
}


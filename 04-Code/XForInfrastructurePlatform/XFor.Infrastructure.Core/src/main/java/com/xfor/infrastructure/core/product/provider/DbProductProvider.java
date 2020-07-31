package com.xfor.infrastructure.core.product.provider;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbProductProvider implements IProductProvider {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product getProductBySid(String productSid) {
        ServiceContext sctx = new ServiceContext();
        Product product = this.productRepository.getProductBySid(sctx, productSid);
        return product;
    }
}

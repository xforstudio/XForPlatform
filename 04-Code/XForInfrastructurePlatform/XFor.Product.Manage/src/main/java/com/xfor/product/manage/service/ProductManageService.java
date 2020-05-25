package com.xfor.product.manage.service;

import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManageService {

    @Autowired
    private IProductRepository productRepository;

    public ProductManageService() {
    }

    public Product createProduct(String category, String name, String desc, List<String> pictures, float price) {
        throw new UnsupportedOperationException();
    }

    public Product saveProduct(Product product) {
        throw new UnsupportedOperationException();
    }

    public boolean removeProduct(String productSID) {
        throw new UnsupportedOperationException();
    }

    public Product getProductBySID(String productSID) {
        throw new UnsupportedOperationException();
    }

    public List<Product> getProductsByFilter(String filter) {
        throw new UnsupportedOperationException();
    }
}

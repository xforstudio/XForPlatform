package com.xfor.product.manage.service;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.product.model.ProductSaleStateEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductManageServiceTest {

    @Autowired
    private ProductManageService productManageService;

    protected ServiceContext doGetServiceContext() {
        return ServiceContext._empty();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createProduct() throws ProductException {
        Product fields = new Product();
        fields.setCode("PD00000001");
        fields.setName("商品0001");
        fields.setMemo("商品备注0001");
        fields.setPrice(101);
        fields.setSaleState(ProductSaleStateEnum.Normal);
        fields.setProductStoreSid("pds0001");
        //
        Product product_new = this.productManageService.createProduct(fields);
        Assert.notNull(product_new, "");
    }

    @Test
    void saveProduct() {
    }

    @Test
    void removeProductBySid() {
    }

    @Test
    void getProductBySid() {
    }

    @Test
    void getProductsByFilter() {
    }
}
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

import java.util.List;

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
    void saveProduct() throws ProductException {
        Product fields = new Product();
        fields.setSid("");
        fields.setCode("PD00000002");
        fields.setName("商品0002");
        fields.setMemo("商品备注0002");
        fields.setPrice(102);
        fields.setSaleState(ProductSaleStateEnum.Normal);
        fields.setProductStoreSid("pds0001");
        //
        Product product = this.productManageService.saveProduct(fields);
        Assert.notNull(product, "");
    }

    @Test
    void removeProductBySid() {
        String productSid = "";
        boolean result = this.productManageService.removeProductBySid(productSid);
        Assert.isTrue(result, "");
    }

    @Test
    void getProductBySid() {
        String productSid = "";
        Product product = this.productManageService.getProductBySid(productSid);
        Assert.notNull(product, "");
    }

    @Test
    void getProductsByFilter() {
        String productStoreSid = "";
        String filter = "";
        List<Product> products = this.productManageService.getProductsByFilter(productStoreSid, filter);
        Assert.notNull(products, "");
    }
}
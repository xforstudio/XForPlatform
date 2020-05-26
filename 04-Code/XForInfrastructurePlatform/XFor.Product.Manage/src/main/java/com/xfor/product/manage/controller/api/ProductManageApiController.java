package com.xfor.product.manage.controller.api;

import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.product.manage.service.ProductManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品管理API控制器
 */
@RestController
public class ProductManageApiController {

    @Autowired
    private ProductManageService productManageService;

    public ProductManageApiController() {
    }

    @PostMapping(value = "/createProduct", produces = "application/json;charset=UTF-8")
    public Product createProduct(
            @RequestParam String category,
            @RequestParam String name,
            @RequestParam String desc,
            @RequestParam List<String> pictures,
            @RequestParam float price) {
        return this.productManageService.createProduct(category, name, desc, pictures, price);
    }

    @PostMapping(value = "/saveProduct", produces = "application/json;charset=UTF-8")
    public Product saveProduct(@RequestBody Product product) {
        return this.productManageService.saveProduct(product);
    }

    @PostMapping(value = "/removeProduct", produces = "application/json;charset=UTF-8")
    public boolean removeProduct(@RequestParam String productSID) {
        return this.productManageService.removeProduct(productSID);
    }

    @PostMapping(value = "/getProductBySID", produces = "application/json;charset=UTF-8")
    public Product getProductBySID(@RequestParam String productSID) {
        return this.productManageService.getProductBySID(productSID);
    }

    @PostMapping(value = "/getProductsByFilter", produces = "application/json;charset=UTF-8")
    public List<Product> getProductsByFilter(
            @RequestParam String productStoreSID,
            @RequestParam String filter) {
        return this.productManageService.getProductsByFilter(productStoreSID, filter);
    }
}

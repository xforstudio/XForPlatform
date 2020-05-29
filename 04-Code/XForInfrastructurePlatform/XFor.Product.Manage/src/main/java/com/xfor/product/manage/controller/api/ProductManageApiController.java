package com.xfor.product.manage.controller.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.product.manage.service.ProductManageService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理API控制器
 */
@RestController
@RequestMapping("/productmanage")
public class ProductManageApiController {

    @Autowired
    private ProductManageService productManageService;

    public ProductManageApiController() {
    }

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestBody String requestBody) {
        JsonObject returnData = new JsonParser().parse(requestBody).getAsJsonObject();
        String productSid = returnData.get("productSid").getAsString();
        String productName = returnData.get("productName").getAsString();
        return productSid + "<>" + productName;
        //return productSid;
    }

    @PostMapping(value = "/createProduct", produces = "application/json;charset=UTF-8")
    public Product createProduct(@RequestBody Product fields) throws ProductException {
        return this.productManageService.createProduct(fields);
    }

    @PostMapping(value = "/saveProduct", produces = "application/json;charset=UTF-8")
    public Product saveProduct(@RequestBody Product fields) throws ProductException {
        return this.productManageService.saveProduct(fields);
    }

    @PostMapping(value = "/removeProductBySid", produces = "application/json;charset=UTF-8")
    public boolean removeProductBySid(@RequestParam String productSid) {
        return this.productManageService.removeProductBySid(productSid);
    }

    @PostMapping(value = "/getProductBySid", produces = "application/json;charset=UTF-8")
    public Product getProductBySid(@RequestParam String productSid) {
        return this.productManageService.getProductBySid(productSid);
    }

    @PostMapping(value = "/getProductsByFilter", produces = "application/json;charset=UTF-8")
    public List<Product> getProductsByFilter(
            @RequestParam String productStoreSid,
            @RequestParam String filter) {
        return this.productManageService.getProductsByFilter(productStoreSid, filter);
    }
}

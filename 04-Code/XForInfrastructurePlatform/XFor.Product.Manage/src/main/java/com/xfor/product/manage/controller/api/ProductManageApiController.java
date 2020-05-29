package com.xfor.product.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.product.manage.service.ProductManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品管理API控制器
 */
@RestController
@RequestMapping("/ProductManageApi")
public class ProductManageApiController {

    @Autowired
    private ProductManageService productManageService;

    public ProductManageApiController() {
    }

//    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
//    public String login(@RequestBody String requestBody) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> params = mapper.readValue(requestBody, Map.class);
//        String productSid = params.get("productSid").toString();
//        String productName = params.get("productName").toString();
//        //JsonObject returnData = new JsonParser().parse(requestBody).getAsJsonObject();
//        //String productSid = returnData.get("productSid").getAsString();
//        //String productName = returnData.get("productName").getAsString();
//        return productSid + "<>" + productName;
//        //return productSid;
//    }
//
//    @PostMapping(value = "/testSave", produces = "application/json;charset=UTF-8")
//    public Product testSave(@RequestBody String requestBody) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        Product fields = mapper.readValue(requestBody, Product.class);
//        //System.out.println(user);
//        //Product fields = gson.fromJson(requestBody, Product.class);
//        return fields;
//    }

    @PostMapping(value = "/CreateProduct", produces = "application/json;charset=UTF-8")
    public Product createProduct(@RequestBody String requestBody) throws ProductException, JsonProcessingException {
        Product fields = new ObjectMapper().readValue(requestBody, Product.class);
        Product result = this.productManageService.createProduct(fields);
        return result;
    }

    @PostMapping(value = "/SaveProduct", produces = "application/json;charset=UTF-8")
    public Product saveProduct(@RequestBody String requestBody) throws ProductException, JsonProcessingException {
        Product fields = new ObjectMapper().readValue(requestBody, Product.class);
        Product result = this.productManageService.saveProduct(fields);
        return result;
    }

    @PostMapping(value = "/RemoveProductBySid", produces = "application/json;charset=UTF-8")
    public boolean removeProductBySid(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String productSid = params.get("productSid").toString();
        boolean result = this.productManageService.removeProductBySid(productSid);
        return result;
    }

    @PostMapping(value = "/GetProductBySid", produces = "application/json;charset=UTF-8")
    public Product getProductBySid(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String productSid = params.get("productSid").toString();
        Product result = this.productManageService.getProductBySid(productSid);
        return result;
    }

    @PostMapping(value = "/GetProductsByFilter", produces = "application/json;charset=UTF-8")
    public List<Product> getProductsByFilter(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String productStoreSid = params.get("productStoreSid").toString();
        String filter = params.get("filter").toString();
        List<Product> result = this.productManageService.getProductsByFilter(productStoreSid, filter);
        return result;
    }
}

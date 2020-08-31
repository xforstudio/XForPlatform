package com.xfor.product.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductSaleStateEnum;
import com.xfor.infrastructure.core.common.util.HttpUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

class ProductManageApiControllerTest {

    private String rootUrl = "http://127.0.0.1:8731/ProductManageApi";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void login() throws JsonProcessingException {
//        String productSid = "1234567890";
//        String productName = "hahaha";
//
////        String url = "http://127.0.0.1:8731/removeProductBySid";
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("productSid", productSid);
////        String jsonParam = jsonObject.toString();
//
//        String url = "http://127.0.0.1:8731/productmanage/login";
//        //ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> params =  new HashMap<>();
//        params.put("productSid", productSid);
//        params.put("productName", productName);
//        String jsonParams = new ObjectMapper().writeValueAsString(params);
//
//        //String url = "http://127.0.0.1:8731/productmanage/removeProductBySid";
//        //JsonObject jsonObject = new JsonObject();
//        //jsonObject.addProperty("productSid", productSid);
//        //jsonObject.addProperty("productName", productName);
//        //String jsonParam = jsonObject.toString();
//        String result = HttpUtil._postJson(url,30000, jsonParams);
//        Assert.notNull(result, "");
//    }
//
//    @Test
//    void testSave() throws JsonProcessingException {
//        Product fields = new Product();
//        fields.setSid("product_sid_0001");
//        fields.setCode("product_code_0001");
//        fields.setName("product_name_0001");
//
//        String url = "http://127.0.0.1:8731/productmanage/testSave";
//        //Gson gson = new Gson();
//        //String jsonParam = gson.toJson(fields);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonParam = mapper.writeValueAsString(fields);
//        String result = HttpUtil._postJson(url,30000, jsonParam);
//        Assert.notNull(result, "");
//    }

    @Test
    void createProduct() throws JsonProcessingException {
        //
        Product fields = new Product();
        fields.setCode("product_code_0001");
        fields.setName("product_name_0001");
        fields.setMemo("product_memo_0001");
        fields.setPrice(101);
        fields.setSaleState(ProductSaleStateEnum.Normal);
        fields.setProductStoreSid("productstore_sid_0001");
        //
        String jsonParams = new ObjectMapper().writeValueAsString(fields);
        String result = HttpUtil._postJson(this.rootUrl + "/CreateProduct",30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void saveProduct() throws JsonProcessingException {
        //
        Product fields = new Product();
        fields.setSid("8F20DEC0EB9B4542A385D928836969C0");
        fields.setCode("product_code_0002");
        fields.setName("product_name_0002");
        fields.setMemo("product_memo_0002");
        fields.setPrice(102);
        fields.setSaleState(ProductSaleStateEnum.Invalid);
        fields.setProductStoreSid("productstore_sid_0001");
        //
        String jsonParams = new ObjectMapper().writeValueAsString(fields);
        String result = HttpUtil._postJson(this.rootUrl + "/SaveProduct",30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void removeProductBySid() throws JsonProcessingException {
        //
        String productSid = "8F20DEC0EB9B4542A385D928836969C0";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("productSid", productSid);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RemoveProductBySid",30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void getProductBySid() throws JsonProcessingException {
        //
        String productSid = "8F20DEC0EB9B4542A385D928836969C0";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("productSid", productSid);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/GetProductBySid",30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void getProductsByFilter() throws JsonProcessingException {
        //
        String productStoreSid = "productstore_sid_0001";
        String filter = "nam";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("productStoreSid", productStoreSid);
        params.put("filter", filter);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/GetProductsByFilter",30000, jsonParams);
        Assert.notNull(result, "");
    }
}
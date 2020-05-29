package com.xfor.product.manage.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.product.manage.util.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.*;

class ProductManageApiControllerTests {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void saveProduct() {
    }

    @Test
    void removeProductBySid() {
        String productSid = "1234567890";
        String productName = "hahaha";

//        String url = "http://127.0.0.1:8731/removeProductBySid";
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("productSid", productSid);
//        String jsonParam = jsonObject.toString();

        String url = "http://127.0.0.1:8731/productmanage/login";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("productSid", productSid);
        jsonObject.addProperty("productName", productName);

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("productSid", productSid);
        //jsonObject.put("productName", productName);
        String jsonParam = jsonObject.toString();
        String result = HttpUtil._postJson(url,5000, jsonParam);
        System.out.println("result:"+result);
        Assert.notNull(result, "");
    }

    @Test
    void getProductBySid() {
    }

    @Test
    void getProductsByFilter() {
    }
}
package com.xfor.store.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.store.model.StoreCartEntry;
import com.xfor.store.manage.service.StoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/StoreCartApi")
public class StoreCartApiController {

    @Autowired
    private StoreCartService storeCartService;

    @PostMapping(value = "/GetStoreCartEntryByStoreSid", produces = "application/json;charset=UTF-8")
    public List<StoreCartEntry> getStoreCartEntriesByStoreSid(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String accountSid = params.get("accountSid").toString();
        String storeSid = params.get("storeSid").toString();
        List<StoreCartEntry> result = this.storeCartService.listStoreCartEntriesByStoreSid(accountSid, storeSid);
        return result;
    }

    @PostMapping(value = "/GetStoreCartEntriesByAll", produces = "application/json;charset=UTF-8")
    public List<StoreCartEntry> getStoreCartEntriesByAll(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String accountSid = params.get("accountSid").toString();
        List<StoreCartEntry> result = this.storeCartService.listStoreCartEntriesByAll(accountSid);
        return result;
    }

    @PostMapping(value = "/IncreaseProduct", produces = "application/json;charset=UTF-8")
    public int increaseProduct(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String accountSid = params.get("accountSid").toString();
        String storeSid = params.get("storeSid").toString();
        String productSid = params.get("productSid").toString();
        int result = this.storeCartService.increaseProduct(accountSid, storeSid, productSid);
        return result;
    }

    @PostMapping(value = "/DecreaseProduct", produces = "application/json;charset=UTF-8")
    public int decreaseProduct(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String accountSid = params.get("accountSid").toString();
        String storeSid = params.get("storeSid").toString();
        String productSid = params.get("productSid").toString();
        int result = this.storeCartService.decreaseProduct(accountSid, storeSid, productSid);
        return result;
    }

    @PostMapping(value = "/RemoveProductsByStoreSid", produces = "application/json;charset=UTF-8")
    public void removeProductsByStoreSid(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String accountSid = params.get("accountSid").toString();
        String storeSid = params.get("storeSid").toString();
        this.storeCartService.removeProductsByStoreSid(accountSid, storeSid);
    }

    @PostMapping(value = "/RemoveProductsByAll", produces = "application/json;charset=UTF-8")
    public void removeProductsByAll(@RequestBody String requestBody) throws JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String accountSid = params.get("accountSid").toString();
        this.storeCartService.removeProductsByAll(accountSid);
    }
}

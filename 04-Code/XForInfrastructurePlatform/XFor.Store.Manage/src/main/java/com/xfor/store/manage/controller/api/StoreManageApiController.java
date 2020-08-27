package com.xfor.store.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.store.model.*;
import com.xfor.store.manage.service.StoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 商店管理API控制器
 */
@RestController
@RequestMapping("/StoreManageApi")
public class StoreManageApiController {

    @Autowired
    private StoreManageService storeManageService;

    @PostMapping(value = "/CreateStore", produces = "application/json;charset=UTF-8")
    public Store createStore(@RequestBody String requestBody) throws StoreException, JsonProcessingException {
        Store fields = new ObjectMapper().readValue(requestBody, Store.class);
        Store result = this.storeManageService.createStore(fields);
        return result;
    }

    @PostMapping(value = "/SaveStore", produces = "application/json;charset=UTF-8")
    public Store saveStore(@RequestBody String requestBody) throws JsonProcessingException, StoreException {
        Store fields = new ObjectMapper().readValue(requestBody, Store.class);
        Store result = this.storeManageService.saveStore(fields);
        return result;
    }

    @PostMapping(value = "/OpenStore", produces = "application/json;charset=UTF-8")
    public Store openStore(@RequestBody String requestBody) throws StoreNotFoundException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String storeSid = params.get("storeSid").toString();
        Store result = this.storeManageService.openStore(storeSid);
        return result;
    }

    @PostMapping(value = "/CloseStore", produces = "application/json;charset=UTF-8")
    public Store closeStore(@RequestBody String requestBody) throws StoreNotFoundException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String storeSid = params.get("storeSid").toString();
        Store result = this.storeManageService.closeStore(storeSid);
        return result;
    }

    @PostMapping(value = "/CancelStore", produces = "application/json;charset=UTF-8")
    public Store cancelStore(@RequestBody String requestBody) throws StoreNotFoundException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String storeSid = params.get("storeSid").toString();
        Store result = this.storeManageService.cancelStore(storeSid);
        return result;
    }
}

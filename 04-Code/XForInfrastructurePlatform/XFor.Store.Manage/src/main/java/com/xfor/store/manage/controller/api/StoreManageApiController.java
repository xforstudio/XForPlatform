package com.xfor.store.manage.controller.api;

import com.xfor.store.manage.service.StoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商店管理API控制器
 */
@RestController
@RequestMapping("/StoreManageApi")
public class StoreManageApiController {

    @Autowired
    private StoreManageService storeManageService;


}

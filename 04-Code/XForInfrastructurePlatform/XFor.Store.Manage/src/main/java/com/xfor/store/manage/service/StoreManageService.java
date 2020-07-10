package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.store.model.Store;
import com.xfor.infrastructure.core.store.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class StoreManageService extends BaseService {

    @Autowired
    private IStoreRepository storeRepository;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    /* Store */

    /**
     * 创建商店
     * @param fields
     * @return
     */
    public Store createStore(Store fields) {
        return null;
    }

    /**
     * 打开商店
     * @param storeSid
     * @return
     */
    public Store openStore(String storeSid) {
        return null;
    }

    /**
     * 关闭商店
     * @param storeSid
     * @return
     */
    public Store closeStore(String storeSid) {
        return null;
    }

    /**
     * 注销商店
     * @param storeSid
     * @return
     */
    public Store cancelStore(String storeSid) {
        return null;
    }
}

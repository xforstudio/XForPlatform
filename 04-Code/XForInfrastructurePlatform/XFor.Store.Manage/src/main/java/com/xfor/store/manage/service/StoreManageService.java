package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.store.model.Store;
import com.xfor.infrastructure.core.store.model.StoreException;
import com.xfor.infrastructure.core.store.model.StoreExistedException;
import com.xfor.infrastructure.core.store.model.StoreNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 商店管理服务
 */
@Component
public interface StoreManageService {

    /**
     * 创建商店
     * @param fields
     * @return
     */
    Store createStore(Store fields) throws StoreException;

    /**
     * 保存商店信息
     * @param fields
     * @return
     */
    Store saveStore(Store fields) throws StoreException;

    /**
     * 打开商店
     * @param storeSid
     * @return
     */
    Store openStore(String storeSid) throws StoreNotFoundException;

    /**
     * 关闭商店
     * @param storeSid
     * @return
     */
    Store closeStore(String storeSid) throws StoreNotFoundException;

    /**
     * 注销商店
     * @param storeSid
     * @return
     */
    Store cancelStore(String storeSid) throws StoreNotFoundException;
}

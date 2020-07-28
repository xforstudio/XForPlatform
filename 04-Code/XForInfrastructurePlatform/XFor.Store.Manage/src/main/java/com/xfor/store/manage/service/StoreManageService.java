package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.store.model.*;
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

    protected boolean doExistsStoreBySid(ServiceContext sctx, Store store) {
        int count = this.storeRepository.findStoreCountBySid(sctx, store.getCode());
        return count > 0;
    }

    protected boolean doExistsStoreByCode(ServiceContext sctx, Store store) {
        int count = this.storeRepository.findStoreCountByCode(sctx, store.getCode());
        return count > 0;
    }

    protected boolean doExistsStoreByName(ServiceContext sctx, Store store) {
        int count = this.storeRepository.findStoreCountByName(sctx, store.getName());
        return count > 0;
    }

    /* Store */

    /**
     * 创建商店
     * @param fields
     * @return
     */
    public Store createStore(Store fields) throws StoreException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = Store._create(
                fields.getCode(),
                fields.getName(),
                fields.getMemo(),
                this.dateTimeProvider);
        store.regist();
        store.validate();
        boolean result = false;
        result = this.doExistsStoreBySid(sctx, store);
        if (result) {
            throw new StoreExistedException("商店标识", store.getSid());
        }
        result = this.doExistsStoreByCode(sctx, store);
        if (result) {
            throw new StoreExistedException("商店代码", store.getCode());
        }
        result = this.doExistsStoreByCode(sctx, store);
        if (result) {
            throw new StoreExistedException("商店名称", store.getName());
        }
        result = this.storeRepository.saveStore(sctx, store);
        if (!result) {
            throw new StoreException("保存商品信息失败");
        }
        return store;
    }

    /**
     * 打开商店
     * @param storeSid
     * @return
     */
    public Store openStore(String storeSid) throws StoreNotFoundException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeRepository.findStoreBySid(sctx, storeSid);
        if (store == null) {
            throw new StoreNotFoundException("商品标识", storeSid);
        }
        store.open();
        return store;
    }

    /**
     * 关闭商店
     * @param storeSid
     * @return
     */
    public Store closeStore(String storeSid) throws StoreNotFoundException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeRepository.findStoreBySid(sctx, storeSid);
        if (store == null) {
            throw new StoreNotFoundException("商品标识", storeSid);
        }
        store.close();
        return store;
    }

    /**
     * 注销商店
     * @param storeSid
     * @return
     */
    public Store cancelStore(String storeSid) throws StoreNotFoundException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeRepository.findStoreBySid(sctx, storeSid);
        if (store == null) {
            throw new StoreNotFoundException("商品标识", storeSid);
        }
        store.cancel();
        return store;
    }
}

package com.xfor.store.manage.service.impl;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.store.model.*;
import com.xfor.infrastructure.core.store.dao.StoreDAO;
import com.xfor.store.manage.service.StoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商店管理服务
 */
@Service
public class StoreManageServiceImpl extends BaseService implements StoreManageService {

    @Autowired
    private StoreDAO storeDAO;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    /* Store */

    @Override
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
        result = this.storeDAO.saveStore(sctx, store);
        if (!result) {
            throw new StoreException("保存商品信息失败");
        }
        return store;
    }

    @Override
    public Store saveStore(Store fields) throws StoreException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeDAO.findStoreBySid(sctx, fields.getSid());
        if (store == null) {
            throw new StoreNotFoundException();
        }
        store.setName(fields.getName());
        store.setMemo(fields.getMemo());
        store.validate();
        //检查数据库
        boolean result = false;
        result = this.doExistsStoreByName(sctx, store);
        if (result) {
            throw new StoreExistedException("商店名称", store.getName());
        }
        result = this.storeDAO.saveStore(sctx, store);
        if (!result) {
            throw new StoreException("保存商品信息失败");
        }
        return store;
    }

    @Override
    public Store openStore(String storeSid) throws StoreNotFoundException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeDAO.findStoreBySid(sctx, storeSid);
        if (store == null) {
            throw new StoreNotFoundException("商品标识", storeSid);
        }
        store.open();
        this.storeDAO.saveStore(sctx, store);
        return store;
    }

    @Override
    public Store closeStore(String storeSid) throws StoreNotFoundException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeDAO.findStoreBySid(sctx, storeSid);
        if (store == null) {
            throw new StoreNotFoundException("商品标识", storeSid);
        }
        store.close();
        this.storeDAO.saveStore(sctx, store);
        return store;
    }

    @Override
    public Store cancelStore(String storeSid) throws StoreNotFoundException {
        ServiceContext sctx = this.doGetServiceContext();
        Store store = this.storeDAO.findStoreBySid(sctx, storeSid);
        if (store == null) {
            throw new StoreNotFoundException("商品标识", storeSid);
        }
        store.cancel();
        this.storeDAO.saveStore(sctx, store);
        return store;
    }

    protected boolean doExistsStoreBySid(ServiceContext sctx, Store store) {
        int count = this.storeDAO.findStoreCountBySid(sctx, store.getCode());
        return count > 0;
    }

    protected boolean doExistsStoreByCode(ServiceContext sctx, Store store) {
        int count = this.storeDAO.findStoreCountByCode(sctx, store.getCode());
        return count > 0;
    }

    protected boolean doExistsStoreByName(ServiceContext sctx, Store store) {
        int count = this.storeDAO.findStoreCountByName(sctx, store.getName());
        return count > 0;
    }
}

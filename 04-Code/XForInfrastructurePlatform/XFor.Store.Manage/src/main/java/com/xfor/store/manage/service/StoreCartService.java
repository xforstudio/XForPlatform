package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.provider.IProductProvider;
import com.xfor.infrastructure.core.store.model.StoreCart;
import com.xfor.infrastructure.core.store.model.StoreCartEntry;
import com.xfor.infrastructure.core.store.repository.IStoreCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 购物车服务
 */
@Component
public class StoreCartService extends BaseService {

    @Autowired
    private IStoreCartRepository storeCartRepository;
    @Autowired
    private IProductProvider productProvider;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    protected StoreCart dofindWithCreateStoreCart(ServiceContext sctx, String accountSid) {
        StoreCart storeCart = this.storeCartRepository.findStoreCartByAccountSid(sctx, accountSid);
        if (storeCart != null) {
            return storeCart;
        }
        storeCart = StoreCart._create(accountSid);
        this.storeCartRepository.saveStoreCart(sctx, storeCart);
        return storeCart;
    }

    public List<StoreCartEntry> getStoreCartEntryByStoreSid(String accountSid, String storeSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.dofindWithCreateStoreCart(sctx, accountSid);
        List<StoreCartEntry> result = storeCart.findEntriesByStoreSid(accountSid);
        return result;
    }

    public List<StoreCartEntry> getStoreCartEntryByAll(String accountSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.dofindWithCreateStoreCart(sctx, accountSid);
        List<StoreCartEntry> result = storeCart.getStoreCartEntries();
        return result;
    }

    public int increaseProduct(String accountSid, String storeSid, String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.dofindWithCreateStoreCart(sctx, accountSid);
        int result = storeCart.increaseProductQuantity(
                storeSid,
                productSid,
                this.productProvider,
                this.dateTimeProvider);
        return result;
    }

    public int decreaseProduct(String accountSid, String storeSid, String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.dofindWithCreateStoreCart(sctx, accountSid);
        int result = storeCart.decreaseProductQuantity(storeSid, productSid);
        return result;
    }

    public void removeProductsByStoreSid(String accountSid, String storeSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.dofindWithCreateStoreCart(sctx, accountSid);
        storeCart.removeEntriesByStoreSid(storeSid);
    }

    public void removeProductsByAll(String accountSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.dofindWithCreateStoreCart(sctx, accountSid);
        storeCart.clear();
    }
}

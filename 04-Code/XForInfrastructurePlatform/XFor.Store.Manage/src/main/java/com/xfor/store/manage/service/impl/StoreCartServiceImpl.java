package com.xfor.store.manage.service.impl;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.dao.ProductDAO;
import com.xfor.infrastructure.core.store.model.StoreCart;
import com.xfor.infrastructure.core.store.model.StoreCartEntry;
import com.xfor.infrastructure.core.store.dao.StoreCartDAO;
import com.xfor.store.manage.service.StoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 购物车服务
 */
@Component
public class StoreCartServiceImpl extends BaseService implements StoreCartService {

    @Autowired
    private StoreCartDAO storeCartDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    @Override
    public List<StoreCartEntry> listStoreCartEntriesByStoreSid(String accountSid, String storeSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.doFindWithCreateStoreCart(sctx, accountSid);
        List<StoreCartEntry> result = storeCart.findEntriesByStoreSid(accountSid);
        return result;
    }

    @Override
    public List<StoreCartEntry> listStoreCartEntriesByAll(String accountSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.doFindWithCreateStoreCart(sctx, accountSid);
        List<StoreCartEntry> result = storeCart.getStoreCartEntries();
        return result;
    }

    @Override
    public int increaseProduct(String accountSid, String storeSid, String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.doFindWithCreateStoreCart(sctx, accountSid);
        Product product = this.productDAO.getProductBySid(sctx, productSid);
        int result = storeCart.increaseProductQuantity(
                storeSid,
                product,
                this.dateTimeProvider);
        return result;
    }

    @Override
    public int decreaseProduct(String accountSid, String storeSid, String productSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.doFindWithCreateStoreCart(sctx, accountSid);
        int result = storeCart.decreaseProductQuantity(storeSid, productSid);
        return result;
    }

    @Override
    public void removeProductsByStoreSid(String accountSid, String storeSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.doFindWithCreateStoreCart(sctx, accountSid);
        storeCart.removeEntriesByStoreSid(storeSid);
    }

    @Override
    public void removeProductsByAll(String accountSid) {
        ServiceContext sctx = this.doGetServiceContext();
        StoreCart storeCart = this.doFindWithCreateStoreCart(sctx, accountSid);
        storeCart.clear();
    }

    protected StoreCart doFindWithCreateStoreCart(ServiceContext sctx, String accountSid) {
        StoreCart storeCart = this.storeCartDAO.findStoreCartByAccountSid(sctx, accountSid);
        if (storeCart != null) {
            return storeCart;
        }
        storeCart = StoreCart._create(accountSid);
        this.storeCartDAO.saveStoreCart(sctx, storeCart);
        return storeCart;
    }
}

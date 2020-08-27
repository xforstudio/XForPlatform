package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.store.model.StoreCart;
import com.xfor.infrastructure.core.store.model.StoreCartEntry;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 购物车服务
 */
@Component
public interface StoreCartService {

    List<StoreCartEntry> listStoreCartEntriesByStoreSid(String accountSid, String storeSid);

    List<StoreCartEntry> listStoreCartEntriesByAll(String accountSid);

    int increaseProduct(String accountSid, String storeSid, String productSid);

    int decreaseProduct(String accountSid, String storeSid, String productSid);

    void removeProductsByStoreSid(String accountSid, String storeSid);

    void removeProductsByAll(String accountSid);
}

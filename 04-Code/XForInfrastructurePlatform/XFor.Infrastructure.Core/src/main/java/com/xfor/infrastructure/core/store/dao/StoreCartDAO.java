package com.xfor.infrastructure.core.store.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.store.model.StoreCart;

/**
 *
 */
public interface StoreCartDAO {

    StoreCart findStoreCartBySid(ServiceContext sctx, String sid);

    StoreCart findStoreCartByAccountSid(ServiceContext sctx, String accountSid);

    boolean saveStoreCart(ServiceContext sctx, StoreCart storeCart);

    boolean removeStoreCartBySid(ServiceContext sctx, String sid);

    boolean removeStoreCartByAccountSid(ServiceContext sctx, String accountSid);
}

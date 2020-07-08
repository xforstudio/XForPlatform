package com.xfor.infrastructure.core.store.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.store.model.Store;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IStoreRepository {

    Store getStoreBySid(ServiceContext sctx, String sid);

    Store getStoreByCode(ServiceContext sctx, String code);

    List<Store> getStoreByFilter(ServiceContext sctx, String filter);

    boolean saveStore(ServiceContext sctx, Store order);

    boolean removeStoreBySid(ServiceContext sctx, String sid);
}

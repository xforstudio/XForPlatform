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

    Store findStoreBySid(ServiceContext sctx, String sid);

    Store findStoreByCode(ServiceContext sctx, String code);

    List<Store> findStoreByFilter(ServiceContext sctx, String filter);

    int findStoreCountBySid(ServiceContext sctx, String sid);

    int findStoreCountByCode(ServiceContext sctx, String code);

    int findStoreCountByName(ServiceContext sctx, String name);

    boolean saveStore(ServiceContext sctx, Store order);

    boolean removeStoreBySid(ServiceContext sctx, String sid);
}

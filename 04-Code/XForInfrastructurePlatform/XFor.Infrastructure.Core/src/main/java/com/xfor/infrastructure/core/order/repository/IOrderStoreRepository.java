package com.xfor.infrastructure.core.order.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.OrderStore;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IOrderStoreRepository {

    OrderStore getOrderStoreBySid(ServiceContext sctx, String sid);

    boolean saveOrderStore(ServiceContext sctx, OrderStore orderStore);

    boolean removeOrderStoreBySid(ServiceContext sctx, String sid);
}

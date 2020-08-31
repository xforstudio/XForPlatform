package com.xfor.infrastructure.core.order.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.OrderStore;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface OrderStoreDAO {

    OrderStore getOrderStoreBySid(ServiceContext sctx, String sid);

    boolean saveOrderStore(ServiceContext sctx, OrderStore orderStore);

    boolean removeOrderStoreBySid(ServiceContext sctx, String sid);
}

package com.xfor.infrastructure.core.order.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IOrderRepository {

    Order getOrderBySid(ServiceContext sctx, String sid);

    List<Order> getOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid);

    boolean saveOrder(ServiceContext sctx, Order order);

    boolean removeOrderBySid(ServiceContext sctx, String sid);

    boolean removeOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid);
}

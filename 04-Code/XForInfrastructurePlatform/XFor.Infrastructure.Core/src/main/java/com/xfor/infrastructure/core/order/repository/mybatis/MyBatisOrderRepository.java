package com.xfor.infrastructure.core.order.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisOrderRepository implements IOrderRepository {

    @Autowired
    private IOrderMyBatisDAO orderMyBatisDAO;

    public MyBatisOrderRepository() {
    }

    @Override
    public Order getOrderBySid(ServiceContext sctx, String sid) {
        return null;
    }

    @Override
    public List<Order> getOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid) {
        return null;
    }

    @Override
    public boolean saveOrder(ServiceContext sctx, Order order) {
        return false;
    }

    @Override
    public boolean removeOrderBySid(ServiceContext sctx, String sid) {
        return false;
    }

    @Override
    public boolean removeOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid) {
        return false;
    }
}

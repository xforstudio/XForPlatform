package com.xfor.infrastructure.core.order.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.order.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDAOImpl() {
    }

    @Override
    public Order getOrderBySid(ServiceContext sctx, String sid) {
        Order result = this.orderRepository.selectById(sid);
        return result;
    }

    @Override
    public List<Order> getOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_STORE_SID", orderStoreSid);
        List<Order> result = this.orderRepository.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveOrder(ServiceContext sctx, Order order) {
        int result = this.orderRepository.updateById(order);
        if(result <= 0) {
            result = this.orderRepository.insert(order);
        }
        return result > 0;
    }

    @Override
    public boolean removeOrderBySid(ServiceContext sctx, String sid) {
        int result = this.orderRepository.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_STORE_SID", orderStoreSid);
        int result = this.orderRepository.delete(wrapper);
        return result > 0;
    }
}

package com.xfor.infrastructure.core.order.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.order.model.OrderEntry;
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
        Order result = this.orderMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public List<Order> getOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_STORE_SID", orderStoreSid);
        List<Order> result = this.orderMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveOrder(ServiceContext sctx, Order order) {
        int result = this.orderMyBatisDAO.updateById(order);
        if(result <= 0) {
            result = this.orderMyBatisDAO.insert(order);
        }
        return result > 0;
    }

    @Override
    public boolean removeOrderBySid(ServiceContext sctx, String sid) {
        int result = this.orderMyBatisDAO.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeOrdersByOrderStoreSid(ServiceContext sctx, String orderStoreSid) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_STORE_SID", orderStoreSid);
        int result = this.orderMyBatisDAO.delete(wrapper);
        return result > 0;
    }
}

package com.xfor.infrastructure.core.order.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.OrderEntry;
import com.xfor.infrastructure.core.order.repository.IOrderEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class MyBatisOrderEntryRepository implements IOrderEntryRepository {

    @Autowired
    private IOrderEntryMyBatisDAO orderEntryMyBatisDAO;

    public MyBatisOrderEntryRepository() {
    }

    @Override
    public OrderEntry getOrderEntryBySid(ServiceContext sctx, String sid) {
        OrderEntry result = this.orderEntryMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public List<OrderEntry> getOrderEntriesByOrderSid(ServiceContext sctx, String orderSid) {
        QueryWrapper<OrderEntry> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_SID", orderSid);
        List<OrderEntry> result = this.orderEntryMyBatisDAO.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveOrderEntry(ServiceContext sctx, OrderEntry orderEntry) {
        int result = this.orderEntryMyBatisDAO.updateById(orderEntry);
        if(result <= 0) {
            result = this.orderEntryMyBatisDAO.insert(orderEntry);
        }
        return result > 0;
    }

    @Override
    public boolean removeOrderEntryBySid(ServiceContext sctx, String sid) {
        int result = this.orderEntryMyBatisDAO.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeOrderEntriesByOrderSid(ServiceContext sctx, String orderSid) {
        QueryWrapper<OrderEntry> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_SID", orderSid);
        int result = this.orderEntryMyBatisDAO.delete(wrapper);
        return result > 0;
    }
}

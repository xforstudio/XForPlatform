package com.xfor.infrastructure.core.order.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.OrderEntry;
import com.xfor.infrastructure.core.order.dao.OrderEntryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class OrderEntryDAOImpl implements OrderEntryDAO {

    @Autowired
    private OrderEntryRepository orderEntryRepository;

    public OrderEntryDAOImpl() {
    }

    @Override
    public OrderEntry getOrderEntryBySid(ServiceContext sctx, String sid) {
        OrderEntry result = this.orderEntryRepository.selectById(sid);
        return result;
    }

    @Override
    public List<OrderEntry> getOrderEntriesByOrderSid(ServiceContext sctx, String orderSid) {
        QueryWrapper<OrderEntry> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_SID", orderSid);
        List<OrderEntry> result = this.orderEntryRepository.selectList(wrapper);
        return result;
    }

    @Override
    public boolean saveOrderEntry(ServiceContext sctx, OrderEntry orderEntry) {
        int result = this.orderEntryRepository.updateById(orderEntry);
        if(result <= 0) {
            result = this.orderEntryRepository.insert(orderEntry);
        }
        return result > 0;
    }

    @Override
    public boolean removeOrderEntryBySid(ServiceContext sctx, String sid) {
        int result = this.orderEntryRepository.deleteById(sid);
        return result > 0;
    }

    @Override
    public boolean removeOrderEntriesByOrderSid(ServiceContext sctx, String orderSid) {
        QueryWrapper<OrderEntry> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_SID", orderSid);
        int result = this.orderEntryRepository.delete(wrapper);
        return result > 0;
    }
}

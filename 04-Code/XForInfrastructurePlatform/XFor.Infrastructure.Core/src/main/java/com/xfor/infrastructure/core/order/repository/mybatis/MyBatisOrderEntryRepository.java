package com.xfor.infrastructure.core.order.repository.mybatis;

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
        return null;
    }

    @Override
    public List<OrderEntry> getOrderEntriesByOrderSid(ServiceContext sctx, String orderSid) {
        return null;
    }

    @Override
    public boolean saveOrderEntry(ServiceContext sctx, OrderEntry orderEntry) {
        return false;
    }

    @Override
    public boolean saveOrderEntries(ServiceContext sctx, List<OrderEntry> orderEntries) {
        return false;
    }

    @Override
    public boolean removeOrderEntryBySid(ServiceContext sctx, String sid) {
        return false;
    }

    @Override
    public boolean removeOrderEntriesByOrderSid(ServiceContext sctx, String orderSid) {
        return false;
    }
}

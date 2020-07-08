package com.xfor.infrastructure.core.order.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.OrderEntry;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface IOrderEntryRepository {

    OrderEntry getOrderEntryBySid(ServiceContext sctx, String sid);

    List<OrderEntry> getOrderEntriesByOrderSid(ServiceContext sctx, String orderSid);

    boolean saveOrderEntry(ServiceContext sctx, OrderEntry orderEntry);

    boolean removeOrderEntryBySid(ServiceContext sctx, String sid);

    boolean removeOrderEntriesByOrderSid(ServiceContext sctx, String orderSid);
}

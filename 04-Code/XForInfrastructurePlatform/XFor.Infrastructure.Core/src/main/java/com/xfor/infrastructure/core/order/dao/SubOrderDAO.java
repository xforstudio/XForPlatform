package com.xfor.infrastructure.core.order.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.SubOrder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface SubOrderDAO {

    SubOrder getSubOrderBySid(ServiceContext sctx, String sid);

    List<SubOrder> getSubOrdersByOrderSid(ServiceContext sctx, String orderSid);

    boolean saveSubOrder(ServiceContext sctx, SubOrder subOrder);

    boolean removeSubOrderBySid(ServiceContext sctx, String sid);

    boolean removeSubOrdersByOrderSid(ServiceContext sctx, String orderSid);
}

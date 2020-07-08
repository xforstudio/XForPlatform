package com.xfor.infrastructure.core.order.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.order.model.OrderStore;
import com.xfor.infrastructure.core.order.repository.IOrderStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisOrderStoreRepository implements IOrderStoreRepository {

    @Autowired
    private IOrderStoreMyBatisDAO orderStoreMyBatisDAO;

    @Override
    public OrderStore getOrderStoreBySid(ServiceContext sctx, String sid) {
        OrderStore result = this.orderStoreMyBatisDAO.selectById(sid);
        return result;
    }

    @Override
    public boolean saveOrderStore(ServiceContext sctx, OrderStore orderStore) {
        int result = this.orderStoreMyBatisDAO.updateById(orderStore);
        if(result <= 0) {
            result = this.orderStoreMyBatisDAO.insert(orderStore);
        }
        return result > 0;
    }

    @Override
    public boolean removeOrderStoreBySid(ServiceContext sctx, String sid) {
        int result = this.orderStoreMyBatisDAO.deleteById(sid);
        return result > 0;
    }
}

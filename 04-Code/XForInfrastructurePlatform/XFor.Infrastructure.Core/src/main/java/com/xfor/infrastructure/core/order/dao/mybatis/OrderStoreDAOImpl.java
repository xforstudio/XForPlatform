package com.xfor.infrastructure.core.order.dao.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.order.model.OrderStore;
import com.xfor.infrastructure.core.order.dao.OrderStoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderStoreDAOImpl implements OrderStoreDAO {

    @Autowired
    private OrderStoreRepository orderStoreRepository;

    @Override
    public OrderStore getOrderStoreBySid(ServiceContext sctx, String sid) {
        OrderStore result = this.orderStoreRepository.selectById(sid);
        return result;
    }

    @Override
    public boolean saveOrderStore(ServiceContext sctx, OrderStore orderStore) {
        int result = this.orderStoreRepository.updateById(orderStore);
        if(result <= 0) {
            result = this.orderStoreRepository.insert(orderStore);
        }
        return result > 0;
    }

    @Override
    public boolean removeOrderStoreBySid(ServiceContext sctx, String sid) {
        int result = this.orderStoreRepository.deleteById(sid);
        return result > 0;
    }
}

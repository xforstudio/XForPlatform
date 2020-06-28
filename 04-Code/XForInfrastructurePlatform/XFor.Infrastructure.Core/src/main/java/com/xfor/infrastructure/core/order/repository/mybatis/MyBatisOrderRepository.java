package com.xfor.infrastructure.core.order.repository.mybatis;

import com.xfor.infrastructure.core.order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisOrderRepository implements IOrderRepository {

    @Autowired
    private IOrderMyBatisDAO orderMyBatisDAO;

    public MyBatisOrderRepository() {
    }
}

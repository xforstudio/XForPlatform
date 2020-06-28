package com.xfor.infrastructure.core.order.repository.mybatis;

import com.xfor.infrastructure.core.order.repository.ISubOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisSubOrderRepository implements ISubOrderRepository {

    @Autowired
    private ISubOrderMyBatisDAO subOrderMyBatisDAO;

    public MyBatisSubOrderRepository() {
    }
}

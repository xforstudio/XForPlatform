package com.xfor.infrastructure.core.payment.repository.mybatis;

import com.xfor.infrastructure.core.payment.repository.IPaymentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisPaymentOrderRepository implements IPaymentOrderRepository {

    @Autowired
    private IPaymentOrderMyBatisDAO paymentOrderMyBatisDAO;

    public MyBatisPaymentOrderRepository(){

    }
}

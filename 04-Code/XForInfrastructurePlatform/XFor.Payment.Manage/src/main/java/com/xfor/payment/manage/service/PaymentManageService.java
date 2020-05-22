package com.xfor.payment.manage.service;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.payment.repository.IPaymentHandleRepository;
import com.xfor.infrastructure.core.payment.repository.IPaymentMethodRepository;
import com.xfor.infrastructure.core.payment.repository.IPaymentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentManageService extends BaseService {

    @Autowired
    private IPaymentOrderRepository paymentOrderRepository;
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;
    @Autowired
    private IPaymentHandleRepository paymentHandleRepository;

    public PaymentManageService() {
        super();
    }
}



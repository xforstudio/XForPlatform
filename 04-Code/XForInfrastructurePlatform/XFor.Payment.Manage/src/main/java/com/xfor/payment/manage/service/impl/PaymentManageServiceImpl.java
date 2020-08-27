package com.xfor.payment.manage.service.impl;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.payment.repository.IPaymentHandleRepository;
import com.xfor.infrastructure.core.payment.repository.IPaymentMethodRepository;
import com.xfor.infrastructure.core.payment.repository.IPaymentOrderRepository;
import com.xfor.payment.manage.service.PaymentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentManageServiceImpl extends BaseService implements PaymentManageService {

    @Autowired
    private IPaymentOrderRepository paymentOrderRepository;
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;
    @Autowired
    private IPaymentHandleRepository paymentHandleRepository;

}



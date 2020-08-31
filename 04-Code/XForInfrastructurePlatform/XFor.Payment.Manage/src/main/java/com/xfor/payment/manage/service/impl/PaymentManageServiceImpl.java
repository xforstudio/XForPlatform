package com.xfor.payment.manage.service.impl;

import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.payment.dao.PaymentHandleDAO;
import com.xfor.infrastructure.core.payment.dao.PaymentMethodDAO;
import com.xfor.infrastructure.core.payment.dao.PaymentOrderDAO;
import com.xfor.payment.manage.service.PaymentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentManageServiceImpl extends BaseService implements PaymentManageService {

    @Autowired
    private PaymentOrderDAO paymentOrderRepository;
    @Autowired
    private PaymentMethodDAO paymentMethodRepository;
    @Autowired
    private PaymentHandleDAO paymentHandleRepository;

}



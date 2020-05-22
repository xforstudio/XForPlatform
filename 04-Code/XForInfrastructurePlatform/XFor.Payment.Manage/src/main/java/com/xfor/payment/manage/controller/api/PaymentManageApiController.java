package com.xfor.payment.manage.controller.api;

import com.xfor.payment.manage.service.PaymentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentManageApiController {

    @Autowired
    private PaymentManageService paymentManageService;

    public PaymentManageApiController() {

    }
}

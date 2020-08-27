package com.xfor.finance.manage.service.impl;

import com.xfor.finance.manage.manager.nuonuo.NNInvoiceManager;
import com.xfor.finance.manage.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 诺诺发票服务
 */
@Component
public class NNInvoiceServiceImpl implements InvoiceService {

    @Autowired
    private NNInvoiceManager invoiceManager;

    public NNInvoiceServiceImpl() {
    }
}

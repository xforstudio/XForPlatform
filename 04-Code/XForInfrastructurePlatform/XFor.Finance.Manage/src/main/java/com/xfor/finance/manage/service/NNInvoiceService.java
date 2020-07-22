package com.xfor.finance.manage.service;

import com.xfor.finance.manage.manager.nuonuo.NNInvoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 诺诺发票服务
 */
@Component
public class NNInvoiceService implements IInvoiceService {

    @Autowired
    private NNInvoiceManager invoiceManager;

    public NNInvoiceService() {
    }
}

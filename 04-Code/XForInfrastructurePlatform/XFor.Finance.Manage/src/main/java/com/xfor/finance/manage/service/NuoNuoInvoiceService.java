package com.xfor.finance.manage.service;

import com.xfor.finance.manage.manager.NuoNuoInvoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 诺诺发票服务
 */
@Component
public class NuoNuoInvoiceService implements IInvoiceService {

    @Autowired
    private NuoNuoInvoiceManager invoiceManager;

    public NuoNuoInvoiceService() {
    }
}

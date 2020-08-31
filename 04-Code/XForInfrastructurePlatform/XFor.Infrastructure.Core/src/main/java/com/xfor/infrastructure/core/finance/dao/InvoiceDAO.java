package com.xfor.infrastructure.core.finance.dao;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.finance.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface InvoiceDAO {

    Invoice getInvoiceBySid(ServiceContext sctx, String sid);

    Invoice getInvoiceByNumber(ServiceContext sctx, String number);

    List<Invoice> getInvoicesByOrderSid(ServiceContext sctx, String orderSid);

    boolean saveInvoice(ServiceContext sctx, Invoice invoice);

    boolean removeInvoiceBySid(ServiceContext sctx, String sid);

    boolean removeInvoiceByNumber(ServiceContext sctx, String number);
}

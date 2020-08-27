package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.store.model.StoreCart;
import com.xfor.infrastructure.core.store.model.StoreException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收款台服务
 */
@Component
public interface StoreCashierService {

    //结算（从购物车发起结算）
    Order settleFromStoreCart(String accountSid, List<String> storeCartEntrySids) throws StoreException;

    //结算（直接购买）
    Order settleFromProduct(String accountSid, String storeSid, String productSid) throws ProductException;

    //提交订单
    Order confirmOrder(Order fields);
}

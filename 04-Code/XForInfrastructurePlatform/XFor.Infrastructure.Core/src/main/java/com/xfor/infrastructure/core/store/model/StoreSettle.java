package com.xfor.infrastructure.core.store.model;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.product.model.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 商店结算
 */
@Data
public class StoreSettle {

    private String accountSid;  //账户标识
    private Date createTime;  //创建时间
    private Date modifyTime;  //最后修改时间
    private Order order;

    public StoreSettle(String accountSid, IDateTimeProvider dateTimeProvider) {
        this.accountSid = accountSid;
        this.createTime = dateTimeProvider.getNow();
        this.modifyTime = dateTimeProvider.getNow();
    }

    //创建订单
    public Order createOrder(List<StoreCartEntry> storeCartEntries, IDateTimeProvider dateTimeProvider) {
        return null;
    }

    //创建订单
    public Order createOrder(List<Product> products) {
        return null;
    }
}

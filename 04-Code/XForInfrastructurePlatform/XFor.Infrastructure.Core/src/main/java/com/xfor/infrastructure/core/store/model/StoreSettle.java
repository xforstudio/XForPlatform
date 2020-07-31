package com.xfor.infrastructure.core.store.model;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.order.model.Order;

import java.util.List;

/**
 * 商店结算
 */
public class StoreSettle {

    private Order order;
    private IDateTimeProvider dateTimeProvider;

    public StoreSettle(String accountSid, IDateTimeProvider dateTimeProvider) {

        //this.order = Order._create()
    }

    public void addStoreCartEntries(List<StoreCartEntry> storeCartEntries) {

    }
}

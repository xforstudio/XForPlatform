package com.xfor.store.manage.service.impl;

import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.service.BaseService;
import com.xfor.infrastructure.core.order.model.Order;
import com.xfor.infrastructure.core.order.model.OrderEntry;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductException;
import com.xfor.infrastructure.core.product.dao.ProductDAO;
import com.xfor.infrastructure.core.store.model.StoreCart;
import com.xfor.infrastructure.core.store.model.StoreCartEntry;
import com.xfor.infrastructure.core.store.model.StoreException;
import com.xfor.infrastructure.core.store.dao.StoreCartDAO;
import com.xfor.store.manage.service.StoreCashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收款台服务
 */
@Component
public class StoreCashierServiceImpl extends BaseService implements StoreCashierService {

    @Autowired
    private StoreCartDAO storeCartRepository;
    @Autowired
    private ProductDAO productRepository;
    @Autowired
    private IDateTimeProvider dateTimeProvider;

    protected OrderEntry doMakeOrderEntry(StoreCartEntry storeCartEntry) {
        return null;
    }

    //结算（从购物车发起结算）
    protected Order doSettle(StoreCart storeCart) {
        return null;
    }

    //结算（从购物车发起结算）
    @Override
    public Order settleFromStoreCart(String accountSid, List<String> storeCartEntrySids) throws StoreException {
        StoreCart storeCart = this.storeCartRepository.findStoreCartByAccountSid(this.doGetServiceContext(), accountSid);
        if (storeCart == null) {
            throw new StoreException("购物车未找到");
        }
        //获取最终购物车
        StoreCart storeCart_final = storeCart.selectEntries(storeCartEntrySids);
        //创建订单
        Order result = this.doSettle(storeCart_final);
        return result;
    }

    //结算（直接购买）
    @Override
    public Order settleFromProduct(String accountSid, String storeSid, String productSid) throws ProductException {
        Product product = this.productRepository.getProductBySid(this.doGetServiceContext(), productSid);
        if (product == null) {
            throw new ProductException("商品未找到");
        }
        //获取最终购物车
        StoreCart storeCart_final = StoreCart._create(accountSid);
        storeCart_final.increaseProductQuantity(storeSid, product, this.dateTimeProvider);
        //创建订单
        Order result = this.doSettle(storeCart_final);
        return result;
    }

    //提交订单
    @Override
    public Order confirmOrder(Order fields) {
        return null;
    }
}

package com.xfor.infrastructure.core.store.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.product.provider.IProductProvider;
import com.xfor.infrastructure.core.product.model.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 */
@Data
@TableName("STORE_CART")
public class StoreCart extends BaseEntity {

    public static StoreCart _create(String accountSid) {
        StoreCart storeCart = new StoreCart();
        storeCart.setSid(_newSID());
        storeCart.setAccountSid(accountSid);
        return storeCart;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //购物车唯一标识

    @JsonProperty("AccountSid")
    @TableField("ACCOUNT_SID")
    private String accountSid;  //账户唯一标识

    @JsonProperty("StoreCartEntries")
    private List<StoreCartEntry> storeCartEntries = new ArrayList<>();

    public StoreCartEntry findEntryById(String entryId) {
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            if (entry.getId().equals(entryId)) {
                return entry;
            }
        }
        return null;
    }

    public StoreCartEntry findEntryByProductSid(String storeSid, String productSid) {
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            if (entry.getStoreSid().equals(storeSid) && entry.getProductSid().equals(productSid)) {
                return entry;
            }
        }
        return null;
    }

    public List<StoreCartEntry> findEntriesByStoreSid(String storeSid) {
        List<StoreCartEntry> result = new ArrayList<>();
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            if (entry.getStoreSid().equals(storeSid)) {
                result.add(entry);
            }
        }
        return result;
    }

    /**
     * 移除购物车项
     */
    public void removeEntries(List<String> entryIds) {
        this.getStoreCartEntries().removeIf(x -> entryIds.contains(x));
    }

    public boolean removeEntriesByStoreSid(String storeSid) {
        List<StoreCartEntry> entries = this.findEntriesByStoreSid(storeSid);
        boolean result = this.storeCartEntries.removeAll(entries);
        return result;
    }

    /**
     * 增加商品数量
     */
    public int increaseProductQuantity(
            String storeSid,
            String productSid,
            IProductProvider productProvider,
            IDateTimeProvider dateTimeProvider) {
        StoreCartEntry entry = this.findEntryByProductSid(storeSid, productSid);
        if (entry != null) {
            int result = entry.increaseQuantity();
            return result;
        }
        Product product = productProvider.getProductBySid(productSid);
        entry = StoreCartEntry._createFromProduct(product, 1, dateTimeProvider);
        this.storeCartEntries.add(entry);
        return entry.getProductQuantity();
    }

    /**
     * 减少商品数量
     */
    public int decreaseProductQuantity(String storeSid, String productSid) {
        StoreCartEntry entry = this.findEntryByProductSid(storeSid, productSid);
        if (entry == null) {
            return 0;
        }
        int result = entry.decreaseQuantity();
        if (result > 0) {
            return result;
        }
        //等于0，则删除该项
        this.storeCartEntries.remove(entry);
        return 0;
    }

    /**
     * 清空购物车
     */
    public void clear() {
        this.storeCartEntries.clear();
    }

    /**
     * 获取最终价格
     */
    public float getFinalPrice() {
        float finalPrice = 0;
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            finalPrice += entry.getProductPrice();
        }
        return finalPrice;
    }

    /**
     * 获取最终价格
     */
    public float getFinalPrice(String storeSid) {
        float finalPrice = 0;
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            if (entry.getStoreSid() != storeSid) {
                continue;
            }
            finalPrice += entry.getProductPrice();
        }
        return finalPrice;
    }

    /**
     * 获取最终价格集合
     */
    public Map<String, Float> getFinalPriceMap() {
        Map<String, Float> result = new HashMap<>();
        float finalPrice = 0;
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            if (!result.containsKey(entry.getStoreSid())) {
                result.put(entry.getStoreSid(), 0F);
            }
            float price = result.get(entry.getStoreSid()) + entry.getProductPrice();
            result.replace(entry.getStoreSid(), price);
        }
        return result;
    }
}

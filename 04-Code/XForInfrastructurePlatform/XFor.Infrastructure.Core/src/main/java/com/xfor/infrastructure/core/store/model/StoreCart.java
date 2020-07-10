package com.xfor.infrastructure.core.store.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 */
@Data
@TableName("STORE_CART")
public class StoreCart extends BaseEntity {

    public static StoreCart _create(String storeSid, String accountSid) {
        StoreCart storeCart = new StoreCart();
        storeCart.setSid(_newSID());
        storeCart.setStoreSid(storeSid);
        storeCart.setAccountSid(accountSid);
        return storeCart;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //购物车唯一标识

    @JsonProperty("StoreSid")
    @TableField("STORE_SID")
    private String storeSid;  //商店唯一标识

    @JsonProperty("AccountSid")
    @TableField("ACCOUNT_SID")
    private String accountSid;  //账户唯一标识

    @JsonProperty("StoreCartEntries")
    private List<StoreCartEntry> storeCartEntries = new ArrayList<>();

    /**
     * 添加购物项
     * @param entry
     */
    public void addEntry(StoreCartEntry entry) {
        this.getStoreCartEntries().add(entry);
    }

    /**
     * 清空购物项
     */
    public void clearEntries() {
        this.storeCartEntries.clear();
    }

    /**
     * 获取最终价格
     * @return
     */
    public float getFinalPrice() {
        float finalPrice = 0;
        for (StoreCartEntry entry : this.getStoreCartEntries()) {
            finalPrice += entry.getProductPrice();
        }
        return finalPrice;
    }
}

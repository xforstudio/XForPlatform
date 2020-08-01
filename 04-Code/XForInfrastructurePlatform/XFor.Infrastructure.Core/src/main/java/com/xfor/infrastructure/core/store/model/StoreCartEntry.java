package com.xfor.infrastructure.core.store.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.util.RandomUtil;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductSaleEntry;
import lombok.Data;

import java.util.Date;
import java.util.Random;

/**
 * 购物车项
 */
@Data
public class StoreCartEntry {

    public static String _newId() {
        String id = RandomUtil._nextIntWithFormat(8, "%08d");
        return id;
    }

    public static StoreCartEntry _createFromProduct(
            Product product,
            int productQuantity,
            IDateTimeProvider dateTimeProvider) {
        StoreCartEntry storeCartEntry = new StoreCartEntry();
        storeCartEntry.setId(_newId());
        storeCartEntry.setProductSid(product.getSid());
        storeCartEntry.setProductSaleEntry(ProductSaleEntry._create(product, productQuantity));
        storeCartEntry.setCreateTime(dateTimeProvider.getNow());
        return storeCartEntry;
    }

    @JsonProperty("Id")
    private String id;

    @JsonProperty("StoreSid")
    private String storeSid;  //商店唯一标识

    @JsonProperty("ProductSid")
    private String productSid;  //商品唯一标识

    @JsonProperty("ProductSaleEntry")
    private ProductSaleEntry productSaleEntry;  //商品出售项

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public int increaseQuantity() {
        return this.productSaleEntry.increaseQuantity();
    }

    public int decreaseQuantity() {
        return this.productSaleEntry.decreaseQuantity();
    }
}

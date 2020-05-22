package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 订单项
 */
@Data
@TableName("ORDER_ENTRY")
public class OrderEntry {

    @TableId("SID")
    private String sid;
    @TableId("ORDER_SID")
    private String orderSID;
    @TableId("PRODUCT_SID")
    private String productSID;
    @TableId("PRODUCT_PRICE")
    private float productPrice;
    @TableId("PRODUCT_QUANTITY")
    private float productQuantity;
    @TableId("FINAL_PRICE")
    private float finalPrice;
}

package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private String sid;  //标识
    @TableField("ORDER_SID")
    private String orderSID;  //订单标识
    @TableField("PRODUCT_SID")
    private String productCode;  //商品代码
    @TableField("PRODUCT_PRICE")
    private float productPrice;  //商品价格
    @TableField("PRODUCT_QUANTITY")
    private float productQuantity;  //商品数量
    @TableField("FINAL_PRICE")
    private float finalPrice;  //最终价格
}

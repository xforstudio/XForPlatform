package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import lombok.Data;

/**
 * 订单项
 */
@Data
@TableName("ORDER_ENTRY")
public class OrderEntry extends BaseEntity {

    public static OrderEntry _create(
            String orderSID,
            String productSid,
            int quantity,
            float finalTotalPrice) {
        OrderEntry orderEntry = new OrderEntry();
        orderEntry.setSid(_newSID());
        orderEntry.setOrderSID(orderSID);
        orderEntry.setProductSid(productSid);
        orderEntry.setQuantity(quantity);
        orderEntry.setFinalTotalPrice(finalTotalPrice);
        return orderEntry;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //标识

    @JsonProperty("OrderSid")
    @TableField("ORDER_SID")
    private String orderSID;  //订单标识

    @JsonProperty("ProductSid")
    @TableField("PRODUCT_SID")
    private String productSid;  //商品唯一标识

    @JsonProperty("Quantity")
    @TableField("QUANTITY")
    private int quantity;  //数量

    @JsonProperty("FinalTotalPrice")
    @TableField("FINAL_TOTAL_PRICE")
    private float finalTotalPrice;  //最终合计价格

//    /**
//     * 计算最终价格
//     * @return
//     */
//    public float calcFinalPrice() {
//        float result = this.getProductPrice() * this.getProductQuantity();
//        return result;
//    }

}

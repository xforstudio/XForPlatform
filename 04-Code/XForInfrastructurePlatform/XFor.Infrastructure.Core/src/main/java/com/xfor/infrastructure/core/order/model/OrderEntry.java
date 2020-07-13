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
            float productPrice,
            float productQuantity) {
        OrderEntry orderEntry = new OrderEntry();
        orderEntry.setSid(_newSID());
        orderEntry.setOrderSID(orderSID);
        orderEntry.setProductSid(productSid);
        orderEntry.setProductPrice(productPrice);
        orderEntry.setProductQuantity(productQuantity);
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

    @JsonProperty("ProductPrice")
    @TableField("PRODUCT_PRICE")
    private float productPrice;  //商品价格

    @JsonProperty("ProductQuantity")
    @TableField("PRODUCT_QUANTITY")
    private float productQuantity;  //商品数量

    @JsonProperty("FinalPrice")
    @TableField("FINAL_PRICE")
    private float finalPrice;  //最终价格

    /**
     * 计算最终价格
     * @return
     */
    public float calcFinalPrice() {
        float result = this.getProductPrice() * this.getProductQuantity();
        return result;
    }

    public boolean equalsSid(String sid) {
        if (this.getSid() == null) {
            return sid == null;
        }
        return this.getSid().equals(sid);
    }
}

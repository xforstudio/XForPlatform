package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@TableName("ORDER")
public class Order {

    public static String _newCode

    public static Order _create() {

    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //订单唯一标识

    @JsonProperty("Code")
    @TableField("CODE")
    private String code;  //订单号

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_TIME")
    private Date createTime;

    @JsonProperty("State")
    @TableField("STATE")
    private int state = OrderStateEnum.None;  //订单状态

    @JsonProperty("PaymentOrderCode")
    @TableId("PAYMENT_ORDER_CODE")
    private String paymentOrderCode;  //支付订单号

    @JsonProperty("FinalPrice")
    @TableField("FINAL_PRICE")
    private float finalPrice;  //最终价格

    /**
     * 订单项集合
     */
    @JsonProperty("OrderEntries")
    private List<OrderEntry> orderEntries = new ArrayList<>();

    /**
     * 子订单集合
     */
    @JsonProperty("SubOrders")
    private List<SubOrder> subOrders = new ArrayList<>();
}

package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@TableName("ORDER")
public class Order {

    @TableId("SID")
    private String sid;  //订单唯一标识
    @TableField("CODE")
    private String code;  //订单号
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("STATE")
    private int state = OrderStateEnum.None;  //订单状态
    @TableId("PAYMENT_ORDER_SID")
    private String paymentOrderCode;  //支付订单号
    @TableField("FINAL_PRICE")
    private float finalPrice;  //最终价格

    private List<OrderEntry> orderEntries;
    private List<SubOrder> subOrders;
}

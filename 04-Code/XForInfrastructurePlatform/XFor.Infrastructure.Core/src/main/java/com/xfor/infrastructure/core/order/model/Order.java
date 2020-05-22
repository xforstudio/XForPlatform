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
    private String sid;
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableId("PAYMENT_ORDER_SID")
    private String paymentOrderSID;

    private List<OrderEntry> orderEntries;

}

package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ORDER_STORE")
public class OrderStore {

    @TableId("SID")
    private String sid;  //订单唯一标识
    @TableField("CODE")
    private String code;  //订单号
}

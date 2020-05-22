package com.xfor.infrastructure.core.payment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 支付方式
 */
@Data
@TableName("PAYMENT_METHOD")
public class PaymentMethod {

    @TableId("id")
    private String id;
    @TableField("NAME")
    private String name;
}

package com.xfor.infrastructure.core.payment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *
 */
@Data
@TableName("PAYMENT_HANDLE")
public class PaymentHandle {

    @TableId("ID")
    private String id;
    @TableField("NAME")
    private String name;
}

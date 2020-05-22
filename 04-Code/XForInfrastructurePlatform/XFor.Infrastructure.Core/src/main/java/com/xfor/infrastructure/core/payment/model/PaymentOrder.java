package com.xfor.infrastructure.core.payment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("PAYMENT_ORDER")
public class PaymentOrder {

    @TableId("SID")
    private String sid;
    @TableField("SN")
    private String sn;
    @TableField("TYPE")
    private int type;
    @TableField("STATE")
    private int state;
    @TableField("AMOUNT")
    private float amount;
    @TableField("CURRENCY")
    private int currency;
    @TableField("METHOD_ID")
    private String methodID;
    @TableField("METHOD_CODE")
    private String methodCode;
    @TableField("METHOD_INFO")
    private String methodInfo;
    @TableField("HANDLE_ID")
    private String handleID;
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("MODIFY_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
}

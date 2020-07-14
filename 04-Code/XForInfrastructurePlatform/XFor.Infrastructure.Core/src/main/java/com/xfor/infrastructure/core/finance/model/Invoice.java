package com.xfor.infrastructure.core.finance.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 发票
 */
@Data
@TableName("INVOICE")
public class Invoice {

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //唯一标识

    @JsonProperty("OrderSid")
    @TableField("ORDER_SID")
    private String orderSid;  //订单唯一标识

    @JsonProperty("OrderAmount")
    @TableField("ORDER_AMOUNT")
    private float orderAmount;  //订单金额

    @JsonProperty("TitleName")
    @TableField("TITLE_NAME")
    private String titleName;  //抬头名称

    @JsonProperty("State")
    @TableField("STATE")
    private int state = InvoiceStateEnum.None;  //发票状态

    @JsonProperty("Number")
    @TableField("NUMBER")
    private String number;  //发票号

    @JsonProperty("VoucherContent")
    @TableField("VOUCHER_CONTENT")
    private String voucherContent;  //凭证内容

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_TIME")
    private Date createTime;  //创建时间
}

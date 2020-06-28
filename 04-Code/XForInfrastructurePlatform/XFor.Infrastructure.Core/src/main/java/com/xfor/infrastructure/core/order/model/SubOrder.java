package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 子订单
 */
@Data
@TableName("SUBORDER")
public class SubOrder {

    @TableId("SID")
    private String sid;  //子订单唯一标识
    @TableField("CODE")
    private String code;  //子订单号
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("FINAL_PRICE")
    private float finalPrice;

    private List<OrderEntry> orderEntries;
}

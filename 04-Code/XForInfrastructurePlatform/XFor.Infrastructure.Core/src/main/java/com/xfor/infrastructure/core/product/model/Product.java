package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 商品
 */
@Data
@TableName("PRODUCT")
public class Product {

    @TableId("SID")
    private String sid;
    @TableId("NAME")
    private String name;
    @TableId("DESC")
    private String desc;
    @TableId("PICTURES")
    private String pictures;
    @TableId("PRICE")
    private float price;

}

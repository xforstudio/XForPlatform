package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品类别
 */
@Data
@TableName("PRODUCT_CATEGORY")
public class ProductCategory {

    @TableId("SID")
    private String sid;
    @TableField("PRODUCT_STORE_SID")
    private String productStoreSid;
    @TableField("CODE")
    private int code;
    @TableField("NAME")
    private String name;
    @TableField("DESC")
    private String desc;
    @TableField("PARENT_CODE")
    private int parentCode;

    public ProductCategory() {
    }
}

package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * 商品标签
 */
@Data
@TableName("PRODUCT_TAG")
public class ProductTag {

    @TableId("SID")
    private String sid;
    @TableField("PRODUCT_STORE_SID")
    private String productStoreSID;
    @TableField("CODE")
    private int code;
    @TableField("NAME")
    private String name;
    @TableField("PARENT_CODE")
    private int parentCode;

    private List<ProductTag> subTags;

    public ProductTag() {
    }
}

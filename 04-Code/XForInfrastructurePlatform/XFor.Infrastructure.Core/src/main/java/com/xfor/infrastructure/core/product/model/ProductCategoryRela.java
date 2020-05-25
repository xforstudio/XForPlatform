package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品类别关联
 */
@Data
@TableName("PRODUCT_CATEGORY_RELA")
public class ProductCategoryRela {

    @TableId("SID")
    private String sid;
    @TableField("PRODUCT_STORE_SID")
    private String productStoreSID;
    @TableField("CATEGORY_CODE")
    private int categoryCode;
    @TableField("PRODUCT_CODE")
    private String productCode;

    public ProductCategoryRela() {
    }

}

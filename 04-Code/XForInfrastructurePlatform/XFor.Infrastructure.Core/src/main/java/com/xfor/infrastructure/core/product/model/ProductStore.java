package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商品集
 */
@Data
@TableName("PRODUCT_STORE")
public class ProductStore {

    @TableId("SID")
    private String sid;
    @TableField("NAME")
    private String name;
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date createTime;
    @TableField("OWNER")
    private String owner;

    public ProductStore() {
    }
}

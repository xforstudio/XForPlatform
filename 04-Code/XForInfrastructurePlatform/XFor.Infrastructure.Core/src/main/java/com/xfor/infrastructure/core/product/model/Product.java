package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xfor.infrastructure.core.common.model.SID;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 商品
 */
@Data
@TableName("PRODUCT")
public class Product {

    public static String _newSID() {
        return SID._newSID();
    }

    public static Product _create(String productStoreSid, String code, String name, String desc,
                                  float price, int saleState) {
        Product product = new Product();
        product.setSid(_newSID());
        product.setName(name);
        product.setDesc(desc);
        product.setCode(code);
        product.setPrice(price);
        product.setSaleState(saleState);
        product.setProductStoreSid(productStoreSid);
        return product;
    }

    @TableId("SID")
    private String sid;
    @TableField("CODE")
    private String code;
    @TableField("NAME")
    private String name;
    @TableField("DESC")
    private String desc;
    @TableField("PRICE")
    private float price;
    @TableField("PICTURES")
    private String pictures;
    @TableField("SALE_STATE")
    private int saleState;
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    private Date createTime;
    @TableField("TAGS")
    private List<String> tags;
    @TableField("PRODUCT_STORE_SID")
    private String productStoreSid;

    public Product() {
    }

    public void validate() {
        return;
    }
}

package com.xfor.infrastructure.core.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
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

    public static Product _create(String productStoreSid, String code, String name, String memo,
                                  float price, int saleState, IDateTimeProvider dateTimeProvider) {
        Product product = new Product();
        product.setSid(_newSID());
        product.setName(name);
        product.setMemo(memo);
        product.setCode(code);
        product.setPrice(price);
        product.setSaleState(saleState);
        product.setProductStoreSid(productStoreSid);
        product.setCreateTime(dateTimeProvider.getNow());
        return product;
    }

    //@SerializedName(value = "Sid")
    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    //@SerializedName(value = "Code")
    @JsonProperty("Code")
    @TableField("CODE")
    private String code;

    //@SerializedName(value = "Name")
    @JsonProperty("Name")
    @TableField("NAME")
    private String name;

    //@SerializedName(value = "Memo")
    @JsonProperty("Memo")
    @TableField("MEMO")
    private String memo;

    //@SerializedName(value = "CreateTime")
    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("CREATE_TIME")
    private Date createTime;

    //@SerializedName(value = "PicturesContent")
    @JsonProperty("PicturesContent")
    @TableField("PICTURES_CONTENT")
    private String picturesContent;

    //@SerializedName(value = "Price")
    @JsonProperty("Price")
    @TableField("PRICE")
    private float price;

    //@SerializedName(value = "SaleState")
    @JsonProperty("SaleState")
    @TableField("SALE_STATE")
    private int saleState;

    //@SerializedName(value = "TagsContent")
    @JsonProperty("TagsContent")
    @TableField("TAGS_CONTENT")
    private String tagsContent;

    //@SerializedName(value = "ProductStoreSid")
    @JsonProperty("ProductStoreSid")
    @TableField("PRODUCT_STORE_SID")
    private String productStoreSid;

    public Product() {
    }

    public void validate() {
        return;
    }
}

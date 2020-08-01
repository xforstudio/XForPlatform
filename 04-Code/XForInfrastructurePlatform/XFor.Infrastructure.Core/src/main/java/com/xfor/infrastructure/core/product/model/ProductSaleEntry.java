package com.xfor.infrastructure.core.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 商品出售条目
 */
@Data
public class ProductSaleEntry {

    public static ProductSaleEntry _create(Product product, int quantity) {
        ProductSaleEntry result = new ProductSaleEntry();
        result.setProductSid(product.getSid());
        result.setQuantity(quantity);
        result.setInitUnitPrice(product.getPrice());
        result.setFinalTotalPrice(product.getPrice());
        result.setProduct(product);
        return result;
    }

    @JsonProperty("ProductSid")
    private String productSid;  //商品唯一标识

    @JsonProperty("Quantity")
    private int quantity;  //商品数量

    @JsonProperty("InitUnitPrice")
    private float initUnitPrice;  //商品初始单价

    @JsonProperty("FinalUnitPrice")
    private float finalUnitPrice;  //商品最终单价

    @JsonProperty("FinalTotalPrice")
    private float finalTotalPrice;  //商品最终总价

    private Product product;

    public int increaseQuantity() {
        this.quantity += 1;
        return this.quantity;
    }

    public int decreaseQuantity() {
        if (this.quantity > 0) {
            this.quantity -= 1;
        }
        return this.quantity;
    }
}

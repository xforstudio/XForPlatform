package com.xfor.infrastructure.core.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.util.RandomUtil;
import com.xfor.infrastructure.core.product.model.Product;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@TableName("ORDER")
public class Order extends BaseEntity {

    public static String _newCode(IDateTimeProvider dateTimeProvider) {
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix = dateFormat.format(dateTimeProvider.getNow());
        String suffix = RandomUtil._nextIntWithFormat(6, "%06d");
        String result = prefix + suffix;
        return result;
    }

    public static Order _create(String accountSid, IDateTimeProvider dateTimeProvider) {
        Order order = new Order();
        order.setSid(_newSID());
        order.setAccountSid(accountSid);
        order.setCreateTime(dateTimeProvider.getNow());
        return order;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //订单唯一标识

    @JsonProperty("Code")
    @TableField("CODE")
    private String code;  //订单号

    @JsonProperty("AccountSid")
    @TableField("ACCOUNT_SID")
    private String accountSid;  //账号标识

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_TIME")
    private Date createTime;

    @JsonProperty("State")
    @TableField("STATE")
    private int state = OrderStateEnum.None;  //订单状态

    @JsonProperty("PaymentOrderCode")
    @TableField("PAYMENT_ORDER_CODE")
    private String paymentOrderCode;  //支付订单号

    @JsonProperty("FinalPrice")
    @TableField("FINAL_PRICE")
    private float finalPrice;  //最终价格

    /**
     * 订单项集合
     */
    @JsonProperty("OrderEntries")
    private List<OrderEntry> orderEntries = new ArrayList<>();

    /**
     * 子订单集合
     */
    @JsonProperty("SubOrders")
    private List<SubOrder> subOrders = new ArrayList<>();

    /**
     * 
     * @param orderEntrySid
     * @return
     */
    public OrderEntry findOrderEntryBySid(String orderEntrySid) {
        for (OrderEntry orderEntry : this.getOrderEntries()) {
            if (orderEntry.equalsSid(orderEntrySid)) {
                return orderEntry;
            }
        }
        return null;
    }

    /**
     * 创建、添加订单项
     * @param product
     * @param productQuantity
     * @return
     */
    public OrderEntry createOrderEntry(Product product, int quantity) {
        OrderEntry orderEntry = OrderEntry._create(
                this.getSid(),
                product.getSid(),
                quantity,
                product.getPrice() * quantity
                );
        return orderEntry;
    }

    public OrderEntry createOrderEntry(String productSid, int quantity, float finalTotalPrice) {
        OrderEntry orderEntry = OrderEntry._create(
                this.getSid(),
                productSid,
                quantity,
                finalTotalPrice
        );
        return orderEntry;
    }

    public OrderEntry removeOrderEntry(String orderEntrySid) {
        OrderEntry orderEntry = this.findOrderEntryBySid(orderEntrySid);
        if (orderEntry != null) {
            this.getOrderEntries().remove(orderEntry);
        }
        return orderEntry;
    }
}

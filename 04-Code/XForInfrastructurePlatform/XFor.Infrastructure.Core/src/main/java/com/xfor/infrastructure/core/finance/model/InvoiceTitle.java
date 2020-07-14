package com.xfor.infrastructure.core.finance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 发票抬头
 */
@Data
public class InvoiceTitle {

    @JsonProperty("Name")
    private String name;  //公司名称

    @JsonProperty("TaxpayerID")
    private String taxpayerID;  //纳税人识别号

    @JsonProperty("Address")
    private String address;  //地址

    @JsonProperty("PhoneNumber")
    private String phoneNumber;  //电话

    @JsonProperty("BankName")
    private String bankName;  //开户行名称

    @JsonProperty("BankAccountNumber")
    private String bankAccountNumber;  //开户行账号
}

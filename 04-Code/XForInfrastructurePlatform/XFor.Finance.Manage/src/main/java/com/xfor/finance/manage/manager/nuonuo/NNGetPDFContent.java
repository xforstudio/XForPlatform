package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

@Data
public class NNGetPDFContent {

    private String inTaxAmount;  //1288.80
    private String exTaxAmount;  //687.99
    private String invoiceNo;  //12345678
    private String invoiceCode;  //123456789012

//        String content = "{
//  \"inTaxAmount\": \"1288.80\",
//  \"exTaxAmount\": \"687.99\",
//  \"invoiceNo\": \"12345678\",
//  \"invoiceCode\": \"123456789012\"
//    }";
}

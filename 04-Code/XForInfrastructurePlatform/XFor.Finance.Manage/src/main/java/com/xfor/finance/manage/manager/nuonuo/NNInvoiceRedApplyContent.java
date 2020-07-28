package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class NNInvoiceRedApplyContent {

    @Data
    public class InvoiceRedApplyDetail {
        private String specType;  //袋装
        private String taxExcludedAmount;  //-0.88
        private String favouredPolicyName;  //免税
        private String goodsCodeAbb;  //谷物细粉
        private String num;  //-1
        private String withTaxFlag;  //false
        private String favouredPolicyFlag;  //false
        private String deductions;  //0
        private String taxRate;  //0.13
        private String unit;  //袋
        private String price;  //1.0
        private String zeroRateFlag;  //""
        private String goodsCode;  //1030101010000000000
        private String selfCode;  //""
        private String taxAmount;  //-0.12
        private String taxExcludedPrice;  //0.88
        private String goodsName;  //商品名称qqq
    }

    private String buyerTaxNo;  //914419001234567890
    private String taxExcludedAmount;  //-0.88
    private List<InvoiceRedApplyDetail> invoiceRedApplyDetails = new ArrayList<>();  //
    private String sellerName;  //移动测试盘
    private String oriInvoiceNumber;  //46829224
    private String buyerName;  //诺诺网
    private String sellerTaxNo;  //150301199811285326
    private String applyRemark;  //0000000100
    private String oriInvoiceCode;  //5000201530
    private String productOilFlag;  //0
    private String invoiceLine;  //s
    private String taxAmount;  //-0.12
    private String billNo;  //661545611111111233232323

    //        String content = "{
//  \"buyerTaxNo\": \"914419001234567890\",
//  \"taxExcludedAmount\": \"-0.88\",
//  \"invoiceRedApplyDetails\": [
//        {
//      \"specType\": \"袋装\",
//      \"taxExcludedAmount\": \"-0.88\",
//      \"favouredPolicyName\": \"免税\",
//      \"goodsCodeAbb\": \"谷物细粉\",
//      \"num\": \"-1\",
//      \"withTaxFlag\": \"false\",
//      \"favouredPolicyFlag\": \"false\",
//      \"deductions\": \"0\",
//      \"taxRate\": \"0.13\",
//      \"unit\": \"袋\",
//      \"price\": \"1.0\",
//      \"zeroRateFlag\": \"\",
//      \"goodsCode\": \"1030101010000000000\",
//      \"selfCode\": \"\",
//      \"taxAmount\": \"-0.12\",
//      \"taxExcludedPrice\": \"0.88\",
//      \"goodsName\": \"商品名称qqq\"
//        }
//  ],
//  \"sellerName\": \"移动测试盘\",
//  \"oriInvoiceNumber\": \"46829224\",
//  \"buyerName\": \"诺诺网\",
//  \"sellerTaxNo\": \"150301199811285326\",
//  \"applyRemark\": \"0000000100\",
//  \"oriInvoiceCode\": \"5000201530\",
//  \"productOilFlag\": \"0\",
//  \"invoiceLine\": \"s\",
//  \"taxAmount\": \"-0.12\",
//  \"billNo\": \"661545611111111233232323\"
//    }";
}

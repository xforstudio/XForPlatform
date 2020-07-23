package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

@Data
public class NNDownloadInvoiceRedApplyContent {

    private String buyerTaxNo;  //123456789
    private String billTimeEnd;  //20200526
    private String billInfoNo;  //5001012005015965
    private String invoiceLine;  //s
    private String billTimeBegin;  //20200526

//        String content = "{
//  \"buyerTaxNo\": \"123456789\",
//  \"billTimeEnd\": \"20200526\",
//  \"billInfoNo\": \"5001012005015965\",
//  \"invoiceLine\": \"s\",
//  \"billTimeBegin\": \"20200526\"
//    }";

}

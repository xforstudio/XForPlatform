package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNQueryInvoiceQuantityResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("taxnum")
        private String taxnum;  //339901999999142
        @JsonProperty("invoiceSuccessCount")
        private String invoiceSuccessCount;  //2000
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    E1000	税号为空/开票时间为空/开票时间区间错误/开票时间起始查询时间不支持查询3年前数据	检查参数是否错误
//        E9999	发生未知异常	请联系诺诺发票

//    JSON格式
//    {
//        "code": "0000",
//            "describe": "查询成功",
//            "result": {
//        "taxnum": "339901999999142",
//                "invoiceSuccessCount": 2000
//    }
//    }
package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNInvoiceCancellationResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("invoiceId")
        private String invoiceId;  //发票流水号(提交成功则返回发票请求流水号)	11121212121212
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    invoiceId	String	发票流水号(提交成功则返回发票请求流水号)	11121212121212

//    JSON格式
//    {
//        "code": "E0000",
//            "describe": "请求成功",
//            "result":  {
//        "invoiceId": "19051413444101000011"
//    }
//    }

//    E0000	作废提交成功	作废提交成功
//        EXXXX	其它编码有相应错误信息	其它编码有相应错误信息
package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNGetInvoiceStockResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("extensionNumber")
        private String extensionNumber;  //分机号	1
        @JsonProperty("terminalNumber")
        private String terminalNumber;  //终端号
        @JsonProperty("invoiceLine")
        private String invoiceLine;  //发票种类：p:电子增值税普通发票 c:增值税普通发票(纸票) s:增值税专用发票 e:收购发票(电子) f:收购发票(纸质)r: 增值税普通发票(卷式)	p
        @JsonProperty("remainNum")
        private String remainNum;  //剩余数量	200
        @JsonProperty("typeCode")
        private String typeCode;  //
        @JsonProperty("invoiceNumStart")
        private String invoiceNumStart;  //起zz始发票号码
        @JsonProperty("invoiceNumEnd")
        private String invoiceNumEnd;  //终止发票号码
        @JsonProperty("updateTime")
        private String updateTime;  //2019-08-16 15:39:28
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    code	String	状态码	E0000
//    describe	String	返回信息	调用成功
//    result	Array	具体库存信息
//        extensionNumber	Number	分机号	1
//        terminalNumber	String	终端号
//        invoiceLine	String	发票种类：p:电子增值税普通发票 c:增值税普通发票(纸票) s:增值税专用发票 e:收购发票(电子) f:收购发票(纸质)r: 增值税普通发票(卷式)	p
//        remainNum	Number	剩余数量	200
//        typeCode	String
//        invoiceNumStart	String	起始发票号码
//        invoiceNumEnd	String	终止发票号码
//        updateTime	String	更新时间	2019-08-16 15:39:28
//
//
//        返回码
//        返回描述
//        解决方案
//        E9999	分机号数量超过100，不⽀持查询
//        E0000	调⽤成功
//        E1001	企业资质没有配置，请联系诺诺⽹!
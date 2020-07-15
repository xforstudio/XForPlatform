package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNInvoiceRedApplyResult extends NNResultBase {

    @Data
    public class ResultContent {
    }

    @JsonProperty("result")
    private ResultContent result;
}

//    参数
//            类型
//    描述
//            示例值
//    code	String	结果代码	E0000
//    describe	String	详细信息	同步成功
//    result	Object	业务数据


//    E0000	同步成功
//    E9512	申请单号不能超过 24 位
//    E9520	只支持专票申请
//    E9522	该发票为红字发票，不能冲红
//    E9529	购方税号不能为空

package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNDeliveryInvoiceResult extends NNResultBase {

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
//    describe	String	结果描述	交付成功
//    result	Object


//    返回码
//            返回描述
//解决方案
//        E0000	交付成功
//        E9999	发票不存在不能重新交付
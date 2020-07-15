package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNDownloadInvoiceRedApplyResult extends NNResultBase {

    @Data
    public class ResultContent {
    }

    @JsonProperty("result")
    private ResultContent result;
}

//    E9520	只支持专票申请
//    E9540	信息表编号不能超过 24 位
//    E9545	填开日期不能为空
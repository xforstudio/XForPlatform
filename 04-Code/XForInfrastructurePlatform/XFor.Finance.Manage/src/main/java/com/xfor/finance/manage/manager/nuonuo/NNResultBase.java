package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNResultBase {
    @JsonProperty("code")
    private String code;  //S0000
    @JsonProperty("describe")
    private String describe;  //获取开票信息成功
}

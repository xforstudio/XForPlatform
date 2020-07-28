package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNGetClientStatusResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("sellerTaxNo")
        private String sellerTaxNo;  //销方税号	339901999999142
        @JsonProperty("sellerName")
        private String sellerName;  //销方名称	诺诺网
        @JsonProperty("extensionNumber")
        private String extensionNumber;  //分机版	1
        @JsonProperty("clientVersion")
        private String clientVersion;  //版本号	1.2.1.4
        @JsonProperty("onlineStatus")
        private String onlineStatus;  //在线状态(0:不在线 1:在线)	1
        @JsonProperty("date")
        private String date;  //检测时间	2020-04-04 14:09:02
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    sellerTaxNo	String	销方税号	339901999999142
//        sellerName	String	销方名称	诺诺网
//        extensionNumber	String	分机版	1
//        clientVersion	String	版本号	1.2.1.4
//        onlineStatus	String	在线状态(0:不在线 1:在线)	1
//        date	String	检测时间	2020-04-04 14:09:02
//
//
//        返回码
//        返回描述
//        解决方案
//        E9513	企业资质不存在或已关闭	联系诺诺管理员
//        E9548	企业税号与密钥不匹配	检查参数sellerTaxNo是否正确
//        E9236	分机号设置信息错误	检查参数extensionNumber是否正确
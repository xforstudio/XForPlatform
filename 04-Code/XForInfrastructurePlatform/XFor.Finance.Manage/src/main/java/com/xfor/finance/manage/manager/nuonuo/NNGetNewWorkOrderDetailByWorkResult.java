package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNGetNewWorkOrderDetailByWorkResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("workNo")
        private String workNo;  //WO_20200628135053977196753
        @JsonProperty("priorityLevel")
        private String priorityLevel;  //1
        @JsonProperty("status")
        private String status;  //1
        @JsonProperty("detailList")
        private List<Detail> detailList = new ArrayList<>();
        @JsonProperty("companyTaxNum")
        private String companyTaxNum;  //339901999999142
        @JsonProperty("companyName")
        private String companyName;  //诺诺网电子发票测试专用
        @JsonProperty("customerWorkNo")
        private String customerWorkNo;  //mt00001
        @JsonProperty("content")
        private String content;
    }

    @Data
    public class Detail {
        @JsonProperty("attribute")
        private String attribute;  //customerID
        @JsonProperty("fieldValue")
        private String fieldValue;  //支付宝
    }

    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private NNCreateNewWorkOrderResult.ResultContent data;
}


//    参数
//            类型
//    描述
//            示例值
//    code	Number	响应编码，等于200为成功	200
//        message	String	响应描述	获取工单详情成功
//        data	Object	返回数据体	返回数据体
//        workNo	String	诺诺工单编号	WO_20200628135053977196753
//        priorityLevel	Number	优先级(1:普通 2:紧急 0:低 3:非常紧急.)	1
//        status	Number	工单状态（1:待处理 2:处理中 3:已完结 4:已撤销 5:已关闭	1
//        detailList	Array	工单表单数据数组	工单表单数据
//        attribute	String	工单表单字段key	customerID
//        fieldValue	String	工单表单字段值	支付宝
//        companyTaxNum	String	商户企业税号	339901999999142
//        companyName	String	商户企业名称	诺诺网电子发票测试专用
//        customerWorkNo	String	第三方业务工单号	mt00001
//        content	Object	电票私有参数 json	电票私有参数 json

//{
//        "code":200,
//        "message":"获取工单详情成功",
//        "data":{
//        "workNo":"WO_20200628135053977196753",
//        "priorityLevel":1,
//        "status":1,
//        "detailList":[
//        {
//        "attribute":"customerID",
//        "fieldValue":"支付宝"
//        }
//        ],
//        "companyTaxNum":"339901999999142",
//        "companyName":"诺诺网电子发票测试专用",
//        "customerWorkNo":"mt00001",
//        "content":{
//
//        }
//        }
//        }

//    返回码
//            返回描述
//解决方案
//        code	等于200
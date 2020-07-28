package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNCreateNewWorkOrderResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("module")
        private String module;  //null,
        @JsonProperty("operateAction")
        private String operateAction;  //null
        @JsonProperty("targetName")
        private String targetName;  //null
        @JsonProperty("createTime")
        private String createTime;  //2020-06-28 13:50:53
        @JsonProperty("createUserId")
        private String createUserId;  //null
        @JsonProperty("editTime")
        private String editTime;  //2020-06-28 13:50:53
        @JsonProperty("editUserId")
        private String editUserId;  //null
        @JsonProperty("deleteFlag")
        private String deleteFlag;  //1
        @JsonProperty("id")
        private String id;  //86
        @JsonProperty("auId")
        private String auId;  //9635d94e7a024721bf305ae5c13ea262
        @JsonProperty("workNo")
        private String workNo;  //WO_20200628135053977196753
        @JsonProperty("productLineId")
        private String productLineId;  //1
        @JsonProperty("serviceId")
        private String serviceId;  //F7A54574338948AC6289
        @JsonProperty("templateAuId")
        private String templateAuId;  //dfa9c1d5f5bb460a93b0dc2d0ec6d50d
        @JsonProperty("templateSnapId")
        private String templateSnapId;  //9ebdb66092b04327ba25413aac401908
        @JsonProperty("processId")
        private String processId;  //ac1890245a794c4a887033085c9f3bf0
        @JsonProperty("processNodeId")
        private String processNodeId;  //557e0f83bee544fc880d5e6076a0f7a8
        @JsonProperty("priorityLevel")
        private String priorityLevel;  //1
        @JsonProperty("status")
        private String status;  //1
        @JsonProperty("timestamp")
        private String timestamp;  //a8975661906847379a00a93e3a20c8c1
        @JsonProperty("resource")
        private String resource;  //3
        @JsonProperty("createUserName")
        private String createUserName;  //null
        @JsonProperty("editUserName")
        private String editUserName;  //null
        @JsonProperty("createUserMobile")
        private String createUserMobile;  //null
        @JsonProperty("detailList")
        private List<Detail> detailList = new ArrayList<>();
        @JsonProperty("isCompel")
        private String isCompel;  //null
        @JsonProperty("companyTaxNum")
        private String companyTaxNum;  //339901999999142
        @JsonProperty("companyName")
        private String companyName;  //诺诺网电子发票测试专用
        @JsonProperty("customerUserId")
        private String customerUserId;  //mt00001
        @JsonProperty("customerWorkNo")
        private String customerWorkNo;  //mt00001
        @JsonProperty("outReturnUrl")
        private String outReturnUrl;  //null
        @JsonProperty("content")
        private String content;  //null
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
    private ResultContent data;
}


//    code	Number	响应编码，等于200成功	200
//        message	String	响应描述	工单创建成功
//        data	Object	数据体	数据体
//        workNo	String	诺诺网工单编号	WO_20200628135053977196753
//        customerWorkNo	String	第三方业务工单编号	服务商业务工单编号
//        status	String	工单状态（1:待处理 2:处理中 3:已完结 4:已撤销 5:已关闭	工单状态
//
//        JSON格式
//        {
//        "code": 200,
//        "message": "获取工单详情成功",
//        "data": {
//        "module": null,
//        "operateAction": null,
//        "targetName": null,
//        "createTime": "2020-06-28 13:50:53",
//        "createUserId": null,
//        "editTime": "2020-06-28 13:50:53",
//        "editUserId": null,
//        "deleteFlag": 1,
//        "id": 86,
//        "auId": "9635d94e7a024721bf305ae5c13ea262",
//        "workNo": "WO_20200628135053977196753",
//        "productLineId": 1,
//        "serviceId": "F7A54574338948AC6289",
//        "templateAuId": "dfa9c1d5f5bb460a93b0dc2d0ec6d50d",
//        "templateSnapId": "9ebdb66092b04327ba25413aac401908",
//        "processId": "ac1890245a794c4a887033085c9f3bf0",
//        "processNodeId": "557e0f83bee544fc880d5e6076a0f7a8",
//        "priorityLevel": 1,
//        "status": 1,
//        "timestamp": "a8975661906847379a00a93e3a20c8c1",
//        "resource": 3,
//        "createUserName": null,
//        "editUserName": null,
//        "createUserMobile": null,
//        "detailList": [
//        {
//        "attribute": "customerID",
//        "fieldValue": "支付宝"
//        }
//        ],
//        "isCompel": null,
//        "companyTaxNum": "339901999999142",
//        "companyName": "诺诺网电子发票测试专用",
//        "customerUserId": "mt00001",
//        "customerWorkNo": "mt00001",
//        "outReturnUrl": null,
//        "content": null
//        }
//        }
//
//        返回码
//        返回描述
//        解决方案
//        code	等于200为成功
package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNQuerySpeedBillingResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("adddate")
        private String adddate;  //2017-11-20 15:59:05
        @JsonProperty("alipayuserid")
        private String alipayuserid;  //123456
        @JsonProperty("c_account_blank")
        private String c_account_blank;  //天目山路工商银行西湖支行
        @JsonProperty("c_bank_account")
        private String c_bank_account;  //62288888888888888
        @JsonProperty("c_kpaddr")
        private String c_kpaddr;  //天目山路199号
        @JsonProperty("c_kpcode")
        private String c_kpcode;  //339901999999153
        @JsonProperty("c_kpname")
        private String c_kpname;  //航信培训企业153
        @JsonProperty("c_kptel")
        private String c_kptel;  //0571-88772232
        @JsonProperty("invoicetype")
        private String invoicetype;  //1
        @JsonProperty("platType")
        private String platType;  //4
        @JsonProperty("remarks")
        private String remarks;  //1
        @JsonProperty("sType")
        private String sType;  //2
        @JsonProperty("source")
        private String source;  //0
    }

    @JsonProperty("result")
    private ResultContent result;  //
}


//    参数
//            类型
//    描述
//            示例值
//    c_kpcode	String	购方税号	9100036586522534
//        c_kpname	String	购方名称	浙江省皮肤病医院
//        c_kpaddr	String	购方地址	浙江省德清县武康镇武源街61号
//        c_kptel	String	电话	13100000000
//        source	String	请求来源（1开票软件 2、4诺诺网 3、31第三方平台 5线下扫码）	1
//        c_account_blank	String	开户行	杭州银行古荡支行
//        c_bank_account	String	银行账号	61000251530000154
//        remarks	String	备注	餐饮费
//        adddate	String	请求时间	2017-11-08 5:33:36
//        alipayuserid	String	用户ID（来自平台的用户唯一身份）	1
//        platType	String	平台类型	4
//        invoiceType	String	发票类型（1普票，2专票，3电票，4卷票）	1
//        sType	String	扫码来源（1支付宝，2微信，3诺言，0其他）	2
//        fieldb	String	身份证后四位	0000
//        fieldc	String	房间号	101
//
//        JSON格式
//        {
//        "code": "S0000",
//        "describe": "获取开票信息成功",
//        "result": [{
//        "adddate": "2017-11-20 15:59:05",
//        "alipayuserid": "123456",
//        "c_account_blank": "天目山路工商银行西湖支行",
//        "c_bank_account": "62288888888888888",
//        "c_kpaddr": "天目山路199号",
//        "c_kpcode": "339901999999153",
//        "c_kpname": "航信培训企业153",
//        "c_kptel": "0571-88772232",
//        "invoicetype": "1",
//        "platType": "4",
//        "remarks": "1",
//        "sType": "2",
//        "source": "0"
//        }]
//        }

//    S0101	开票信息不存在	请检查请求分机号
//    S01	数据逻辑异常	请联系诺诺系统管理员
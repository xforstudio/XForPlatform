package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNQueryInvoiceResultResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("serialNo")
        private String serialNo;  //19010211130401000006
        @JsonProperty("orderNo")
        private String orderNo;  //1001000011161
        @JsonProperty("status")
        private String status;  //2
        @JsonProperty("statusMsg")
        private String statusMsg;  //开票完成（最终状态）
        @JsonProperty("failCause")
        private String failCause;  //
        @JsonProperty("pdfUrl")
        private String pdfUrl;  //https://invtest.jss.com.cn/group1/M00/0D/A4/wKjScVwsK6CAFzLgAABsVO-OKaE630.pdf
        @JsonProperty("pictureUrl")
        private String pictureUrl;  //nnfpkf.jss.com.cn/ArQ6dFE3-9o5x4B
        @JsonProperty("invoiceTime")
        private String invoiceTime;  //1546398919000
        @JsonProperty("invoiceCode")
        private String invoiceCode;  //131880930142
        @JsonProperty("invoiceNo")
        private String invoiceNo;  //18757776
        @JsonProperty("exTaxAmount")
        private String exTaxAmount;  //0.38
        @JsonProperty("taxAmount")
        private String taxAmount;  //0.02
        @JsonProperty("payerName")
        private String payerName;  //个人2
        @JsonProperty("payerTaxNo")
        private String payerTaxNo;  //110101TRDX8RQU1
        @JsonProperty("invoiceKind")
        private String invoiceKind;  //电子增值税普通发票
        @JsonProperty("checkCode")
        private String checkCode;  //72969719882523170140
        @JsonProperty("invoiceItems")
        private List<InvoiceItem> invoiceItems = new ArrayList<>();
    }

    @Data
    public class InvoiceItem {
        @JsonProperty("itemName")
        private String itemName;  //门票
        @JsonProperty("itemUnit")
        private String itemUnit;  //张
        @JsonProperty("itemPrice")
        private String itemPrice;  //0.300000000000000000
        @JsonProperty("itemTaxRate")
        private String itemTaxRate;  //0.06
        @JsonProperty("itemNum")
        private String itemNum;  //2.000000000000000000
        @JsonProperty("itemAmount")
        private String itemAmount;  //0.60
        @JsonProperty("itemTaxAmount")
        private String itemTaxAmount;  //0.03
        @JsonProperty("itemSpec")
        private String itemSpec;  //
        @JsonProperty("itemCode")
        private String itemCode;  //3070101000000000000
        @JsonProperty("isIncludeTax")
        private String isIncludeTax;  //true
        @JsonProperty("invoiceLineProperty")
        private String invoiceLineProperty;  //2"
        @JsonProperty("zeroRateFlag")
        private String zeroRateFlag;  //"
        @JsonProperty("favouredPolicyName")
        private String favouredPolicyName;  //"
        @JsonProperty("favouredPolicyFlag")
        private String favouredPolicyFlag;  //0
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    serialNo	String	发票请求流水号	19010211130401000006
//        orderNo	String	交易订单号	1001000011161
//        status	String	发票状态： 2 :开票完成（ 最终状 态），其他状态分别为: 20:开票中; 21:开票成功签章中;22:开票失败;24: 开票成功签章失败;3:发票已作废 31: 发票作废中 备注：22、24状态时，无需再查询，请确认开票失败原因以及签章失败原因；3、31只针对纸票 注：请以该状态码区分发票状态	2
//        statusMsg	String	发票状态描述	开票完成（最终状态）
//        failCause	String	失败原因
//        pdfUrl	String	发票pdf地址	https://invtest.jss.com.cn/group1/M00/0D/A4/wKjScVwsK6CAFzLgAABsVO-OKaE630.pdf
//        pictureUrl	String	发票图片地址	nnfpkf.jss.com.cn/ArQ6dFE3-9o5x4B
//        invoiceTime	Number	开票时间	1546398919000
//        invoiceCode	String	发票代码	131880930199
//        invoiceNo	String	发票号码	19902643
//        exTaxAmount	String	不含税金额	0.38
//        taxAmount	String	合计税额	0.02
//        payerName	String	购方名称（付款方名称）	个人2
//        payerTaxNo	String	购方税号（付款方税号）	110101TRDX8RQU1
//        invoiceKind	String	发票种类	电子增值税普通发票
//        checkCode	String	校验码	72969719882523170140
//        paperPdfUrl	String	纸票pdf地址	http://invtest.nntest.cn/group1/M00/01/8B/wKjScV6-P0aAKKPHAAH965KBApQ812.pdf
//        ofdUrl	String	ofd地址
//        clerk	String	开票员	张三
//        payee	String	收款人	李四
//        checker	String	复核人	王五
//        salerAccount	String	销方银行账号	2000098287777
//        salerTel	String	销方电话	0937-9384
//        salerAddress	String	销方地址	杭州西湖
//        salerTaxNum	String	销方税号	150301199811285326
//        remark	String	备注	备注mlk
//        productOilFlag	String	成品油标志：0非成品油，1成品油	0
//        imgUrls	String	图片地址（多个图片以逗号隔开）	http://invtest.nntest.cn/group1/M00/01/8B/wKjScV6-P0WAHjKkAAC17-oX9RE037.jpg
//        extensionNumber	String	分机号	1
//        invoiceItems	Array	发票明细集合
//        qrCode	String	二维码
//        machineCode	String	税控设备号（机器编码）
//        cipherText	String	发票密文


//    JSON格式
//    {
//        "code": "E0000",
//            "describe": "获取成功",
//            "result": [
//        {
//            "serialNo": "19010211130401000006",
//                "orderNo": "1001000011161",
//                "status": "2",
//                "statusMsg": "开票完成（最终状态）",
//                "failCause": "",
//                "pdfUrl": "https://invtest.jss.com.cn/group1/M00/0D/A4/wKjScVwsK6CAFzLgAABsVO-OKaE630.pdf",
//                "pictureUrl": "nnfpkf.jss.com.cn/ArQ6dFE3-9o5x4B",
//                "invoiceTime": 1546398919000,
//                "invoiceCode": "131880930142",
//                "invoiceNo": "18757776",
//                "exTaxAmount": "0.38",
//                "taxAmount": "0.02",
//                "payerName": "个人2",
//                "payerTaxNo": "110101TRDX8RQU1",
//                "invoiceKind": "电子增值税普通发票",
//                "checkCode": "72969719882523170140",
//                "invoiceItems": [
//            {
//                "itemName": "门票",
//                    "itemUnit": "张",
//                    "itemPrice": "0.300000000000000000",
//                    "itemTaxRate": "0.06",
//                    "itemNum": "2.000000000000000000",
//                    "itemAmount": "0.60",
//                    "itemTaxAmount": "0.03",
//                    "itemSpec": "",
//                    "itemCode": "3070101000000000000",
//                    "isIncludeTax": "true",
//                    "invoiceLineProperty": "2",
//                    "zeroRateFlag": "",
//                    "favouredPolicyName": "",
//                    "favouredPolicyFlag": "0"
//            },
//                ……
//            ]
//        },
//        ……
//    ]
//    }


//    返回码
//            返回描述
//解决方案
//        E9500	发票不存在	检查参数
//        E9601	查询发票信息异常	联系相关人员确认发票是否异常
//        E9611	发票流水号或订单号不能全为空	检查参数
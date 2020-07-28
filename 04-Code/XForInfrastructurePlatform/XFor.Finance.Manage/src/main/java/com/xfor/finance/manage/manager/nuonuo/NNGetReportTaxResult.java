package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNGetReportTaxResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("taxNo")
        private String taxNo;  //税号	339901999999212
        @JsonProperty("extensionNumber")
        private String extensionNumber;  //分机号	22
        @JsonProperty("invoiceLine")
        private String invoiceLine;  //发票种类：p:电⼦增值税普通发票 c:增值税普通发票(纸票) s:增值税专⽤发票 e:收购发票(电⼦) f:收购发票(纸质)r: 增值税普通发票(卷式)	c
        @JsonProperty("lockDate")
        private String lockDate;  //锁死⽇期	2019-12-12
        @JsonProperty("reportTaxStatus")
        private String reportTaxStatus;  //报税状态，-1:未知 0:未抄报 1:已抄报	1
        @JsonProperty("clearCardStatus")
        private String clearCardStatus;  //清卡状态，-1:未知 0:未清卡 1:已清卡	1
        @JsonProperty("offlineAmount")
        private String offlineAmount;  //离线金额	0
        @JsonProperty("offlineTime")
        private String offlineTime;  //离线时限 (⼩时)	0
        @JsonProperty("singleBillingLimit")
        private String singleBillingLimit;  //单张开票限额	0
        @JsonProperty("updateTime")
        private String updateTime;  //更新时间	2019-07-26 10:09:08
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    code	String	状态码	E0000
//    describe	String	返回信息	调⽤成功
//        result	Array	具体信息
//        taxNo	String	税号	339901999999212
//        extensionNumber	String	分机号	22
//        invoiceLine	String	发票种类：p:电⼦增值税普通发票 c:增值税普通发票(纸票) s:增值税专⽤发票 e:收购发票(电⼦) f:收购发票(纸质)r: 增值税普通发票(卷式)	c
//        lockDate	String	锁死⽇期	2019-12-12
//        reportTaxStatus	Number	报税状态，-1:未知 0:未抄报 1:已抄报	1
//        clearCardStatus	Number	清卡状态，-1:未知 0:未清卡 1:已清卡	1
//        offlineAmount	Number	离线金额	0
//        offlineTime	Number	离线时限 (⼩时)	0
//        singleBillingLimit	Number	单张开票限额	0
//        updateTime	String	更新时间	2019-07-26 10:09:08


//    返回码
//            返回描述
//解决方案
//        E9999	分机号数量超过100，不⽀持查询
//        E0000	调⽤成功
//        E1001	企业资质没有配置，请联系诺诺⽹!
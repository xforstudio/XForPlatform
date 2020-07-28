package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNQueryInvoiceListResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("totalCount")
        private String totalCount;  //发票数	2
        @JsonProperty("invoices")
        private List<Invoice> invoices = new ArrayList<>();
    }

    @Data
    public class Invoice {
        @JsonProperty("serialNo")
        private String serialNo;  //发票请求流水号	19030412532501000030
        @JsonProperty("sellerTaxNo")
        private String sellerTaxNo;  //企业税号	339901999999142
        @JsonProperty("orderNo")
        private String orderNo;  //订单编号	20190304125304253604
        @JsonProperty("status")
        private String status;  //发票状态： 2 :开票完成（ 最终状 态），其他状态分别为: 20:开票中; 21:开票成功签章中;22:开票失败;24: 开票成功签章失败;3:发票已作废 31: 发票作废中 备注：22、24状态时，无需再查询，请确认开票失败原因以及签章失败原因；3、31只针对纸票 注：请以该状态码区分发票状态	21
        @JsonProperty("invoiceCode")
        private String invoiceCode;  //发票代码	131880930142
        @JsonProperty("invoiceNo")
        private String invoiceNo;  //发票号码	18783058
        @JsonProperty("exTaxAmount")
        private String exTaxAmount;  //不含税金额	1.00
        @JsonProperty("taxAmount")
        private String taxAmount;  //合计税额	0.02
        @JsonProperty("payerName")
        private String payerName;  //购方名称	浙江诺诺网络科技有限公司
        @JsonProperty("invoiceKind")
        private String invoiceKind;  //发票种类	p
        @JsonProperty("addTime")
        private String addTime;  //创建时间	2019-03-04 00:00:00
        @JsonProperty("invoiceTime")
        private String invoiceTime;  //开票时间	2019-03-04 00:00:00
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    code	String	符合条件的数据数量	E0000
//    describe	String		调用成功
//        result	Object
//        totalCount	Number	发票数	2
//        invoices	Array
//        serialNo	String	发票请求流水号	19030412532501000030
//        sellerTaxNo	String	企业税号	339901999999142
//        orderNo	String	订单编号	20190304125304253604
//        status	String	发票状态： 2 :开票完成（ 最终状 态），其他状态分别为: 20:开票中; 21:开票成功签章中;22:开票失败;24: 开票成功签章失败;3:发票已作废 31: 发票作废中 备注：22、24状态时，无需再查询，请确认开票失败原因以及签章失败原因；3、31只针对纸票 注：请以该状态码区分发票状态	21
//        invoiceCode	String	发票代码	131880930142
//        invoiceNo	String	发票号码	18783058
//        exTaxAmount	Number	不含税金额	1.00
//        taxAmount	Number	合计税额	0.02
//        payerName	String	购方名称	浙江诺诺网络科技有限公司
//        invoiceKind	String	发票种类	p
//        addTime	String	创建时间	2019-03-04 00:00:00
//        invoiceTime	String	开票时间	2019-03-04 00:00:00


//    返回码
//            返回描述
//解决方案
//        0000	查询成功
//        1001	税号不能为空
//        1002	时间不能为空且格式只能是 yyyy-MM-dd HH:mm:ss
//        1003	起始时间不能为空
//        1004	终止时间不能为空
//        1005	起始时间不能大于终止时间且时间间隔不能超过 10 天
//        1006	查询类型只能为 0 和 1
//        1007	符合条件数据量太大（最大支持 1000 条），请缩小时间范围
//        1009	系统繁忙，请稍后再试
package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNInvoiceRedQueryResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("billNo")
        private String billNo;  //24位申请单号:12位金税盘编号+12位开票时间(YYMMDDHHMMSS)	661565671900190410144503
        @JsonProperty("billInfoNo")
        private String billInfoNo;  //信息表编号	1403011905002804
        @JsonProperty("billStatus")
        private String billStatus;  //信息表状态(0:申请中 1:审核成功 2: 审核失败 3:申请成功 4:申请失败)	1
        @JsonProperty("billMessage")
        private String billMessage;  //[信息表状态代码]信息表状态描述	[TZD0000]审核通过
        @JsonProperty("billType")
        private String billType;  //信息表类型(0:正常 1:逾期)	0
        @JsonProperty("oriInvoiceCode")
        private String oriInvoiceCode;  //对应蓝票代码	5000181530
        @JsonProperty("oriInvoiceNumber")
        private String oriInvoiceNumber;  //对应蓝票号码	73347544
        @JsonProperty("taxType")
        private String taxType;  //税种类别(0:营业税 1:增值税)	1
        @JsonProperty("multTaxRate")
        private String multTaxRate;  //多税率标志(0:一票一税率 1:一票多税率)	0
        @JsonProperty("billTime")
        private String billTime;  //填开日期	2020-03-26 18:44:08
        @JsonProperty("sellerTaxNo")
        private String sellerTaxNo;  //销方税号	150301199811285326
        @JsonProperty("sellerName")
        private String sellerName;  //销方名称	测试税号326
        @JsonProperty("buyerTaxNo")
        private String buyerTaxNo;  //购方税号	150301199811285326
        @JsonProperty("buyerName")
        private String buyerName;  //购方名称	测试税号326
        @JsonProperty("taxExcludedAmount")
        private String taxExcludedAmount;  //合计金额(不含税)	-0.94
        @JsonProperty("taxAmount")
        private String taxAmount;  //合计税额	-0.06
        @JsonProperty("applyRemark")
        private String applyRemark;  //申请说明	0000000100
        @JsonProperty("pdfUrl")
        private String pdfUrl;  //申请表pdf地址
        @JsonProperty("codeVersion")
        private String codeVersion;  //商品编码版本号	32
        @JsonProperty("businessTaxCode")
        private String businessTaxCode;  //营业税标志	0000000000
        @JsonProperty("details")
        private List<Detail> details = new ArrayList<>();
    }

    @Data
    public class Detail {
        @JsonProperty("goodsName")
        private String goodsName;  //商品名称	苹果
        @JsonProperty("unit")
        private String unit;  //单位	袋
        @JsonProperty("specType")
        private String specType;  //规格型号	规格型号
        @JsonProperty("num")
        private String num;  //数量	-1
        @JsonProperty("taxExcludedPrice")
        private String taxExcludedPrice;  //单价(不含税)	0.94
        @JsonProperty("taxExcludedAmount")
        private String taxExcludedAmount;  //商品金额(不含税)	-0.94
        @JsonProperty("taxAmount")
        private String taxAmount;  //商品税额	-0.06
        @JsonProperty("taxRate")
        private String taxRate;  //税率	0.06
        @JsonProperty("goodsCode")
        private String goodsCode;  //商品编码	4020000000000000000
        @JsonProperty("selfCode")
        private String selfCode;  //企业自编码
        @JsonProperty("favouredPolicyFlag")
        private String favouredPolicyFlag;  //优惠政策标识 (0:不使用 1:使用)	0
        @JsonProperty("favouredPolicyName")
        private String favouredPolicyName;  //优惠政策内容:即征即退、免税、简易征收等
        @JsonProperty("zeroRateFlag")
        private String zeroRateFlag;  //零税率标识(空:非零税率 1:免税 2:不征税 3:普通零税率)
        @JsonProperty("goodsCodeAbb")
        private String goodsCodeAbb;  //商品编码简称	水果
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    code	String	状态码	E0000
//    describe	String	详细信息	查询成功
//    result	Object	红字信息表申请信息
//        billNo	String	24位申请单号:12位金税盘编号+12位开票时间(YYMMDDHHMMSS)	661565671900190410144503
//        billInfoNo	String	信息表编号	1403011905002804
//        billStatus	Number	信息表状态(0:申请中 1:审核成功 2: 审核失败 3:申请成功 4:申请失败)	1
//        billMessage	String	[信息表状态代码]信息表状态描述	[TZD0000]审核通过
//        BillType	String	信息表类型(0:正常 1:逾期)	0
//        oriInvoiceCode	String	对应蓝票代码	5000181530
//        oriInvoiceNumber	String	对应蓝票号码	73347544
//        taxType	String	税种类别(0:营业税 1:增值税)	1
//        multTaxRate	String	多税率标志(0:一票一税率 1:一票多税率)	0
//        billTime	String	填开日期	2020-03-26 18:44:08
//        sellerTaxNo	String	销方税号	150301199811285326
//        sellerName	String	销方名称	测试税号326
//        buyerTaxNo	String	购方税号	150301199811285326
//        buyerName	String	购方名称	测试税号326
//        taxExcludedAmount	String	合计金额(不含税)	-0.94
//        taxAmount	String	合计税额	-0.06
//        applyRemark	String	申请说明	0000000100
//        pdfUrl	String	申请表pdf地址
//        codeVersion	String	商品编码版本号	32
//        businessTaxCode	String	营业税标志	0000000000
//        details	Array	红字信息表明细信息列表
//        goodsName	String	商品名称	苹果
//        unit	String	单位	袋
//        specType	String	规格型号	规格型号
//        num	String	数量	-1
//        taxExcludedPrice	String	单价(不含税)	0.94
//        taxExcludedAmount	String	商品金额(不含税)	-0.94
//        taxAmount	String	商品税额	-0.06
//        taxRate	String	税率	0.06
//        goodsCode	String	商品编码	4020000000000000000
//        selfCode	String	企业自编码
//        favouredPolicyFlag	String	优惠政策标识 (0:不使用 1:使用)	0
//        favouredPolicyName	String	优惠政策内容:即征即退、免税、简易征收等
//        zeroRateFlag	String	零税率标识(空:非零税率 1:免税 2:不征税 3:普通零税率)
//        goodsCodeAbb	String	商品编码简称	水果


//    返回码
//            返回描述
//解决方案
//        9300	数据格式不正确	根据接口文档修改参数
//        9301	企业信息备案错误,请联系诺诺网	添加企业资质
//        9302	身份认证与当前企业税号不相符	修改税号或者身份id
//        9531	申请信息不存在	没有申请信息

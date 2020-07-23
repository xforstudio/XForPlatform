package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xfor.infrastructure.core.common.util.JsonUtil;
import lombok.Data;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 诺诺发票管理器
 */
@Component
@Data
public class NNInvoiceManager {

//    获取企业下待开票列表接口：nuonuo.speedBilling.querySpeedBilling
//    企业开票量查询接口：nuonuo.electronInvoice.queryInvoiceQuantity
//    发票作废接口：nuonuo.electronInvoice.invoiceCancellation
//    获取电子发票PDF地址接口：nuonuo.ElectronInvoice.getPDF
//    开票结果查询接口：nuonuo.ElectronInvoice.queryInvoiceResult
//    红字专用发票信息表申请接口：nuonuo.ElectronInvoice.InvoiceRedApply
//    红字专用发票信息表查询接口：nuonuo.ElectronInvoice.InvoiceRedQuery
//    发票列表查询接口：nuonuo.ElectronInvoice.queryInvoiceList
//    企业发票余量查询接口：nuonuo.ElectronInvoice.getInvoiceStock
//    企业报税信息查询接口：nuonuo.ElectronInvoice.getReportTax
//    客户端在线状态检测接口：nuonuo.ElectronInvoice.GetClientStatus
//    红字专用发票信息表下载接口：nuonuo.ElectronInvoice.downloadInvoiceRedApply
//    发票重新交付接口：nuonuo.ElectronInvoice.deliveryInvoice
//    创建工单接口：nuonuo.ElectronInvoice.createNewWorkOrder
//    查询工单状态以及信息接口：nuonuo.ElectronInvoice.getNewWorkOrderDetailByWork

    //唯一标识，由企业自己生成32位随机码
    private static String _createSenid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private String sdkUrl = "https://sdk.jss.com.cn/open/v1/services";  //SDK请求地址
    private String taxnum = "";  //授权企业税号
    private String appKey = "";  //
    private String appSecret = "";  //
    private String token = "";  //访问令牌
    private String extensionNum = "0";  //分机号（没有分机可填0或不填）

    //自用型应用获取令牌（具体参数说明可参见独立企业接入）
    public String getMerchantToken() {
        String json = NNOpenSDK.getIntance().getMerchantToken(this.getAppKey(), this.getAppSecret(), this.getSdkUrl());
        return json;
    }

    //第三方应用获取令牌（具体参数说明可参见系统服务商接入）
    public String getISVToken() {
        String json = NNOpenSDK.getIntance().getISVToken("appKey","appSecret","code","taxnum","redirectUri");
        return json;
    }

    //第三方应用刷新令牌（具体参数说明可参见系统服务商接入）
    public String refreshISVToken() {
        String json = NNOpenSDK.getIntance().refreshISVToken("refreshToken","userId","appSecret");
        return json;
    }

    /* 极速开票 */

    //获取企业下待开票列表接口：nuonuo.speedBilling.querySpeedBilling
    public String querySpeedBilling(NNQuerySpeedBillingContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.speedBilling.querySpeedBilling";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    /* 发票开具 */

    //红字专用发票信息表申请接口：nuonuo.ElectronInvoice.InvoiceRedApply
    public String invoiceRedApply(NNInvoiceRedApplyContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.InvoiceRedApply";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
            this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //红字专用发票信息表下载接口：nuonuo.ElectronInvoice.downloadInvoiceRedApply
    public String downloadInvoiceRedApply(NNDownloadInvoiceRedApplyContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.downloadInvoiceRedApply";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    /* 发票查询 */

    //企业开票量查询接口：nuonuo.electronInvoice.queryInvoiceQuantity
    public String queryInvoiceQuantity(NNQueryInvoiceQuantityContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.queryInvoiceQuantity";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //获取电子发票PDF地址接口：nuonuo.ElectronInvoice.getPDF
    public String getPDF(NNGetPDFContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getPDF";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //开票结果查询接口：nuonuo.ElectronInvoice.queryInvoiceResult
    public String queryInvoiceResult(NNQueryInvoiceResultContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.queryInvoiceResult";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //红字专用发票信息表查询接口：nuonuo.ElectronInvoice.InvoiceRedQuery
    public String invoiceRedQuery(NNInvoiceRedQueryContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.InvoiceRedQuery";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //发票列表查询接口：nuonuo.ElectronInvoice.queryInvoiceList
    public String queryInvoiceList(NNQueryInvoiceListContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.queryInvoiceList";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //发票重新交付接口：nuonuo.ElectronInvoice.deliveryInvoice
    public String deliveryInvoice(NNDeliveryInvoiceContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.deliveryInvoice";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    /* 发票作废 */

    //发票作废接口：nuonuo.electronInvoice.invoiceCancellation
    public String invoiceCancellation(NNInvoiceCancellationContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.invoiceCancellation";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    /* 工单管理 */

    //创建工单接口：nuonuo.ElectronInvoice.createNewWorkOrder
    public String createNewWorkOrder(NNCreateNewWorkOrderContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.createNewWorkOrder";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //查询工单状态以及信息接口：nuonuo.ElectronInvoice.getNewWorkOrderDetailByWork
    public String getNewWorkOrderDetailByWork(NNGetNewWorkOrderDetailByWorkContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getNewWorkOrderDetailByWork";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    /* 企业信息查询 */

    //企业发票余量查询接口：nuonuo.ElectronInvoice.getInvoiceStock
    public String getInvoiceStock(NNGetInvoiceStockContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getInvoiceStock";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //企业报税信息查询接口：nuonuo.ElectronInvoice.getReportTax
    public String getReportTax(NNGetReportTaxContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getReportTax";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }

    //客户端在线状态检测接口：nuonuo.ElectronInvoice.GetClientStatus
    public String GetClientStatus(NNGetClientStatusContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.GetClientStatus";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        return result_json;
    }
}

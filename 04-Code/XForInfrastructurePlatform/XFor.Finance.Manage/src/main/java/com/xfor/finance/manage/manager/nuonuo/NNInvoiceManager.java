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
    public NNQuerySpeedBillingResult querySpeedBilling(NNQuerySpeedBillingContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.speedBilling.querySpeedBilling";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNQuerySpeedBillingResult result = JsonUtil._stringToObject(result_json, NNQuerySpeedBillingResult.class);
        return result;
    }

    /* 发票开具 */

    //红字专用发票信息表申请接口：nuonuo.ElectronInvoice.InvoiceRedApply
    public NNInvoiceRedApplyResult invoiceRedApply(NNInvoiceRedApplyContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.InvoiceRedApply";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
            this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNInvoiceRedApplyResult result = JsonUtil._stringToObject(result_json, NNInvoiceRedApplyResult.class);
        return result;
    }

    //红字专用发票信息表下载接口：nuonuo.ElectronInvoice.downloadInvoiceRedApply
    public NNDownloadInvoiceRedApplyResult downloadInvoiceRedApply(NNDownloadInvoiceRedApplyContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.downloadInvoiceRedApply";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNDownloadInvoiceRedApplyResult result = JsonUtil._stringToObject(result_json, NNDownloadInvoiceRedApplyResult.class);
        return result;
    }

    /* 发票查询 */

    //企业开票量查询接口：nuonuo.electronInvoice.queryInvoiceQuantity
    public NNQueryInvoiceQuantityResult queryInvoiceQuantity(NNQueryInvoiceQuantityContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.queryInvoiceQuantity";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNQueryInvoiceQuantityResult result = JsonUtil._stringToObject(result_json, NNQueryInvoiceQuantityResult.class);
        return result;
    }

    //获取电子发票PDF地址接口：nuonuo.ElectronInvoice.getPDF
    public NNGetPDFResult getPDF(NNGetPDFContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getPDF";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNGetPDFResult result = JsonUtil._stringToObject(result_json, NNGetPDFResult.class);
        return result;
    }

    //开票结果查询接口：nuonuo.ElectronInvoice.queryInvoiceResult
    public NNQueryInvoiceResultResult queryInvoiceResult(NNQueryInvoiceResultContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.queryInvoiceResult";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNQueryInvoiceResultResult result = JsonUtil._stringToObject(result_json, NNQueryInvoiceResultResult.class);
        return result;
    }

    //红字专用发票信息表查询接口：nuonuo.ElectronInvoice.InvoiceRedQuery
    public NNInvoiceRedQueryResult invoiceRedQuery(NNInvoiceRedQueryContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.InvoiceRedQuery";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNInvoiceRedQueryResult result = JsonUtil._stringToObject(result_json, NNInvoiceRedQueryResult.class);
        return result;
    }

    //发票列表查询接口：nuonuo.ElectronInvoice.queryInvoiceList
    public NNQueryInvoiceListResult queryInvoiceList(NNQueryInvoiceListContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.queryInvoiceList";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNQueryInvoiceListResult result = JsonUtil._stringToObject(result_json, NNQueryInvoiceListResult.class);
        return result;
    }

    //发票重新交付接口：nuonuo.ElectronInvoice.deliveryInvoice
    public NNDeliveryInvoiceResult deliveryInvoice(NNDeliveryInvoiceContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.deliveryInvoice";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNDeliveryInvoiceResult result = JsonUtil._stringToObject(result_json, NNDeliveryInvoiceResult.class);
        return result;
    }

    /* 发票作废 */

    //发票作废接口：nuonuo.electronInvoice.invoiceCancellation
    public NNInvoiceCancellationResult invoiceCancellation(NNInvoiceCancellationContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.invoiceCancellation";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNInvoiceCancellationResult result = JsonUtil._stringToObject(result_json, NNInvoiceCancellationResult.class);
        return result;
    }

    /* 工单管理 */

    //创建工单接口：nuonuo.ElectronInvoice.createNewWorkOrder
    public NNCreateNewWorkOrderResult createNewWorkOrder(NNCreateNewWorkOrderContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.createNewWorkOrder";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNCreateNewWorkOrderResult result = JsonUtil._stringToObject(result_json, NNCreateNewWorkOrderResult.class);
        return result;
    }

    //查询工单状态以及信息接口：nuonuo.ElectronInvoice.getNewWorkOrderDetailByWork
    public NNGetNewWorkOrderDetailByWorkResult getNewWorkOrderDetailByWork(NNGetNewWorkOrderDetailByWorkContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getNewWorkOrderDetailByWork";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNGetNewWorkOrderDetailByWorkResult result = JsonUtil._stringToObject(result_json, NNGetNewWorkOrderDetailByWorkResult.class);
        return result;
    }

    /* 企业信息查询 */

    //企业发票余量查询接口：nuonuo.ElectronInvoice.getInvoiceStock
    public NNGetInvoiceStockResult getInvoiceStock(NNGetInvoiceStockContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getInvoiceStock";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNGetInvoiceStockResult result = JsonUtil._stringToObject(result_json, NNGetInvoiceStockResult.class);
        return result;
    }

    //企业报税信息查询接口：nuonuo.ElectronInvoice.getReportTax
    public NNGetReportTaxResult getReportTax(NNGetReportTaxContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.electronInvoice.getReportTax";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNGetReportTaxResult result = JsonUtil._stringToObject(result_json, NNGetReportTaxResult.class);
        return result;
    }

    //客户端在线状态检测接口：nuonuo.ElectronInvoice.GetClientStatus
    public NNGetClientStatusResult GetClientStatus(NNGetClientStatusContent content) throws JsonProcessingException {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.GetClientStatus";
        String content_json = JsonUtil._objectToString(content);
        String result_json = sdk.sendPostSyncRequest(this.getSdkUrl(), _createSenid(), this.getAppKey(),
                this.getAppSecret(), this.getToken(), this.getTaxnum(), method, content_json);
        NNGetClientStatusResult result = JsonUtil._stringToObject(result_json, NNGetClientStatusResult.class);
        return result;
    }
}

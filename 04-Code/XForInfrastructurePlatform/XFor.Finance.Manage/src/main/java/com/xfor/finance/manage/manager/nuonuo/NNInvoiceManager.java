package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public void querySpeedBilling() {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.speedBilling.querySpeedBilling"; // API方法名
        Map<String, String> contentParams = new HashMap<>();
        contentParams.put("extensionNum", this.getExtensionNum());
//        String content ="{" +
//                "\"extensionNum\":\"0\"" +
//                "}";
        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    /* 发票开具 */

    //红字专用发票信息表申请接口：nuonuo.ElectronInvoice.InvoiceRedApply
    public void invoiceRedApply() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.InvoiceRedApply"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"buyerTaxNo\": \"914419001234567890\",
//  \"taxExcludedAmount\": \"-0.88\",
//  \"invoiceRedApplyDetails\": [
//        {
//      \"specType\": \"袋装\",
//      \"taxExcludedAmount\": \"-0.88\",
//      \"favouredPolicyName\": \"免税\",
//      \"goodsCodeAbb\": \"谷物细粉\",
//      \"num\": \"-1\",
//      \"withTaxFlag\": \"false\",
//      \"favouredPolicyFlag\": \"false\",
//      \"deductions\": \"0\",
//      \"taxRate\": \"0.13\",
//      \"unit\": \"袋\",
//      \"price\": \"1.0\",
//      \"zeroRateFlag\": \"\",
//      \"goodsCode\": \"1030101010000000000\",
//      \"selfCode\": \"\",
//      \"taxAmount\": \"-0.12\",
//      \"taxExcludedPrice\": \"0.88\",
//      \"goodsName\": \"商品名称qqq\"
//        }
//  ],
//  \"sellerName\": \"移动测试盘\",
//  \"oriInvoiceNumber\": \"46829224\",
//  \"buyerName\": \"诺诺网\",
//  \"sellerTaxNo\": \"150301199811285326\",
//  \"applyRemark\": \"0000000100\",
//  \"oriInvoiceCode\": \"5000201530\",
//  \"productOilFlag\": \"0\",
//  \"invoiceLine\": \"s\",
//  \"taxAmount\": \"-0.12\",
//  \"billNo\": \"661545611111111233232323\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //红字专用发票信息表下载接口：nuonuo.ElectronInvoice.downloadInvoiceRedApply
    public void downloadInvoiceRedApply() {

//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.downloadInvoiceRedApply"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"buyerTaxNo\": \"123456789\",
//  \"billTimeEnd\": \"20200526\",
//  \"billInfoNo\": \"5001012005015965\",
//  \"invoiceLine\": \"s\",
//  \"billTimeBegin\": \"20200526\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    /* 发票查询 */

    //企业开票量查询接口：nuonuo.electronInvoice.queryInvoiceQuantity
    public void queryInvoiceQuantity() {

//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.electronInvoice.queryInvoiceQuantity"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content ="{" +
//                "\"taxnum\":\"339901999999142\"," +
//                "\"invoiceTimeStart\":\"2018-03-19 00:00:00\"," +
//                "\"invoiceTimeEnd\":\"2019-03-19 18:00:00\"" +
//                "}";
//        String url = https://sdk.jss.com.cn/open/v1/services; // SDK请求地址
//        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //获取电子发票PDF地址接口：nuonuo.ElectronInvoice.getPDF
    public void getPDF() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.getPDF"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"inTaxAmount\": \"1288.80\",
//  \"exTaxAmount\": \"687.99\",
//  \"invoiceNo\": \"12345678\",
//  \"invoiceCode\": \"123456789012\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //开票结果查询接口：nuonuo.ElectronInvoice.queryInvoiceResult
    public void queryInvoiceResult() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.queryInvoiceResult"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"isOfferInvoiceDetail\": \"1\",
//  \"orderNos\": [],
//  \"serialNos\": [
//    \"13188093020920901044\"
//  ]
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);
//
        return;
    }

    //红字专用发票信息表查询接口：nuonuo.ElectronInvoice.InvoiceRedQuery
    public void invoiceRedQuery() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.InvoiceRedQuery"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"sellerTaxNo\": \"150301199811285326\",
//  \"buyerTaxNo\": \"123456789\",
//  \"billTimeEnd\": \"20200526\",
//  \"billInfoNo\": \"5001012005015976\",
//  \"billTimeBegin\": \"20200526\",
//  \"billNo\": \"661565671900200526160735\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //发票列表查询接口：nuonuo.ElectronInvoice.queryInvoiceList
    public void queryInvoiceList() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.queryInvoiceList"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"requestType\": \"1\",
//  \"pageNo\": \"2\",
//  \"pageSize\": \"20\",
//  \"taxnum\": \"339901999999212\",
//  \"startTime\": \"2019-03-04 00:00:00\",
//  \"endTime\": \"2019-03-09 00:00:00\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //发票重新交付接口：nuonuo.ElectronInvoice.deliveryInvoice
    public void deliveryInvoice() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.deliveryInvoice"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"mail\": \"\",
//  \"phone\": \"133333333333\",
//  \"taxnum\": \"339901999999199\",
//  \"invoiceCode\": \"131880930199\",
//  \"invoiceNum\": \"19902647\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    /* 发票作废 */

    //发票作废接口：nuonuo.electronInvoice.invoiceCancellation
    public void invoiceCancellation() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.electronInvoice.invoiceCancellation"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"invoiceId\": \"20052622361801000032\",
//  \"invoiceNo\": \"23501899\",
//  \"invoiceCode\": \"5000201530\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    /* 工单管理 */

    //创建工单接口：nuonuo.ElectronInvoice.createNewWorkOrder
    public void createNewWorkOrder() {

//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.createNewWorkOrder"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"requestTime\": \"20200716135627\",
//  \"data\": {
//    \"templateNo\": \"81f25c1ee9474a9eb8c81897a9b1669e\",
//    \"companyTaxNum\": \"91330106MA2AYNWD8M\",
//    \"businessCode\": \"dzfp\",
//    \"priorityLevel\": \"3\",
//    \"customerWorkNo\": \"mt00003\",
//    \"companyName\": \"浙江诺诺网络科技有限公司\",
//    \"detailList\": [
//        {
//        \"attribute\": \"customerID\",
//        \"fieldValue\": \"美团\"
//        }
//    ],
//    \"stateNotifyUrl\": \"\",
//    \"source\": \"3\"
//    },
//            \"requestId\": \"12f0d1c856f64b57a31fcfe5b8acae31\",
//            \"appId\": \"NN_MEITUAN\",
//            \"version\": \"1.0\"
//}";
//        String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //查询工单状态以及信息接口：nuonuo.ElectronInvoice.getNewWorkOrderDetailByWork
    public void getNewWorkOrderDetailByWork() {

//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.getNewWorkOrderDetailByWork"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"requestTime\": \"20200508194230\",
//  \"data\": {
//    \"workNo\": \"WO_20200628135053977196753\",
//    \"customerWorkNo\": \"\"
//    },
//            \"requestId\": \"eb079b69bf7411eab9f86c92bf2c448c\",
//            \"appId\": \"NN_MEITUAN\",
//            \"version\": \"1.0\"
//}";
//        String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    /* 企业信息查询 */

    //企业发票余量查询接口：nuonuo.ElectronInvoice.getInvoiceStock
    public void getInvoiceStock() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.getInvoiceStock"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"extensionNums\": [],
//  \"departmentId\": \"\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }

    //企业报税信息查询接口：nuonuo.ElectronInvoice.getReportTax
    public void getReportTax() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.getReportTax"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"extensionNums\": [],
//  \"departmentId\": \"132123\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);
//
//        return;
    }

    //客户端在线状态检测接口：nuonuo.ElectronInvoice.GetClientStatus
    public void GetClientStatus() {
//        NNOpenSDK sdk = NNOpenSDK.getIntance();
//        String taxnum = "23***789"; // 授权企业税号
//        String appKey = "Hn***XL";
//        String appSecret = "F65***65F";
//        String method = "nuonuo.ElectronInvoice.GetClientStatus"; // API方法名
//        String token = "2d484e**************pdui"; // 访问令牌
//        String content = "{
//  \"sellerTaxNo\": \"339901999999212\",
//  \"extensionNumber\": \"0\"
//    }";
//    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
//    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
//    String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        return;
    }
}

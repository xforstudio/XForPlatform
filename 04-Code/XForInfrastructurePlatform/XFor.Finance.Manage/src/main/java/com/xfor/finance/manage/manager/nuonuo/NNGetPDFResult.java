package com.xfor.finance.manage.manager.nuonuo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NNGetPDFResult extends NNResultBase {

    @Data
    public class ResultContent {
        @JsonProperty("serialNo")
        private String serialNo;  //发票流水号	19050620530501000001
        @JsonProperty("data")
        private String data;  //PDF地址	https://invtest.jss.com.cn/group1/M00/0F/8E/wKjScVz-PXiAMvFRAACJrnY49Vk254.pdf
    }

    @JsonProperty("result")
    private ResultContent result;
}


//    参数
//            类型
//    描述
//            示例值
//    serialNo	String	发票流水号	19050620530501000001
//        data	String	PDF地址	https://invtest.jss.com.cn/group1/M00/0F/8E/wKjScVz-PXiAMvFRAACJrnY49Vk254.pdf

//    JSON格式
//    {
//        "code": "E0000",
//            "describe": "获取成功",
//            "result": {
//        "serialNo": "19050620530501000001",
//                "data":"https://invtest.jss.com.cn/group1/M00/0F/8E/wKjScVz-PXiAMvFRAACJrnY49Vk254.pdf"
//    }
//    }
//
//    返回码
//            返回描述
//解决方案
//        E0001	pdf地址为空	联系运维人员确认发票是否异常
//        E0002	含税金额和不含税金额不能同时为空
//        E9367	发票代码不能为空
//        E9368	发票代码不能超过12位
//        E9369	发票号码不能为空
//        E9370	发票号码不能超过8位
//        E9500	发票不存在	确认请求参数是否正确
//        E9999	系统出错	请稍后重试
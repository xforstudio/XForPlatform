package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

@Data
public class NNQuerySpeedBillingResult extends NNResultBase {

    @Data
    public class ResultContent {
        private String adddate;  //2017-11-20 15:59:05
        private String alipayuserid;  //123456
        private String c_account_blank;  //天目山路工商银行西湖支行
        private String c_bank_account;  //62288888888888888
        private String c_kpaddr;  //天目山路199号
        private String c_kpcode;  //339901999999153
        private String c_kpname;  //航信培训企业153
        private String c_kptel;  //0571-88772232
        private String invoicetype;  //1
        private String platType;  //4
        private String remarks;  //1
        private String sType;  //2
        private String source;  //0
    }

    private ResultContent result;  //

//    S0101	开票信息不存在	请检查请求分机号
//    S01	数据逻辑异常	请联系诺诺系统管理员
}

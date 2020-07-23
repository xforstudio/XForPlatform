package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

@Data
public class NNGetNewWorkOrderDetailByWorkContent {

    @lombok.Data
    public class Data {
        private String workNo;  //WO_20200628135053977196753
        private String customerWorkNo;  //
    }

    private String requestTime;  //20200508194230
    private Data data = new Data();
    private String requestId;  //eb079b69bf7411eab9f86c92bf2c448c
    private String appId;  //NN_MEITUAN
    private String version;  //1.0

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
}

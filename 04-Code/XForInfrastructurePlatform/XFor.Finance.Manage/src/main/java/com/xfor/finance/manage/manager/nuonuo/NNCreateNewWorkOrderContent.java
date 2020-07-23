package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNCreateNewWorkOrderContent {

    @lombok.Data
    public class Data {
        private String templateNo;  //81f25c1ee9474a9eb8c81897a9b1669e,
        private String companyTaxNum;  //91330106MA2AYNWD8M
        private String businessCode;  //dzfp
        private String priorityLevel;  //3
        private String customerWorkNo;  //mt00003
        private String companyName;  //浙江诺诺网络科技有限公司
        private List<Detail> detailList = new ArrayList<>();
        private String stateNotifyUrl;  //""
        private String source;  //3
    }

    @lombok.Data
    public class Detail {
        private String attribute;  //customerID
        private String fieldValue;  //美团
    }

    private String requestTime;  //20200716135627
    private Data data = new Data();
    private String requestId;  //12f0d1c856f64b57a31fcfe5b8acae31
    private String appId;  //NN_MEITUAN
    private String version;  //1.0

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
}

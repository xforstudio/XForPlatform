package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNGetReportTaxContent {

    private List<String> extensionNums = new ArrayList<>();
    private String departmentId;  //"132123"

    //        String content = "{
//  \"extensionNums\": [],
//  \"departmentId\": \"132123\"
//    }";
}

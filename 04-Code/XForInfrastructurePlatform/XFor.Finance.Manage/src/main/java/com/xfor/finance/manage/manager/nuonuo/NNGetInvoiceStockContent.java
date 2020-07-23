package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNGetInvoiceStockContent {

    private List<String> extensionNums = new ArrayList<>();
    private String departmentId;  //""

    //        String content = "{
//  \"extensionNums\": [],
//  \"departmentId\": \"\"
//    }";
}

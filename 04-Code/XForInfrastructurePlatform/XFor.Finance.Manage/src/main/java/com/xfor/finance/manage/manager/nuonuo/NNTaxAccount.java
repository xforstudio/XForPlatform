package com.xfor.finance.manage.manager.nuonuo;

import lombok.Data;

/**
 * 诺诺税务账号
 */
@Data
public class NNTaxAccount {

    private String taxnum;  // 授权企业税号
    private String appKey;  //
    private String appSecret;  //
    private String token; // 访问令牌
}

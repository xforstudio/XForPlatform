package com.xfor.infrastructure.core.common.model;

/**
 * 证件类型
 */
public class IDType {

    private IDTypeNOEnum no;  //数字编号
    private String name_ZH_CN;  //中文名称
    private String name_EN;  //英文名称

    public IDTypeNOEnum getNO() {
        return no;
    }

    public void setNO(IDTypeNOEnum no) {
        this.no = no;
    }

    public String getName_ZH_CN() {
        return name_ZH_CN;
    }

    public void setName_ZH_CN(String name_ZH_CN) {
        this.name_ZH_CN = name_ZH_CN;
    }

    public String getName_EN() {
        return name_EN;
    }

    public void setName_EN(String name_EN) {
        this.name_EN = name_EN;
    }
}

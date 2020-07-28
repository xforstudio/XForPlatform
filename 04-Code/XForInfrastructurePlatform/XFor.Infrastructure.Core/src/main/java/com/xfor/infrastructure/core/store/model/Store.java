package com.xfor.infrastructure.core.store.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import lombok.Data;

import java.util.Date;

/**
 * 商店
 */
@Data
@TableName("STORE")
public class Store extends BaseEntity {

    public static Store _create(String code, String name, String memo, IDateTimeProvider dateTimeProvider) {
        Store store = new Store();
        store.setSid(_newSID());
        store.setCode(code);
        store.setName(name);
        store.setMemo(memo);
        store.setCreateTime(dateTimeProvider.getNow());
        store.setState(StoreStateEnum.None);
        return store;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;  //商店唯一标识

    @JsonProperty("Code")
    @TableField("CODE")
    private String code;  //商店代码

    @JsonProperty("Name")
    @TableField("NAME")
    private String name;  //商店代码

    @JsonProperty("Memo")
    @TableField("MEMO")
    private String memo;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_TIME")
    private Date createTime;

    @JsonProperty("State")
    @TableField("STATE")
    private int state = StoreStateEnum.None;  //商店状态

    public Store() {
        super();
    }

    public void validate() {
    }

    public void regist() {
        this.setState(StoreStateEnum.Registered);
    }

    public void open() {
        this.setState(StoreStateEnum.Opened);
    }

    public void close() {
        this.setState(StoreStateEnum.Closed);
    }

    public void cancel() {
        this.setState(StoreStateEnum.Cancelled);
    }
}

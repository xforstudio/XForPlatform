package com.xfor.infrastructure.core.store.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商店
 */
@Data
@TableName("STORE")
public class Store {

    @TableId("SID")
    private String sid;  //商店唯一标识
    @TableField("CODE")
    private String code;  //商店代码
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("STATE")
    private int state = StoreStateEnum.None;  //商店状态

}

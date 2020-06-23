package com.xfor.infrastructure.core.email.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.model.SID;
import lombok.Data;

import java.util.Date;

@Data
@TableName("EMAIL_ACTION")
public class EmailAction extends BaseEntity {

    public static EmailAction _create(EmailMessage emailMessage, IDateTimeProvider dateTimeProvider) {
        EmailAction emailAction = new EmailAction();
        emailAction.setSid(_newSID());
        emailAction.setEmailMessageSid(emailMessage.getSid());
        emailAction.setSendState(EmailSendStateEnum.NotSend);
        emailAction.setCreateTime(dateTimeProvider.getNow());
        emailAction.setModifyTime(dateTimeProvider.getNow());
        return emailAction;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("EmailMessageSid")
    @TableId("EMAIL_MESSAGE_SID")
    private String emailMessageSid;

    @JsonProperty("SendState")
    @TableId("SEND_STATE")
    private int sendState;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("CREATE_TIME")
    private Date createTime;

    @JsonProperty("ModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("MODIFY_TIME")
    private Date modifyTime;
}

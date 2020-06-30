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
        emailAction.setSendState(EmailSendStateEnum.SendNot);
        emailAction.setCreateTime(dateTimeProvider.getNow());
        emailAction.setModifyTime(dateTimeProvider.getNow());
        return emailAction;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("EmailMessageSid")
    @TableField("EMAIL_MESSAGE_SID")
    private String emailMessageSid;

    @JsonProperty("SendState")
    @TableField("SEND_STATE")
    private int sendState;

    @JsonProperty("SendRetryCount")
    @TableField("SEND_RETRY_COUNT")
    private int sendRetryCount = 0;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("CREATE_TIME")
    private Date createTime;

    @JsonProperty("ModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    public int increaseSendRetryCount() {
        return ++this.sendRetryCount;
    }

    public void sendError(IDateTimeProvider dateTimeProvider) {
        this.setSendState(EmailSendStateEnum.SendError);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public void sendSuccessed(IDateTimeProvider dateTimeProvider) {
        this.setSendState(EmailSendStateEnum.SendSuccessed);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public void sendFault(IDateTimeProvider dateTimeProvider) {
        this.setSendState(EmailSendStateEnum.SendFault);
        this.setModifyTime(dateTimeProvider.getNow());
    }

    public boolean isSendRetryEnabled(int mailSendRetryCountMax) {
        if (this.sendRetryCount > mailSendRetryCountMax) {
            this.sendRetryCount = mailSendRetryCountMax;
        }
        return this.sendRetryCount < mailSendRetryCountMax;
    }

    public boolean hasSendFinished() {
        return this.sendState == EmailSendStateEnum.SendFault
                || this.sendState == EmailSendStateEnum.SendSuccessed;
    }
}

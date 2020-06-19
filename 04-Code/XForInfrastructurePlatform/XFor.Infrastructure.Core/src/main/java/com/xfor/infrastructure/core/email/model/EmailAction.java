package com.xfor.infrastructure.core.email.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.SID;
import lombok.Data;

@Data
@TableName("EMAIL_ACTION")
public class EmailAction {

    public static String _newSID() {
        return SID._newSID();
    }

    public static EmailAction _create(EmailMessage emailMessage) {
        return null;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("EmailMessageSid")
    @TableId("EMAIL_MESSAGE_SID")
    private String emailMessageSid;

    private EmailMessage emailMessageObj;

    public EmailAction() {
    }
}

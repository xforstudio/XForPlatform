package com.xfor.infrastructure.core.email.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.SID;
import lombok.Data;

@Data
@TableName("EMAIL_MESSAGE")
public class EmailMessage extends BaseEntity {

    public static EmailMessage _create(String from, String to, String content, String templateId, String templateData) {
        return null;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("From")
    @TableId("FROM")
    private String from;

    @JsonProperty("To")
    @TableId("TO")
    private String to;

    @JsonProperty("Content")
    @TableId("CONTENT")
    private String content;

    @JsonProperty("TemplateId")
    @TableId("TEMPLATE_ID")
    private String templateId;

    @JsonProperty("TemplateData")
    @TableId("TEMPLATE_DATA")
    private String templateData;

}

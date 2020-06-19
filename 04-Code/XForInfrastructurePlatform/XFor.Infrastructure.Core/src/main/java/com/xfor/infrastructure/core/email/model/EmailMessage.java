package com.xfor.infrastructure.core.email.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.SID;
import lombok.Data;

@Data
public class EmailMessage {

    public static String _newSID() {
        return SID._newSID();
    }

    public static EmailMessage _create(String from, String to, String content, String templateId, String templateData) {
        return null;
    }

    @JsonProperty("Sid")
    private String sid;

    @JsonProperty("From")
    private String from;

    @JsonProperty("To")
    private String to;

    @JsonProperty("Content")
    private String content;

    @JsonProperty("TemplateId")
    private String templateId;

    @JsonProperty("TemplateData")
    private String templateData;

    public EmailMessage() {
    }
}

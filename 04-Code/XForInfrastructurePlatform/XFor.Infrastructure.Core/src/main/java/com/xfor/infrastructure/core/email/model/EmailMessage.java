package com.xfor.infrastructure.core.email.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailMessage {

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

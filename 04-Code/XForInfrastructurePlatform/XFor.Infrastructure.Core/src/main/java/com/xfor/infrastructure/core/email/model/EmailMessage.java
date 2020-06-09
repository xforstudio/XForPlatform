package com.xfor.infrastructure.core.email.model;

import lombok.Data;

@Data
public class EmailMessage {

    private String sid;
    private String from;
    private String to;
    private String content;
    private String templateId;
    private String templateData;

    public EmailMessage() {
    }
}

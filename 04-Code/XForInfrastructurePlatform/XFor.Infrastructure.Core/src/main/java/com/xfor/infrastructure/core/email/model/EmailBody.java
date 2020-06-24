package com.xfor.infrastructure.core.email.model;

import lombok.Data;

@Data
public class EmailBody {

    public static EmailBody _createFromHtmlContent(String htmlContent) {
        EmailBody emailBody = new EmailBody();
        emailBody.setHtmlContent(htmlContent);
        return emailBody;
    }

    private String htmlContent;
}

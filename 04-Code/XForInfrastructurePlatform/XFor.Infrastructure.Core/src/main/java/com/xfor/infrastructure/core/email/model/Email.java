package com.xfor.infrastructure.core.email.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 */
@Data
public class Email {

    public static Email _create(EmailMessage emailMessage, EmailAction emailAction) {
        Email email = new Email();
        email.setEmailMessage(emailMessage);
        email.setEmailAction(emailAction);
        return email;
    }

    @JsonProperty("EmailMessage")
    private EmailMessage emailMessage;

    @JsonProperty("EmailAction")
    private EmailAction emailAction;

    public Email() {
    }
}

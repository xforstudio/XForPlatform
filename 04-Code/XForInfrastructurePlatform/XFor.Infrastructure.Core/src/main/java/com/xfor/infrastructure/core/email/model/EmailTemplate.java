package com.xfor.infrastructure.core.email.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 */
@Data
public class EmailTemplate {

    @JsonProperty("Sid")
    private String sid;
}

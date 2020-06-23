package com.xfor.infrastructure.core.email.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import lombok.Data;

/**
 *
 */
@Data
@TableName("EMAIL_TEMPLATE")
public class EmailTemplate extends BaseEntity {

    public static EmailTemplate _create(String code, String name, String memo, String content, String fileName, int engineType) {
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setSid(_newSID());
        emailTemplate.setCode(code);
        emailTemplate.setName(name);
        emailTemplate.setMemo(memo);
        emailTemplate.setContent(content);
        emailTemplate.setFileName(fileName);
        emailTemplate.setEngineType(engineType);
        return emailTemplate;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("Code")
    @TableId("CODE")
    private String code;

    @JsonProperty("Name")
    @TableId("NAME")
    private String name;

    @JsonProperty("Memo")
    @TableId("MEMO")
    private String memo;

    @JsonProperty("Content")
    @TableId("CONTENT")
    private String content;

    @JsonProperty("FileName")
    @TableId("FILE_NAME")
    private String fileName;

    @JsonProperty("EngineType")
    @TableId("ENGINE_TYPE")
    private int engineType;


}

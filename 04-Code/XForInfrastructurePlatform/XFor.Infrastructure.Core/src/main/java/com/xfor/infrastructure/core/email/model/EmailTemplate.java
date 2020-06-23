package com.xfor.infrastructure.core.email.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
@TableName("EMAIL_TEMPLATE")
public class EmailTemplate extends BaseEntity {

    public static EmailTemplate _create(
            String code,
            String name,
            String memo,
            String content,
            String fileName,
            int engineType,
            IDateTimeProvider dateTimeProvider) {
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setSid(_newSID());
        emailTemplate.setCode(code);
        emailTemplate.setName(name);
        emailTemplate.setMemo(memo);
        emailTemplate.setContent(content);
        emailTemplate.setFileName(fileName);
        emailTemplate.setEngineType(engineType);
        emailTemplate.setCreateTime(dateTimeProvider.getNow());
        emailTemplate.setModifyTime(dateTimeProvider.getNow());
        return emailTemplate;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("Code")
    @TableField("CODE")
    private String code;

    @JsonProperty("Name")
    @TableField("NAME")
    private String name;

    @JsonProperty("Memo")
    @TableField("MEMO")
    private String memo;

    @JsonProperty("Content")
    @TableField("CONTENT")
    private String content;

    @JsonProperty("FileName")
    @TableField("FILE_NAME")
    private String fileName;

    @JsonProperty("EngineType")
    @TableField("ENGINE_TYPE")
    private int engineType;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("CREATE_TIME")
    private Date createTime;

    @JsonProperty("ModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("MODIFY_TIME")
    private Date modifyTime;
}

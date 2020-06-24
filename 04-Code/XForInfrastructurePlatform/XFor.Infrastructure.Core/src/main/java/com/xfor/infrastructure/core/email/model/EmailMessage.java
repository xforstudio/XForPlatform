package com.xfor.infrastructure.core.email.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xfor.infrastructure.core.common.model.BaseEntity;
import com.xfor.infrastructure.core.common.model.IDateTimeProvider;
import com.xfor.infrastructure.core.common.model.SID;
import lombok.Data;

import java.util.Date;

@Data
@TableName("EMAIL_MESSAGE")
public class EmailMessage extends BaseEntity {

    public static EmailMessage _create(
            String from,
            String to,
            String subject,
            String content,
            String emailTemplateCode,
            String emailTemplateData,
            IDateTimeProvider dateTimeProvider) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setSid(_newSID());
        emailMessage.setFrom(from);
        emailMessage.setTo(to);
        emailMessage.setSubject(subject);
        emailMessage.setContent(content);
        emailMessage.setEmailTemplateCode(emailTemplateCode);
        emailMessage.setEmailTemplateData(emailTemplateData);
        emailMessage.setCreateTime(dateTimeProvider.getNow());
        return emailMessage;
    }

    @JsonProperty("Sid")
    @TableId("SID")
    private String sid;

    @JsonProperty("From")
    @TableField("FROM")
    private String from;

    @JsonProperty("To")
    @TableField("TO")
    private String to;

    @JsonProperty("Subject")
    @TableField("SUBJECT")
    private String subject;

    @JsonProperty("Content")
    @TableField("CONTENT")
    private String content;

    @JsonProperty("EmailTemplateCode")
    @TableField("EMAIL_TEMPLATE_CODE")
    private String emailTemplateCode;

    @JsonProperty("EmailTemplateData")
    @TableField("EMAIL_TEMPLATE_DATA")
    private String emailTemplateData;

    @JsonProperty("CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 日期格式自动化
    @TableField("CREATE_TIME")
    private Date createTime;
}

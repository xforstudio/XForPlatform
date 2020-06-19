package com.xfor.infrastructure.core.email.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.email.model.EmailTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface IEmailTemplateMyBatisDAO extends BaseMapper<EmailTemplate> {
}

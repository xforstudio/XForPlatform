package com.xfor.infrastructure.core.email.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.email.model.EmailAction;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface IEmailActionMyBatisDAO extends BaseMapper<EmailAction> {
}

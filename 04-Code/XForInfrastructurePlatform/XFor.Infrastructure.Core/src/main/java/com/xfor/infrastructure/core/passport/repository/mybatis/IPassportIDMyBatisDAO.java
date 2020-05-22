package com.xfor.infrastructure.core.passport.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.passport.model.PassportID;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Mapper
public interface IPassportIDMyBatisDAO extends BaseMapper<PassportID> {
}

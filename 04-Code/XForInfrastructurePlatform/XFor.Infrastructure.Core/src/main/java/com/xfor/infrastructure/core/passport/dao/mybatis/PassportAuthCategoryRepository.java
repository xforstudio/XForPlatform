package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.passport.model.PassportAuthCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface PassportAuthCategoryRepository extends BaseMapper<PassportAuthCategory> {
}

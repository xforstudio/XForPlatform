package com.xfor.infrastructure.core.store.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.store.model.Store;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface StoreRepository extends BaseMapper<Store> {
}

package com.xfor.infrastructure.core.store.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.store.model.StoreCart;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface IStoreCartMyBatisDAO extends BaseMapper<StoreCart> {
}

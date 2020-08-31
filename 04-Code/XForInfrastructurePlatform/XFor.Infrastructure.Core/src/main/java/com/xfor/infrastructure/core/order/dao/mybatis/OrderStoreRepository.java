package com.xfor.infrastructure.core.order.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.order.model.OrderStore;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface OrderStoreRepository extends BaseMapper<OrderStore> {
}

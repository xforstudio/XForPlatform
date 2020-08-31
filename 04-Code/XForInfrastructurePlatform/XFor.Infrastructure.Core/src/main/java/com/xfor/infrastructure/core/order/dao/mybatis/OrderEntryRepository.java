package com.xfor.infrastructure.core.order.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.order.model.OrderEntry;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface OrderEntryRepository extends BaseMapper<OrderEntry> {
}

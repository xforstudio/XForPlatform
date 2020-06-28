package com.xfor.infrastructure.core.order.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface IOrderMyBatisDAO extends BaseMapper<Order> {
}

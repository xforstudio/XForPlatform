package com.xfor.infrastructure.core.order.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.order.model.SubOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface ISubOrderMyBatisDAO extends BaseMapper<SubOrder> {
}

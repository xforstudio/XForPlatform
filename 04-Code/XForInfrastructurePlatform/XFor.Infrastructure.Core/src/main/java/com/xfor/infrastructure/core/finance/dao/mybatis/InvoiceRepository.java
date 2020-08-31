package com.xfor.infrastructure.core.finance.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.finance.model.Invoice;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface InvoiceRepository extends BaseMapper<Invoice> {
}

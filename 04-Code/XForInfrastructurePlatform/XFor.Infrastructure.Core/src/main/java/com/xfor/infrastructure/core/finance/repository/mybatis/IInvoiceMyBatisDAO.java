package com.xfor.infrastructure.core.finance.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.finance.model.Invoice;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface IInvoiceMyBatisDAO extends BaseMapper<Invoice> {
}

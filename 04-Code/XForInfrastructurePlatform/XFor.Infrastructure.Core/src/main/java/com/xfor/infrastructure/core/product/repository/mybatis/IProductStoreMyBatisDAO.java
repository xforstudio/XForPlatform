package com.xfor.infrastructure.core.product.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductStore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface IProductStoreMyBatisDAO extends BaseMapper<ProductStore> {

//    @Select("select * from PRODUCT_STORE where SID=#{sid}")
//    ProductStore findFirstBySID(String sid);
//
//    @Select("select * from PRODUCT_STORE where NAME OWNER=#{owner}")
//    List<ProductStore> findAllByOwner(String owner);
//
//    @Select("select count(*) from PRODUCT_STORE where SID=#{sid} limit 1")
//    boolean existsBySID(String sid);
//
//    @Delete("delete from PRODUCT_STORE where SID=#{sid}")
//    int deleteBySID(String sid);
}

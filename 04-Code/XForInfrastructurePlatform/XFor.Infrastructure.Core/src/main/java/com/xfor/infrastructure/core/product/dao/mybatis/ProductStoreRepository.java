package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.product.model.ProductStore;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface ProductStoreRepository extends BaseMapper<ProductStore> {

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

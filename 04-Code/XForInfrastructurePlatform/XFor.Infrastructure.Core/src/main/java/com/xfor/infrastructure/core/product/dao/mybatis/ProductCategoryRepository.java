package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.product.model.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface ProductCategoryRepository extends BaseMapper<ProductCategory> {

//    @Select("select * from PRODUCT_CATEGORY where SID=#{sid}")
//    ProductCategory findFirstBySID(String sid);
//
//    @Select("select * from PRODUCT_CATEGORY where PRODUCT_STORE_SID=#{productStoreSID} and CODE=#{code}")
//    List<ProductCategory> findAllByCode(String productStoreSID, int code);
//
//    @Select("select * from PRODUCT_CATEGORY where NAME like '%#{filter}%' or DESC like '%#{filter}%' ")
//    List<ProductCategory> findAllByFilter(String filter);
//
//    @Select("select count(*) from PRODUCT_CATEGORY where SID=#{sid} limit 1")
//    boolean existsBySID(String sid);
//
//    @Delete("delete from PRODUCT_CATEGORY where SID=#{sid}")
//    int deleteBySID(String sid);
}

package com.xfor.infrastructure.core.product.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.product.model.ProductTag;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface ProductTagRepository extends BaseMapper<ProductTag> {

//    @Select("select * from PRODUCT_TAG where PRODUCT_STORE_SID=#{productStoreSID} and CODE=#{code}")
//    ProductTag findByCode(String productStoreSID, int code);
//
//    @Select("select * from PRODUCT_TAG where PRODUCT_STORE_SID=#{productStoreSID} and PARENT_CODE=#{parentCode}")
//    List<ProductTag> findAllByParentCode(String productStoreSID, int parentCode);
//
//    @Select("select * from PRODUCT_TAG where PRODUCT_STORE_SID=#{productStoreSID}")
//    List<ProductTag> findAllByProductStoreSID(String productStoreSID);
//
//    @Delete("delete from PRODUCT_CATEGORY where PRODUCT_STORE_SID=#{productStoreSID} and CODE=#{code}")
//    int deleteByCode(String productStoreSID, int code);
}

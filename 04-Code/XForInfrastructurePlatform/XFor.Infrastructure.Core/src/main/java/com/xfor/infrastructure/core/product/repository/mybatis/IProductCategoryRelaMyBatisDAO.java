package com.xfor.infrastructure.core.product.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.product.model.Product;
import com.xfor.infrastructure.core.product.model.ProductCategoryRela;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface IProductCategoryRelaMyBatisDAO extends BaseMapper<ProductCategoryRela> {

//    @Select("select * from PRODUCT_CATEGORY_RELA where SID=#{sid}")
//    ProductCategoryRela findFirstBySID(String sid);
//
//    @Select("select * from PRODUCT_CATEGORY_RELA where PRODUCT_STORE_SID=#{productStoreSID} and CATEGORY_CODE=#{categoryCode}")
//    List<ProductCategoryRela> findAllByCategoryCode(String productStoreSID, int categoryCode);
//
//    @Select("select * from PRODUCT_CATEGORY_RELA where PRODUCT_STORE_SID=#{productStoreSID} and PRODUCT_CODE=#{productCode}")
//    List<ProductCategoryRela> findAllByProductCode(String productStoreSID, String productCode);
//
//    @Select("select count(*) from PRODUCT_CATEGORY_RELA where SID=#{sid} limit 1")
//    boolean existsBySID(String sid);
//
//    @Delete("delete from PRODUCT_CATEGORY_RELA where SID=#{sid}")
//    int deleteBySID(String sid);
}

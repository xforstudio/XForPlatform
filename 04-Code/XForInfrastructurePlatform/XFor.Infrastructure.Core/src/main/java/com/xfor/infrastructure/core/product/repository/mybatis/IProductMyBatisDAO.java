package com.xfor.infrastructure.core.product.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.product.model.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface IProductMyBatisDAO extends BaseMapper<Product> {

    @Select("select * from PRODUCT where SID=#{sid}")
    Product findFirstBySID(String sid);

    @Select("select * from PRODUCT where NAME like '%#{name}%' and CATEGORY=#{category}")
    List<Product> findAllByName(String name, String category);

    @Select("select * from PRODUCT where NAME like '%#{filter}%' or DESC like '%#{filter}%' ")
    List<Product> findAllByFilter(String filter);

    @Select("select PICTURES from PRODUCT where SID=#{sid}")
    String findPicturesBySID(String sid);

    @Select("select count(*) from PRODUCT where SID=#{sid} limit 1")
    boolean existsBySID(String sid);

    @Delete("delete from PRODUCT where SID=#{sid}")
    int deleteBySID(String sid);
}

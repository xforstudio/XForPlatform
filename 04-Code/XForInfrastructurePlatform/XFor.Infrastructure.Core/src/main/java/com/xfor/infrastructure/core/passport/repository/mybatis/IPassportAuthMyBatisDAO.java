package com.xfor.infrastructure.core.passport.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.passport.model.PassportAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Mapper
public interface IPassportAuthMyBatisDAO extends BaseMapper<PassportAuth> {

    @Select("select p.LOGIN_TOKEN from PASSPORT p,PASSPORT_AUTH pa where p.SID=pa.PASSPORT_SID and pa.CODE=#{passportAuthCode} and pa.CATEGORY_ID=#{categoryID} limit 1")
    String findLoginTokenByPassportAuthCodeAndCategoryID(String passportAuthCode, String categoryID);

    @Select("select pa.CODE from PASSPORT p,PASSPORT_AUTH pa where p.SID=pa.PASSPORT_SID and p.LOGIN_TOKEN=#{loginToken} and pa.CATEGORY_ID=#{categoryID} limit 1")
    String findPassportAuthCodeByLoginTokenAndCategoryID(String loginToken, String categoryID);
}

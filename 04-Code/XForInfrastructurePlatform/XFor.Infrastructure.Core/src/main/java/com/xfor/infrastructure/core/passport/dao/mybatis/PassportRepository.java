package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xfor.infrastructure.core.passport.model.Passport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 */
@Mapper
public interface PassportRepository extends BaseMapper<Passport> {

    @Select("select * from PASSPORT where SID=#{sid}")
    Passport findFirstBySID(String sid);

    @Select("select * from PASSPORT where SN=#{sn}")
    Passport findFirstBySN(String sn);

    @Select("select * from PASSPORT where USERNAME=#{username}")
    Passport findFirstByUsername(String username);

    @Select("select * from PASSPORT where MOBILE=#{mobile}")
    Passport findFirstByMobile(String mobile);

    @Select("select * from PASSPORT where EMAIL=#{email}")
    Passport findFirstByEmail(String email);

    @Select("select * from PASSPORT where USERNAME=#{username} or MOBILE=#{mobile} or EMAIL=#{email}")
    Passport findFirstByUsernameOrMobileOrEmail(String username, String mobile, String email);

    @Select("select * from PASSPORT where LOGIN_TOKEN=#{loginToken}")
    Passport findFirstByLoginToken(String loginToken);

    @Select("select count(*) from PASSPORT where LOGIN_TOKEN=#{loginToken} limit 1")
    boolean existsByLoginToken(String loginToken);

    @Select("select count(*) from PASSPORT where USERNAME=#{username} limit 1")
    boolean existsByUsername(String username);

    @Select("select count(*) from PASSPORT where MOBILE=#{mobile} limit 1")
    boolean existsByMobile(String mobile);

    @Select("select count(*) from PASSPORT where EMAIL=#{email} limit 1")
    boolean existsByEmail(String email);

    @Delete("delete from PASSPORT where SID=#{sid}")
    void deleteBySID(String sid);
}

package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.xfor.infrastructure.core.passport.dao.PassportAuthCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PassportAuthCategoryDAOImpl implements PassportAuthCategoryDAO {

    @Autowired
    private PassportAuthCategoryRepository passportAuthCategoryRepository;
}

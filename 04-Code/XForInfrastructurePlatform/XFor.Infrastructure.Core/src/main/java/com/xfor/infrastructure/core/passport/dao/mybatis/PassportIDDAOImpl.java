package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.xfor.infrastructure.core.passport.dao.PassportIDDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PassportIDDAOImpl implements PassportIDDAO {

    @Autowired
    private PassportIDRepository passportIDRepository;
}

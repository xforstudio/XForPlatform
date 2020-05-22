package com.xfor.infrastructure.core.passport.repository.mybatis;

import com.xfor.infrastructure.core.passport.repository.IPassportIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisPassportIDRepository implements IPassportIDRepository {

    @Autowired
    private IPassportIDMyBatisDAO passportIDMyBatisDAO;

    public MyBatisPassportIDRepository() {
    }
}

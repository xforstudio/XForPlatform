package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class MyBatisPassportAuthRepositoryTest {

    @Autowired
    private PassportAuthDAOImpl passportAuthRepository;

    protected ServiceContext doGetServiceContext() {
        return ServiceContext._empty();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLoginTokenByPassportAuthCode() {
        String passportAuthCode = "";
        String categoryID = "";
        String loginToken = this.passportAuthRepository.getLoginTokenByPassportAuthCode(
                this.doGetServiceContext(),
                passportAuthCode,
                categoryID);
        Assert.notNull(loginToken, "");
    }

    @Test
    void getPassportAuthCodeByLoginToken() {
        String loginToken = "";
        String categoryID = "";
        String passportAuthCode = this.passportAuthRepository.getPassportAuthCodeByLoginToken(
                this.doGetServiceContext(),
                loginToken,
                categoryID);
        Assert.notNull(passportAuthCode, "");
    }
}
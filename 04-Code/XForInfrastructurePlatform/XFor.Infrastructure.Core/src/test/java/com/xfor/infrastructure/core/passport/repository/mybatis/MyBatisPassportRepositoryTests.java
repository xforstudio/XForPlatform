package com.xfor.infrastructure.core.passport.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.model.Passport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.security.RunAs;

@SpringBootTest
public class MyBatisPassportRepositoryTests {

    @Autowired
    private MyBatisPassportRepository passportRepository;

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
    void getPassportBySID() {
        String passportSID = "A338C963A662411C9DE8602473618929";
        Passport passport = this.passportRepository.getPassportBySID(this.doGetServiceContext(), passportSID);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportBySN() {
        String sn = "";
        Passport passport = this.passportRepository.getPassportBySN(this.doGetServiceContext(), sn);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportByUsername() {
        String username = "";
        Passport passport = this.passportRepository.getPassportByUsername(this.doGetServiceContext(), username);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportByMobile() {
        String mobile = "";
        Passport passport = this.passportRepository.getPassportByMobile(this.doGetServiceContext(), mobile);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportByEmail() {
        String email = "";
        Passport passport = this.passportRepository.getPassportByEmail(this.doGetServiceContext(), email);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportByCredential() {
        String credential = "";
        Passport passport = this.passportRepository.getPassportByCredential(this.doGetServiceContext(), credential);
        Assert.notNull(passport, "");
    }

    @Test
    void getPassportByLoginToken() {
        String loginToken = "";
        Passport passport = this.passportRepository.getPassportByLoginToken(this.doGetServiceContext(), loginToken);
        Assert.notNull(passport, "");
    }

    @Test
    void existsLoginToken() {
        String loginToken = "";
        boolean result = this.passportRepository.existsLoginToken(this.doGetServiceContext(), loginToken);
        Assert.isTrue(result, "");
    }

    @Test
    void existsUsername() {
        String username = "";
        boolean result = this.passportRepository.existsUsername(this.doGetServiceContext(), username);
        Assert.isTrue(result, "");
    }

    @Test
    void existsMobile() {
        String mobile = "";
        boolean result = this.passportRepository.existsMobile(this.doGetServiceContext(), mobile);
        Assert.isTrue(result, "");
    }

    @Test
    void existsEmail() {
        String email = "";
        boolean result = this.passportRepository.existsEmail(this.doGetServiceContext(), email);
        Assert.isTrue(result, "");
    }

    @Test
    void savePassport() {
        Passport passport = null;
        this.passportRepository.savePassport(this.doGetServiceContext(), passport);
        Passport passport_load = this.passportRepository.getPassportBySID(this.doGetServiceContext(), passport.getSID());
        Assert.isTrue(passport_load != null, "");
    }

    @Test
    void deletePassportBySID() {
        String passportSID = "";
        this.passportRepository.deletePassportBySID(this.doGetServiceContext(), passportSID);
        Passport passport_load = this.passportRepository.getPassportBySID(this.doGetServiceContext(), passportSID);
        Assert.isNull(passport_load, "");
    }
}

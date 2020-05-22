package com.xfor.infrastructure.core.passport.repository.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.model.Passport;
import com.xfor.infrastructure.core.passport.repository.IPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class MyBatisPassportRepository implements IPassportRepository {

    @Autowired
    private IPassportMyBatisDAO passportMyBatisDAO;

    public MyBatisPassportRepository() {
    }

    public Passport getPassportBySID(ServiceContext sctx, String sid) {
        //throw new UnsupportedOperationException();
        Passport result = this.passportMyBatisDAO.findFirstBySID(sid);
        return result;
    }

    public Passport getPassportBySN(ServiceContext sctx, String sn) {
        Passport result = this.passportMyBatisDAO.findFirstBySN(sn);
        return result;
    }

    public Passport getPassportByUsername(ServiceContext sctx, String username) {
        Passport result = this.passportMyBatisDAO.findFirstByUsername(username);
        return result;
    }

    public Passport getPassportByMobile(ServiceContext sctx, String mobile) {
        Passport result = this.passportMyBatisDAO.findFirstByMobile(mobile);
        return result;
    }

    public Passport getPassportByEmail(ServiceContext sctx, String email) {
        Passport result = this.passportMyBatisDAO.findFirstByEmail(email);
        return result;
    }

    public Passport getPassportByCredential(ServiceContext sctx, String credential) {
        Passport result = this.passportMyBatisDAO.findFirstByUsernameOrMobileOrEmail(credential, credential, credential);
        return result;
    }

    public Passport getPassportByLoginToken(ServiceContext sctx, String loginToken) {
        Passport result = this.passportMyBatisDAO.findFirstByLoginToken(loginToken);
        return result;
    }

    public boolean existsLoginToken(ServiceContext sctx, String loginToken) {
        boolean result = this.passportMyBatisDAO.existsByLoginToken(loginToken);
        return result;
    }

    public boolean existsUsername(ServiceContext sctx, String username) {
        boolean result = this.passportMyBatisDAO.existsByUsername(username);
        return result;
    }

    public boolean existsMobile(ServiceContext sctx, String mobile) {
        boolean result = this.passportMyBatisDAO.existsByMobile(mobile);
        return result;
    }

    public boolean existsEmail(ServiceContext sctx, String email) {
        boolean result = this.passportMyBatisDAO.existsByEmail(email);
        return result;
    }

    public void savePassport(ServiceContext sctx, Passport passport) {
        int result = this.passportMyBatisDAO.updateById(passport);
        if(result <= 0) {
            result = this.passportMyBatisDAO.insert(passport);
        }
    }

    public void deletePassportBySID(ServiceContext sctx, String sid) {
        this.passportMyBatisDAO.deleteBySID(sid);
    }
}

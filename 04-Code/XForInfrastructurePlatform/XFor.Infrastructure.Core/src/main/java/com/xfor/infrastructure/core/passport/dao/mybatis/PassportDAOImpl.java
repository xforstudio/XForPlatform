package com.xfor.infrastructure.core.passport.dao.mybatis;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.model.Passport;
import com.xfor.infrastructure.core.passport.dao.PassportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PassportDAOImpl implements PassportDAO {

    @Autowired
    private PassportRepository passportRepository;

    public Passport getPassportBySID(ServiceContext sctx, String sid) {
        //throw new UnsupportedOperationException();
        Passport result = this.passportRepository.findFirstBySID(sid);
        return result;
    }

    public Passport getPassportBySN(ServiceContext sctx, String sn) {
        Passport result = this.passportRepository.findFirstBySN(sn);
        return result;
    }

    public Passport getPassportByUsername(ServiceContext sctx, String username) {
        Passport result = this.passportRepository.findFirstByUsername(username);
        return result;
    }

    public Passport getPassportByMobile(ServiceContext sctx, String mobile) {
        Passport result = this.passportRepository.findFirstByMobile(mobile);
        return result;
    }

    public Passport getPassportByEmail(ServiceContext sctx, String email) {
        Passport result = this.passportRepository.findFirstByEmail(email);
        return result;
    }

    public Passport getPassportByCredential(ServiceContext sctx, String credential) {
        Passport result = this.passportRepository.findFirstByUsernameOrMobileOrEmail(credential, credential, credential);
        return result;
    }

    public Passport getPassportByLoginToken(ServiceContext sctx, String loginToken) {
        Passport result = this.passportRepository.findFirstByLoginToken(loginToken);
        return result;
    }

    public boolean existsLoginToken(ServiceContext sctx, String loginToken) {
        boolean result = this.passportRepository.existsByLoginToken(loginToken);
        return result;
    }

    public boolean existsUsername(ServiceContext sctx, String username) {
        boolean result = this.passportRepository.existsByUsername(username);
        return result;
    }

    public boolean existsMobile(ServiceContext sctx, String mobile) {
        boolean result = this.passportRepository.existsByMobile(mobile);
        return result;
    }

    public boolean existsEmail(ServiceContext sctx, String email) {
        boolean result = this.passportRepository.existsByEmail(email);
        return result;
    }

    public void savePassport(ServiceContext sctx, Passport passport) {
        int result = this.passportRepository.updateById(passport);
        if(result <= 0) {
            result = this.passportRepository.insert(passport);
        }
    }

    public void deletePassportBySID(ServiceContext sctx, String sid) {
        this.passportRepository.deleteBySID(sid);
    }
}

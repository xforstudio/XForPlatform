package com.xfor.infrastructure.core.passport.repository;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.infrastructure.core.passport.model.Passport;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface IPassportRepository {

    Passport getPassportBySID(ServiceContext sctx, String sid);

    Passport getPassportBySN(ServiceContext sctx, String sn);

    Passport getPassportByUsername(ServiceContext sctx, String username);

    Passport getPassportByMobile(ServiceContext sctx, String mobile);

    Passport getPassportByEmail(ServiceContext sctx, String email);

    Passport getPassportByCredential(ServiceContext sctx, String credential);

    Passport getPassportByLoginToken(ServiceContext sctx, String loginToken);

    boolean existsLoginToken(ServiceContext sctx, String loginToken);

    boolean existsUsername(ServiceContext sctx, String username);

    boolean existsMobile(ServiceContext sctx, String mobile);

    boolean existsEmail(ServiceContext sctx, String email);

    void savePassport(ServiceContext sctx, Passport passport);

    void deletePassportBySID(ServiceContext sctx, String sid);
}

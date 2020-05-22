package com.xfor.infrastructure.core.passport.model;

import com.xfor.infrastructure.core.common.util.StringUtil;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class PassportIDList extends ArrayList<PassportID> {

    public PassportIDList() {
        super();
    }

    public PassportIDList(Collection<PassportID> collection) {
        super(collection);
    }

    public PassportID AddPassportID(PassportID passportID) throws PassportException {
        PassportID temp = null;
        for (PassportID item : this) {
            if (StringUtil._equals(item.getPassportSID(), passportID.getPassportSID())
                    && item.getIDTypeNO() == passportID.getIDTypeNO()) {
                temp = item;
                break;
            }
        }
        if (temp != null)
        {
            throw new PassportException("证件类型已存在");
        }
        for (PassportID item : this) {
            if (item.isPrimary()) {
                temp = item;
                break;
            }
        }
        passportID.setPrimary(temp == null);
        this.add(passportID);
        return passportID;
    }
}

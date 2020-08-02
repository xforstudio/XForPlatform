package com.xfor.infrastructure.core.common.model;

import java.util.UUID;

/**
 * 唯一标识
 */
public class SID {

    public static String _newSID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase();
    }

    public static boolean _equalsSid(String sid1, String sid2) {
        return sid1 != null && sid2 != null && sid1.equals(sid2);
    }
}

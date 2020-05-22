package com.xfor.infrastructure.core.common.model;

import java.util.UUID;

/**
 * 令牌
 */
public class Token {

    public static String _newToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase();
    }
}

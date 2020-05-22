package com.xfor.infrastructure.core.common.util;

/**
 *
 */
public class StringUtil {

    public static Boolean _equals(String s1, String s2) {
        return s1 != null && s2 != null && s1.equals(s2);
    }

    public static Boolean _isNullOrWhiteSpace(String s) {
        return s == null || s == "";
    }
}

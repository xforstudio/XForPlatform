package com.xfor.infrastructure.core.common.model;

/**
 * 性别
 */
public class Sex {

    public static String _format(int sex) {
        switch (sex) {
            case SexEnum.None: return "-";
            case SexEnum.Male: return "男";
            case SexEnum.Female: return "女";
            default: return null;
        }
    }
}

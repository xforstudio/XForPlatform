package com.xfor.infrastructure.core.common.util;

import java.util.Random;

public class RandomUtil {

    /**
     * 生成[min,max]的随机整数
     */
    public static int _nextInt(int min, int max) {
        return new Random().nextInt(max-min) + min;
    }

    public static int _nextInt(int length) {
        return _nextInt(1, (int) Math.pow(10, length) - 1);
    }

    public static String _nextIntWithFormat(int length, String format) {
        int n = _nextInt(length);
        String s = String.format(format, n);
        return s;
    }

}

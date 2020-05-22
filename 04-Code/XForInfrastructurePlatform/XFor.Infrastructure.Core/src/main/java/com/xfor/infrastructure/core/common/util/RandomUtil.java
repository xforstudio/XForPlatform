package com.xfor.infrastructure.core.common.util;

import java.util.Random;

public class RandomUtil {

    /**
     * 生成[min,max]的随机整数
     */
    public static int _nextInt(int min, int max) {
        return new Random().nextInt(max-min) + min;
    }
}

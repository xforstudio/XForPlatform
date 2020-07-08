package com.xfor.infrastructure.core.store.model;

/**
 * 商店状态
 */
public class StoreStateEnum {
    public static final int None = 0;
    public static final int Open = 1;  //正常
    public static final int Close = 2;  //关闭
    public static final int Pause = 3;  //暂停
    public static final int Cancellation = 4;  //注销
}

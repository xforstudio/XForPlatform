package com.xfor.infrastructure.core.store.model;

/**
 * 商店状态
 */
public class StoreStateEnum {
    public static final int None = 0;
    public static final int Registered = 1;  //已注册
    public static final int Opened = 2;  //已开启
    public static final int Closed = 3;  //已关闭
    public static final int Cancelled = 4;  //已注销
}

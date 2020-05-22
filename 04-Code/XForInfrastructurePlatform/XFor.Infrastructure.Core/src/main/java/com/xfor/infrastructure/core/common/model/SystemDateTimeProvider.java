package com.xfor.infrastructure.core.common.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public class SystemDateTimeProvider implements IDateTimeProvider {

    private static SystemDateTimeProvider _instance;

    public static SystemDateTimeProvider _getInstance() {
        if (_instance == null)
        {
            _instance = new SystemDateTimeProvider();
        }
        return _instance;
    }

    public Date getNow()
    {
        return new Date();
    }
}

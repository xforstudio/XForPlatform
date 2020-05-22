package com.xfor.infrastructure.core.common.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public interface IDateTimeProvider {
    Date getNow();
}

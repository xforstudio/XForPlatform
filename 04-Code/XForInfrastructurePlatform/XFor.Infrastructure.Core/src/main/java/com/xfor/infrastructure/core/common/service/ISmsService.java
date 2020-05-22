package com.xfor.infrastructure.core.common.service;

import org.springframework.stereotype.Component;

/**
 * 短信服务
 */
@Component
public interface ISmsService {
    void send(String mobileNO, String content);
}

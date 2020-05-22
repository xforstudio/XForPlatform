package com.xfor.infrastructure.core.common.service.impl.stub;

import com.xfor.infrastructure.core.common.service.ISmsService;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class StubSmsService implements ISmsService {

    @Override
    public void send(String mobileNO, String content) {
        throw new UnsupportedOperationException();
    }
}

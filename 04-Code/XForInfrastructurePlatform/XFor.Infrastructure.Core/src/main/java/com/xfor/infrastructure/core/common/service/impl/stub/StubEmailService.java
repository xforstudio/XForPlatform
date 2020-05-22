package com.xfor.infrastructure.core.common.service.impl.stub;

import com.xfor.infrastructure.core.common.service.IEmailService;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class StubEmailService implements IEmailService {

    @Override
    public void send(String email, String content) {

    }
}

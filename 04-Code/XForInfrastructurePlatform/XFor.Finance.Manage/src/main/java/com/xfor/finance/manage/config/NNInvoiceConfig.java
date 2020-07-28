package com.xfor.finance.manage.config;

import com.xfor.finance.manage.manager.nuonuo.NNInvoiceManager;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
public class NNInvoiceConfig {

    @Bean
    public NNInvoiceManager invoiceManager() {
        return new NNInvoiceManager();
    }
}

package com.xfor.store.manage.service;

import com.xfor.infrastructure.core.common.service.ServiceContext;
import com.xfor.store.manage.service.impl.StoreCartServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoreCartServiceImplTest {

    @Autowired
    private StoreCartServiceImpl storeCartServiceImpl;

    protected ServiceContext doGetServiceContext() {
        return ServiceContext._empty();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStoreCartEntriesByStoreSid() {
    }

    @Test
    void getStoreCartEntriesByAll() {
    }

    @Test
    void increaseProduct() {
    }

    @Test
    void decreaseProduct() {
    }

    @Test
    void removeProductsByStoreSid() {
    }

    @Test
    void removeProductsByAll() {
    }
}
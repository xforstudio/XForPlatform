package com.xfor.email.manage.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisManagerTests {

    @Autowired
    private RedisManager redisManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValue() {
        String key = "xfor_email_redis_key";
        Object value = "xfor_email_redis_value";
        Object result = this.redisManager.getValue(key);
        Assert.isTrue(value.equals(result), "");
    }

    @Test
    void setValue() {
        String key = "xfor_email_redis_key";
        Object value = "xfor_email_redis_value";
        boolean result = this.redisManager.setValue(key, value);
        Assert.isTrue(result, "");
    }
}
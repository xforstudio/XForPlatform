package com.xfor.infrastructure.core.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.product.model.Product;

/**
 *
 */
public class JsonUtil {

    public static String _objectToString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(object);
        return content;
    }

    public static <T> T _stringToObject(String content, Class<T> valueType) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        T object = mapper.readValue(content, valueType);
        return object;
    }
}

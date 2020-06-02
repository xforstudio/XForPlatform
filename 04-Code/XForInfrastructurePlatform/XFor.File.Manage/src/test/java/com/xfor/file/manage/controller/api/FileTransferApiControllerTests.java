package com.xfor.file.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.common.util.HttpUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class FileTransferApiControllerTests {

    private String rootUrl = "http://127.0.0.1:8731/FileTransferApi";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void uploadFile() {
    }

    @Test
    void downloadFile() throws JsonProcessingException {
        //
        String path = "/Account0001/DL0001.txt";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/DownloadFile", 30000, jsonParams);
        Assert.notNull(result, "");
    }
}
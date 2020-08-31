package com.xfor.file.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.common.util.HttpUtil;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class FileTransferApiControllerTest {

    private String rootUrl = "http://127.0.0.1:8731/FileTransferApi";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void uploadFile() throws JsonProcessingException, UnsupportedEncodingException {
        //
        String dirPath = "/Account0001";
        File file = new File("C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.File.Manage\\Resource\\UL0002.txt");
        //
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("dirPath", new StringBody(dirPath));
        entity.addPart("file", new FileBody(file));

        //String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._post(this.rootUrl + "/UploadFile", entity);
        Assert.notNull(result, "");
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
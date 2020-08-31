package com.xfor.file.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.infrastructure.core.common.util.HttpUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileManageApiControllerTest {

    private String rootUrl = "http://127.0.0.1:8731/FileManageApi";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createDirectory() throws JsonProcessingException {
        //
        String path = "/Account0001";
        String dirName = "Folder0001";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("dirName", dirName);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/CreateDirectory", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void removeDirectory() throws JsonProcessingException {
        //
        String path = "/Account0001";
        String dirName = "Folder0001";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("dirName", dirName);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RemoveDirectory", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void removeDirectories() throws JsonProcessingException {
        //
        String path = "/Account0001";
        List<String> dirNames = new ArrayList<>();
        dirNames.add("Folder0001");
        dirNames.add("Folder0002");
        dirNames.add("Folder0003");
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("dirNames", dirNames);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RemoveDirectories", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void renameDirectory() throws JsonProcessingException {
        //
        String path = "/Account0001";
        String dirName = "Folder0001";
        String dirNameNew = "Folder0002";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("dirName", dirName);
        params.put("dirNameNew", dirNameNew);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RenameDirectory", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void listDirectory() throws JsonProcessingException {
        //
        String path = "/Account0001";
        String dirName = "Folder0001";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("dirName", dirName);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/ListDirectory", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void removeFile() throws JsonProcessingException {
        //
        String path = "/Account0001";
        String fileName = "File0001.txt";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("fileName", fileName);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RemoveFile", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void removeFiles() throws JsonProcessingException {
        //
        String path = "/Account0001";
        List<String> fileNames = new ArrayList<>();
        fileNames.add("File0001.txt");
        fileNames.add("File0002.txt");
        fileNames.add("File0003.txt");
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("fileNames", fileNames);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RemoveFiles", 30000, jsonParams);
        Assert.notNull(result, "");
    }

    @Test
    void renameFile() throws JsonProcessingException {
        //
        String path = "/Account0001";
        String fileName = "File0001.txt";
        String fileNameNew = "File0002.txt";
        //
        Map<String, Object> params =  new HashMap<>();
        params.put("path", path);
        params.put("fileName", fileName);
        params.put("fileNameNew", fileNameNew);
        String jsonParams = new ObjectMapper().writeValueAsString(params);
        String result = HttpUtil._postJson(this.rootUrl + "/RenameFile", 30000, jsonParams);
        Assert.notNull(result, "");
    }
}
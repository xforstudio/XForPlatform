package com.xfor.file.manage.service;

import com.xfor.infrastructure.core.file.model.FileException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileTransferServiceTests {

    @Autowired
    private FileTransferService fileTransferService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void uploadFile() throws UnsupportedEncodingException, FileException {
        String path = "/Account0001";
        MultipartFile file = new MockMultipartFile("file", "UL0001.txt", "multipart/form-data", "hello upload".getBytes("UTF-8"));
        boolean result = this.fileTransferService.uploadFile(path, file);
        Assert.isTrue(result, "");
    }

    @Test
    void downloadFile() throws FileException {
        String path = "/Account0001/DL0001.txt";
        File file = this.fileTransferService.downloadFile(path);
        Assert.notNull(file, "");
    }
}
package com.xfor.file.manage.service;

import com.xfor.file.manage.config.FileConfig;
import com.xfor.infrastructure.core.file.model.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件传输服务
 */
@Component
public interface FileTransferService {

    boolean uploadFile(String dirPath, MultipartFile file_src) throws FileException;

    File downloadFile(String path) throws FileException;

}

package com.xfor.file.manage.service;

import com.xfor.file.manage.config.FileConfig;
import com.xfor.infrastructure.core.common.util.IOUtil;
import com.xfor.infrastructure.core.file.model.DirectoryInfo;
import com.xfor.infrastructure.core.file.model.FileException;
import com.xfor.infrastructure.core.file.model.FileInfo;
import com.xfor.infrastructure.core.file.model.PathUnitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public interface FileManageService {

    //目录操作

    public DirectoryInfo createDirectory(String path, String dirName) throws FileException;

    public DirectoryInfo removeDirectory(String path, String dirName) throws FileException;

    public List<DirectoryInfo> removeDirectories(String path, List<String> dirNames) throws FileException;

    public DirectoryInfo renameDirectory(String path, String dirName, String dirNameNew) throws FileException;

    public List<PathUnitInfo> listDirectory(String path, String dirName) throws FileException;

    //文件操作

    public FileInfo removeFile(String path, String fileName) throws FileException;

    public List<FileInfo> removeFiles(String path, List<String> fileNames) throws FileException;

    public FileInfo renameFile(String path, String fileName, String fileNameNew) throws FileException;
}

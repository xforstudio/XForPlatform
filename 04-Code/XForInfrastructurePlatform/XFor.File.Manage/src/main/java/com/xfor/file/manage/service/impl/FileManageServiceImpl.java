package com.xfor.file.manage.service.impl;

import com.xfor.file.manage.config.FileConfig;
import com.xfor.file.manage.service.FileManageService;
import com.xfor.infrastructure.core.common.service.BaseService;
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
public class FileManageServiceImpl extends BaseService implements FileManageService {

    @Autowired
    private FileConfig fileConfig;

    //目录操作

    @Override
    public DirectoryInfo createDirectory(String path, String dirName) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(actualPath, dirName).toString();
        File directory = new File(dirPath);
        if (directory.exists()) {
            throw new FileException("目录已存在");
        }
        //创建目录
        if (!directory.mkdir()) {
            throw new FileException("目录创建失败");
        }
        DirectoryInfo result = this.doCreateDirectoryInfo(directory);
        return result;
    }

    @Override
    public DirectoryInfo removeDirectory(String path, String dirName) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(actualPath, dirName).toString();
        File directory = new File(dirPath);
        if (!directory.exists()) {
            throw new FileException("目录不存在");
        }
        DirectoryInfo result = this.doCreateDirectoryInfo(directory);
        //删除目录
        if (!IOUtil._deleteDirWithDeep(directory)) {
            throw new FileException("目录删除失败");
        }
//        if (!directory.delete()) {
//            throw new FileException("目录删除失败");
//        }
        //
        return result;
    }

    @Override
    public List<DirectoryInfo> removeDirectories(String path, List<String> dirNames) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //
        List<DirectoryInfo> result = new ArrayList<>();
        for (String dirName: dirNames) {
            //检查目录
            String dirPath = Paths.get(actualPath, dirName).toString();
            File directory = new File(dirPath);
            if (!directory.exists()) {
                continue;
            }
            DirectoryInfo dirInfo = this.doCreateDirectoryInfo(directory);
            //删除目录
            if (!directory.delete()) {
                continue;
            }
            result.add(dirInfo);
        }
        return result;
    }

    @Override
    public DirectoryInfo renameDirectory(String path, String dirName, String dirNameNew) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(actualPath, dirName).toString();
        File directory = new File(dirPath);
        if (!directory.exists()) {
            throw new FileException("目录["+ dirName +"]不存在");
        }
        String dirPathNew = Paths.get(actualPath, dirNameNew).toString();
        File directoryNew = new File(dirPathNew);
        if (directoryNew.exists()) {
            throw new FileException("目录["+ dirNameNew +"]已存在");
        }
        //重命名
        directory.renameTo(directoryNew);
        //
        DirectoryInfo result = this.doCreateDirectoryInfo(directoryNew);
        return result;
    }

    @Override
    public List<PathUnitInfo> listDirectory(String path, String dirName) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(actualPath, dirName).toString();
        File directory = new File(dirPath);
        if (!directory.exists()) {
            throw new FileException("目录["+ dirName +"]不存在");
        }
        List<PathUnitInfo> result = new ArrayList<>();
        for (File item: directory.listFiles()) {
            if (item.isDirectory()) {
                DirectoryInfo dirInfo = this.doCreateDirectoryInfo(item);
                result.add(dirInfo);
                continue;
            }
            if (item.isFile()) {
                FileInfo fileInfo = this.doCreateFileInfo(item);
                result.add(fileInfo);
                continue;
            }
        }
        return result;
    }

    //文件操作

    @Override
    public FileInfo removeFile(String path, String fileName) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查文件
        String filePath = Paths.get(actualPath, fileName).toString();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileException("文件不存在");
        }
        FileInfo result = this.doCreateFileInfo(file);
        //删除文件
        if (!file.delete()) {
            throw new FileException("文件删除失败");
        }
        //
        return result;
    }

    @Override
    public List<FileInfo> removeFiles(String path, List<String> fileNames) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //
        List<FileInfo> result = new ArrayList<>();
        for (String fileName: fileNames) {
            //检查文件
            String filePath = Paths.get(actualPath, fileName).toString();
            File file = new File(filePath);
            if (!file.exists()) {
                continue;
            }
            FileInfo fileInfo = this.doCreateFileInfo(file);
            //删除文件
            if (!file.delete()) {
                continue;
            }
            result.add(fileInfo);
        }
        return result;
    }

    @Override
    public FileInfo renameFile(String path, String fileName, String fileNameNew) throws FileException {
        String actualPath = this.doGetActualPath(path);
        //检查路径
        File directory_sup = new File(actualPath);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查文件
        String filePath = Paths.get(actualPath, fileName).toString();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileException("文件["+ fileName +"]不存在");
        }
        String filePathNew = Paths.get(actualPath, fileNameNew).toString();
        File fileNew = new File(filePathNew);
        if (fileNew.exists()) {
            throw new FileException("文件["+ fileNameNew +"]已存在");
        }
        //重命名
        file.renameTo(fileNew);
        //
        FileInfo result = this.doCreateFileInfo(fileNew);
        return result;
    }

    protected String doGetActualPath(String path) {
        String result = Paths.get(this.fileConfig.getRootPath(), path).toString();
        return result;
    }

    protected DirectoryInfo doCreateDirectoryInfo(File directory) {
        DirectoryInfo result = DirectoryInfo._loadFromFile(directory);
        return result;
    }

    protected FileInfo doCreateFileInfo(File file) {
        FileInfo result = FileInfo._loadFromFile(file);
        return result;
    }
}

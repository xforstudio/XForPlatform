package com.xfor.file.manage.service;

import com.xfor.infrastructure.core.file.model.DirectoryInfo;
import com.xfor.infrastructure.core.file.model.FileException;
import com.xfor.infrastructure.core.file.model.FileInfo;
import com.xfor.infrastructure.core.file.model.PathUnitInfo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileManageService {

    public FileManageService() {
    }

    protected DirectoryInfo doCreateDirectoryInfo(String dirPath) {
        return null;
    }

    protected DirectoryInfo doCreateDirectoryInfo(File directory) {
        return null;
    }

    protected FileInfo doCreateFileInfo(String filePath) {
        return null;
    }

    protected FileInfo doCreateFileInfo(File file) {
        return null;
    }

    //目录操作

    public DirectoryInfo createDirectory(String path, String dirName) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(path, dirName).toString();
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

    public DirectoryInfo removeDirectory(String path, String dirName) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(path, dirName).toString();
        File directory = new File(dirPath);
        if (!directory.exists()) {
            throw new FileException("目录不存在");
        }
        DirectoryInfo result = this.doCreateDirectoryInfo(directory);
        //删除目录
        if (!directory.delete()) {
            throw new FileException("目录删除失败");
        }
        //
        return result;
    }

    public List<DirectoryInfo> removeDirectories(String path, List<String> dirNames) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //
        List<DirectoryInfo> result = new ArrayList<>();
        for (String dirName: dirNames) {
            //检查目录
            String dirPath = Paths.get(path, dirName).toString();
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

    public DirectoryInfo renameDirectory(String path, String dirName, String dirNameNew) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(path, dirName).toString();
        File directory = new File(dirPath);
        if (!directory.exists()) {
            throw new FileException("目录["+ dirName +"]不存在");
        }
        String dirPathNew = Paths.get(path, dirNameNew).toString();
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

    public List<PathUnitInfo> listDirectory(String path, String dirName) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查目录
        String dirPath = Paths.get(path, dirName).toString();
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

    public FileInfo removeFile(String path, String fileName) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查文件
        String filePath = Paths.get(path, fileName).toString();
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

    public List<FileInfo> removeFiles(String path, List<String> fileNames) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //
        List<FileInfo> result = new ArrayList<>();
        for (String fileName: fileNames) {
            //检查文件
            String filePath = Paths.get(path, fileName).toString();
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

    public FileInfo renameFile(String path, String fileName, String fileNameNew) throws FileException {
        //检查路径
        File directory_sup = new File(path);
        if (!directory_sup.exists()) {
            throw new FileException("路径不存在");
        }
        //检查文件
        String filePath = Paths.get(path, fileName).toString();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileException("文件["+ fileName +"]不存在");
        }
        String filePathNew = Paths.get(path, fileNameNew).toString();
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
}

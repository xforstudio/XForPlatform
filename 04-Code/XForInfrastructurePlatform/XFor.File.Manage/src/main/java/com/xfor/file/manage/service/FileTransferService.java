package com.xfor.file.manage.service;

import com.xfor.file.manage.manager.FileConfig;
import com.xfor.infrastructure.core.file.model.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件传输服务
 */
@Component
public class FileTransferService {

    @Autowired
    private FileConfig fileConfig;

    public boolean uploadFile(String path, MultipartFile file_src) throws FileException {
        //判断目录是否存在
        String dirPath_dest = Paths.get(this.fileConfig.getRootPath(), path).toString();
        File directory_dest = new File(dirPath_dest);
        if (!directory_dest.exists()) {
            directory_dest.mkdir();
        }
        //
        String fileName_dest = file_src.getOriginalFilename();
        String filePath_dest = Paths.get(dirPath_dest, fileName_dest).toString();
        File file_dest = new File(filePath_dest);
        try {
            file_src.transferTo(file_dest);
            //LOGGER.info("上传成功");
            //return "上传成功";
        } catch (IOException e) {
            throw new FileException(e.getMessage());
            //LOGGER.error(e.toString(), e);
        }
        finally {
            return file_dest.exists();
        }
        //return "上传失败！";
    }

    public void uploadFiles() {

    }

    public File downloadFile(String path) throws FileException {
        //下载
        Path filePath = Paths.get(this.fileConfig.getRootPath(), path);
        //String fileName = filePath.getFileName().toString();
        File file = new File(filePath.toString());
        if(!file.exists()) {
            throw new FileException("文件不存在");
        };
        return file;
    }

}

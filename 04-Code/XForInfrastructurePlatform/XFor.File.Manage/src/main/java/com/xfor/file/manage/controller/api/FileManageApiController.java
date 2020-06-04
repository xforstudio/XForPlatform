package com.xfor.file.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.file.manage.service.FileManageService;
import com.xfor.infrastructure.core.file.model.DirectoryInfo;
import com.xfor.infrastructure.core.file.model.FileException;
import com.xfor.infrastructure.core.file.model.FileInfo;
import com.xfor.infrastructure.core.file.model.PathUnitInfo;
import com.xfor.infrastructure.core.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/FileManageApi")
public class FileManageApiController {

    @Autowired
    private FileManageService fileManageService;

    @PostMapping(value = "/CreateDirectory", produces = "application/json;charset=UTF-8")
    public DirectoryInfo createDirectory(@RequestBody String requestBody) throws JsonProcessingException, FileException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        String dirName = params.get("dirName").toString();
        DirectoryInfo result = this.fileManageService.createDirectory(path, dirName);
        return result;
    }

    @PostMapping(value = "/RemoveDirectory", produces = "application/json;charset=UTF-8")
    public DirectoryInfo removeDirectory(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        String dirName = params.get("dirName").toString();
        DirectoryInfo result = this.fileManageService.removeDirectory(path, dirName);
        return result;
    }

    @PostMapping(value = "/RemoveDirectories", produces = "application/json;charset=UTF-8")
    public List<DirectoryInfo> removeDirectories(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        List<String> dirNames = (List<String>)params.get("dirNames");
        List<DirectoryInfo> result = this.fileManageService.removeDirectories(path, dirNames);
        return result;
    }

    @PostMapping(value = "/RenameDirectory", produces = "application/json;charset=UTF-8")
    public DirectoryInfo renameDirectory(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        String dirName = params.get("dirName").toString();
        String dirNameNew = params.get("dirNameNew").toString();
        DirectoryInfo result = this.fileManageService.renameDirectory(path, dirName, dirNameNew);
        return result;
    }

    @PostMapping(value = "/ListDirectory", produces = "application/json;charset=UTF-8")
    public List<PathUnitInfo> listDirectory(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        String dirName = params.get("dirName").toString();
        List<PathUnitInfo> result = this.fileManageService.listDirectory(path, dirName);
        return result;
    }

    //文件操作

    @PostMapping(value = "/RemoveFile", produces = "application/json;charset=UTF-8")
    public FileInfo removeFile(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        String fileName = params.get("fileName").toString();
        FileInfo result = this.fileManageService.removeFile(path, fileName);
        return result;
    }

    @PostMapping(value = "/RemoveFiles", produces = "application/json;charset=UTF-8")
    public List<FileInfo> removeFiles(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        List<String> fileNames = (List<String>)params.get("fileNames");
        List<FileInfo> result = this.fileManageService.removeFiles(path, fileNames);
        return result;
    }

    @PostMapping(value = "/RenameFile", produces = "application/json;charset=UTF-8")
    public FileInfo renameFile(@RequestBody String requestBody) throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        String fileName = params.get("fileName").toString();
        String fileNameNew = params.get("fileNameNew").toString();
        FileInfo result = this.fileManageService.renameFile(path, fileName, fileNameNew);
        return result;
    }
}

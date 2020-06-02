package com.xfor.file.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.file.manage.service.FileTransferService;
import com.xfor.infrastructure.core.file.model.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/FileTransferApi")
public class FileTransferApiController {

    @Autowired
    private FileTransferService fileTransferService;

    @PostMapping("/UploadFile")
    @ResponseBody
    public void uploadFile(
            @RequestParam("path") String path,
            @RequestParam("file") MultipartFile file)
            throws FileException {
        if (file.isEmpty()) {
            throw new FileException("上传失败，请选择文件");
        }
        this.fileTransferService.uploadFile(path, file);
    }

    @PostMapping("/DownloadFile")
    public byte[] downloadFile(@RequestBody String requestBody)
            throws FileException, JsonProcessingException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        //
        File file = this.fileTransferService.downloadFile(path);
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            return bytes;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new FileException(ex.getMessage());
        }

//        try (InputStream inputStream = new FileInputStream(file);
//             OutputStream outputStream = response.getOutputStream();) {
//            //设置http头
//            response.setContentType("application/x-download");
//            response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
//            FileCopyUtils.copy(inputStream, outputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}

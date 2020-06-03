package com.xfor.file.manage.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfor.file.manage.service.FileTransferService;
import com.xfor.infrastructure.core.file.model.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Boolean> uploadFile(
            @RequestParam String dirPath,
            @RequestParam MultipartFile file)
            throws FileException {
        if (file.isEmpty()) {
            throw new FileException("上传失败，请选择文件");
        }
        boolean result = this.fileTransferService.uploadFile(dirPath, file);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @PostMapping("/DownloadFile")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestBody String requestBody)
            throws FileException, IOException {
        Map<String, Object> params = new ObjectMapper().readValue(requestBody, Map.class);
        String path = params.get("path").toString();
        //
        File file = this.fileTransferService.downloadFile(path);
        //
        FileSystemResource fsr = new FileSystemResource(file.getPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", fsr.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<InputStreamResource> result = ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(fsr.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(fsr.getInputStream()));
        return result;

//        File file = this.fileTransferService.downloadFile(path);
//        try (InputStream inputStream = new FileInputStream(file)) {
//            byte[] bytes = inputStream.readAllBytes();
//            return bytes;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new FileException(ex.getMessage());
//        }

    }

    @GetMapping("/DownloadFile2")
    public ResponseEntity<InputStreamResource> downloadFile2(@RequestParam String path)
            throws FileException, IOException {
        //
        File file = this.fileTransferService.downloadFile(path);
        //
        FileSystemResource fsr = new FileSystemResource(file.getPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", fsr.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<InputStreamResource> result = ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(fsr.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(fsr.getInputStream()));
        return result;
    }

}

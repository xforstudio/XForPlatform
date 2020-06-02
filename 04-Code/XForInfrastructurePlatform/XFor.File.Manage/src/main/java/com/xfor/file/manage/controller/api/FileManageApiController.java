package com.xfor.file.manage.controller.api;

import com.xfor.file.manage.service.FileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileManageApiController {

    @Autowired
    private FileManageService fileManageService;


}

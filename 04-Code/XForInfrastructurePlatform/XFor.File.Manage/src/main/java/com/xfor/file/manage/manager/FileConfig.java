package com.xfor.file.manage.manager;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileConfig {

    //@Value(value = "${user.userName}")
    private String rootPath = "C:\\WorkSpace\\XFor\\Projects\\TestData\\XForPlatform\\XFor.File.Manage\\RootPath";
}

package com.xfor.infrastructure.core.common.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {

//    public static _copyStream(InputStream inputStream, OutputStream outputStream) {
//
//    }

    public static boolean _existDir(String dirPath) {
        File file = new File(dirPath);
        return file.exists();
    }
}

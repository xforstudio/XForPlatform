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

    public static boolean _deleteDirWithDeep(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = _deleteDirWithDeep(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        //目录此时为空，可以删除
        return dir.delete();
    }
}

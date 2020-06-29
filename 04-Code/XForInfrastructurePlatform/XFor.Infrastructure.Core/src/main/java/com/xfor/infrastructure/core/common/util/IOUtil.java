package com.xfor.infrastructure.core.common.util;

import java.io.*;

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

    public static String _readAllText(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        return _readAllText(fileName, "UTF-8");
    }

    public static String _readAllText(String fileName, String charsetName) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, charsetName);
        BufferedReader reader = new BufferedReader(isr);
        StringBuffer sbf = new StringBuffer();
        try {
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void _writeAllText(String fileName, String content) {
        _writeAllText(fileName, content, "UTF-8");
    }

    public static void _writeAllText(String fileName, String content, String charsetName) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(fileName);
            osw = new OutputStreamWriter(fos, charsetName);
            osw.write(content);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void _ensureFileDelete(String fileName) {
        File file = new File(fileName);
        if (!file.isFile() || !file.exists()) {
            return;
        }
        file.delete();
    }
}

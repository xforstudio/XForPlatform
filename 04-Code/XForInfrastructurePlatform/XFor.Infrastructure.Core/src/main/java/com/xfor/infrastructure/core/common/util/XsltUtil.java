package com.xfor.infrastructure.core.common.util;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Properties;

/**
 * Xslt工具类
 */
public class XsltUtil {

    public static String _transform(InputStream xslStream, InputStream xmlStream) throws TransformerException, UnsupportedEncodingException {

        StreamSource xslSource = new StreamSource(xslStream);
        StreamSource xmlSource = new StreamSource(xmlStream);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Templates templates = transformerFactory.newTemplates(xslSource);
        Transformer transformer = templates.newTransformer();
        //
        Properties properties = transformer.getOutputProperties();
        properties.setProperty(OutputKeys.ENCODING, "utf-8");
        transformer.setOutputProperties(properties);
        //设置输出
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamResult streamResult = new StreamResult(outputStream);
        //转换
        transformer.transform(xmlSource, streamResult);
        //获取结果字符串
        String resultString = new String(outputStream.toByteArray(), "utf-8");
        return resultString;
    }

    public static String _transform(String xslContent, String xmlContent) throws IOException, TransformerException {
        InputStream xslStream = new ByteArrayInputStream(xslContent.getBytes("utf-8"));
        InputStream xmlStream = new ByteArrayInputStream(xmlContent.getBytes("utf-8"));
        try {
            String result = _transform(xslStream, xmlStream);
            return result;
        } finally {
            xslStream.close();
            xmlStream.close();
        }
    }
}

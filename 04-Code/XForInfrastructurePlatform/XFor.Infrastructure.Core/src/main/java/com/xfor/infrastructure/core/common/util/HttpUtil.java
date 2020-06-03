package com.xfor.infrastructure.core.common.util;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HttpUtil {

    /**
     * POST请求
     * @param url				请求地址
     * @param socketTimeout		响应超时时间，根据业务而定，单位毫秒;
     * 							如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用
     * @param param		请求参数map集合
     * @return
     */
    public static String _post(String url, int socketTimeout, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)						// 设置连接超时时间,单位毫秒。
                    .setConnectionRequestTimeout(1000)  			// 从连接池获取到连接的超时,单位毫秒。
                    .setSocketTimeout(socketTimeout).build();    	// 请求获取数据的超时时间,单位毫秒; 如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用。
            httpPost.setConfig(requestConfig);

            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                System.out.println("响应超时！！！");
            }
        } finally {
            // 释放资源
            try {
                if (null != httpClient) {
                    httpClient.close();
                }
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return resultString;
    }

    /**
     * POST请求（带json参数）
     * @param url					请求地址
     * @param socketTimeout		响应超时时间，根据业务而定，单位毫秒;
     * 							如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用
     * @param jsonParam	json参数
     * @return
     */
    public static String _postJson(String url, int socketTimeout, String jsonParam) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)						// 设置连接超时时间,单位毫秒。
                    .setConnectionRequestTimeout(1000)  			// 从连接池获取到连接的超时,单位毫秒。
                    .setSocketTimeout(socketTimeout).build();    	// 请求获取数据的超时时间,单位毫秒; 如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用。
            httpPost.setConfig(requestConfig);

            // 创建请求内容
            StringEntity entity = new StringEntity(jsonParam, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);

            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                System.out.println("响应超时！！！");
            }
        } finally {
            // 释放资源
            try {
                if (null != httpClient) {
                    httpClient.close();
                }
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return resultString;
    }

    /**
     * 需要设置代理POST请求（带json参数）
     * @param proxyIp	代理IP
     * @param port		端口号
     * @param tcp		协议（例：http、https）
     * @param url		请求地址
     * @param socketTimeout		响应超时时间，根据业务而定，单位毫秒;
     * 							如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用
     * @param jsonParam	json参数
     * @return
     */
    public static String _proxyPostJson(String proxyIp,int port,String tcp, String url,int socketTimeout, String jsonParam) {
        //设置代理IP、端口、协议
        HttpHost proxy = new HttpHost(proxyIp, port, tcp);

        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom().setProxy(proxy).build();

        //实例化CloseableHttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)						// 设置连接超时时间,单位毫秒。
                    .setConnectionRequestTimeout(1000)  			// 从连接池获取到连接的超时,单位毫秒。
                    .setSocketTimeout(socketTimeout).build();    	// 请求获取数据的超时时间,单位毫秒; 如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用。
            httpPost.setConfig(requestConfig);

            // 创建请求内容
            StringEntity entity = new StringEntity(jsonParam, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);

            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                System.out.println("响应超时！！！");
            }
        } finally {
            // 释放资源
            try {
                if (null != httpClient) {
                    httpClient.close();
                }
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return resultString;
    }

    /**
     * 需要设置代理的 POST请求
     * @param proxyIp	代理IP
     * @param port		端口号
     * @param tcp		协议（例：http、https）
     * @param url		请求地址
     * @param socketTimeout		响应超时时间，根据业务而定，单位毫秒;
     * 							如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用
     * @param param		请求参数map集合
     * @return
     */
    public static String _proxyPost(String proxyIp,int port,String tcp, String url, int socketTimeout, Map<String, String> param) {

        //设置代理IP、端口、协议
        HttpHost proxy = new HttpHost(proxyIp, port, tcp);

        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom().setProxy(proxy).build();

        //实例化CloseableHttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)						// 设置连接超时时间,单位毫秒。
                    .setConnectionRequestTimeout(1000)				// 从连接池获取到连接的超时,单位毫秒。
                    .setSocketTimeout(socketTimeout).build();    	// 请求获取数据的超时时间,单位毫秒; 如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用。
            httpPost.setConfig(requestConfig);

            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException) {
                System.out.println("响应超时！！！");
            }
        } finally {
            // 释放资源
            try {
                if (null != httpClient) {
                    httpClient.close();
                }
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return resultString;
    }

    public static String _post(String url, MultipartEntity entity){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            //创建Post请求
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)						// 设置连接超时时间,单位毫秒。
                    .setConnectionRequestTimeout(1000)  			// 从连接池获取到连接的超时,单位毫秒。
                    .setSocketTimeout(30000).build();    	// 请求获取数据的超时时间,单位毫秒; 如果访问一个接口,多少时间内无法返回数据,就直接放弃此次调用。
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(entity);
            //发送Post请求
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new Exception(response.toString());
            }
            //
            HttpEntity resEntity = response.getEntity();
            result = EntityUtils.toString(resEntity, "utf-8");
            //resultString = EntityUtils.toString(resEntity, "utf-8");
            EntityUtils.consume(resEntity);
            return result;

//                System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据
//                System.out.println(resEntity.getContent());
//                JSONObject json = new JSONObject(EntityUtils.toString(resEntity).toString());
//                System.out.println(json.getString("returnResult"));
//                System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据
//                System.out.println(resEntity.getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // 释放资源
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //
        return result;
    }

}
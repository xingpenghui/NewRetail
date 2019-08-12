package com.feri.shop.newretail.common.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *@Author feri
 *@Date Created in 2019/7/9 15:00
 */
public class Http_Util {

    //基于HttpClient 实现的get 请求 获取响应字符串
    public static String getStr(String url){
        //1、创建客户端对象
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        //2、创建请求方式
        HttpGet httpGet=new HttpGet(url);
        try {
            //3、发起请求
            HttpResponse httpResponse=httpClient.execute(httpGet);
            //4、验证响应是否成功
            if(httpResponse.getStatusLine().getStatusCode()==200){
                //5、获取响应结果
                return EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private static final int  CONNECT_TIMEOUT = 5000; // in milliseconds
    private final static String DEFAULT_ENCODING = "UTF-8";
    public static String postData(String urlStr, String data){
        return postData(urlStr, data, null);
    }
    public static String postData(String urlStr, String data, String contentType){
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(CONNECT_TIMEOUT);
            if(contentType != null){
                conn.setRequestProperty("content-type",contentType);
            }
            OutputStreamWriter writer = new
                    OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);
            if(data == null) {
                data = "";
            }
            writer.write(data);
            writer.flush();
            writer.close();
            reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            return sb.toString();
        } catch (IOException e) {
            System.err.println("Error connecting to " + urlStr + ": " +
                    e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }

}

package com.xiedang.www.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class HttpRequestUtil {

    private Logger log = LoggerFactory.getLogger(getClass());
    private int connectTimeout = 20000;
    private CloseableHttpClient httpClient = HttpClients.custom().build();

    public <T> T sendRequest(String url, Map<String, String> requestHeader, Map<String, Object> requestParams, Class<T> clazz) {
        T response = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout)
                    .setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
            httpPost.setConfig(requestConfig);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            for (Map.Entry<String, String> entry : requestHeader.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            String jsonStr = JSONObject.toJSONString(requestParams);
            StringEntity se = new StringEntity(jsonStr);
            se.setContentType("text/json");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(se);
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
                HttpEntity entity = httpResponse.getEntity();
                try {
                    if (null != entity) {
                        response = JSON.parseObject(EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8), clazz);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            }
            System.out.println("HttpClient request url: " + url);
            System.out.println("HttpClient request param: " + JSON.toJSONString(requestParams));
            System.out.println("HttpClient Class: " + clazz.getName());
            System.out.println("HttpClient response: " + JSON.toJSONString(response));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return response;
    }


    public <T> T sendGetRequest(String url, Map<String, Object> params, Class<T> clazz) {
        log.info("Http Request Url: " + url);
        if (null != params) {
            log.info("Http Request params: " + JSON.toJSONString(params));
        }
        T response = null;
        url = jointParams(url, params);
        HttpGet request = new HttpGet(url);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout)
                .setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
        request.setConfig(requestConfig);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(request);
            HttpEntity entity = httpResponse.getEntity();
            try {
                if (null != entity) {
                    response =  JSON.parseObject(EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8), clazz);
                }
            } finally {
                if (entity != null) {
                    entity.getContent().close();
                }
            }
            log.info("Http Response from '" + url + "' is :" + JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            request.releaseConnection();
        }
        return response;
    }

    private String jointParams(String url, Map<String, Object> params) {
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("url不能为空");
        }
        url += "?";
        if (null != params && params.size() > 0) {
            Set<String> keySet = params.keySet();
            StringBuilder urlBuilder = new StringBuilder(url);
            for (String key : keySet) {
                urlBuilder.append(key).append("=").append(params.get(key)).append("&");
            }
            url = urlBuilder.toString();
        }
        return url;
    }
}

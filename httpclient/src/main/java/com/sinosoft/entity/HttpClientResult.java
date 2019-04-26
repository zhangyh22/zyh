package com.sinosoft.entity;

import java.io.Serializable;

public class HttpClientResult implements Serializable {
    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(int scInternalServerError) {
    }

    public HttpClientResult(int statusCode, String content) {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

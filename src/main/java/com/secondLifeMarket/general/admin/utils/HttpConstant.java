package com.secondLifeMarket.general.admin.utils;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 20:03 2018/7/30
 * @Modified By ：
 */
public enum HttpConstant {
    DEFAULT_CHARSET("UTF-8"),
    CHARSET(DEFAULT_CHARSET.value),
    ACCEPT("accept","*/*"),
    CONTENT_TYPE("content-type", "application/x-www-form-urlencoded"),
    USER_AGENT("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)"),
    CONNECTION("connection","Keep-Alive");


    private String value;
    private String key;
    HttpConstant(String value){
        this.setValue(value);
    }
    HttpConstant(String key,String value){
        this.setKey(key);
        this.setValue(value);
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    }

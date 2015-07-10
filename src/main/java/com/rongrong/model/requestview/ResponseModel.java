package com.rongrong.model.requestview;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * 返回前端序列化成JSON的Model
 */
public class ResponseModel {

    private Integer httpCode = 200;
    private String code = "0200";
    private String mark = "empty";
    private Object o;
    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "httpCode=" + httpCode +
                ", code='" + code + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}

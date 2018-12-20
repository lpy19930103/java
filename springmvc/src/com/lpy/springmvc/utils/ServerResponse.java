package com.lpy.springmvc.utils;

public class ServerResponse<T> {
    private T dto;
    private int code;
    private String msg;

    public ServerResponse() {
    }
    public ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ServerResponse(T dto, int code, String msg) {
        this.dto = dto;
        this.code = code;
        this.msg = msg;
    }



    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

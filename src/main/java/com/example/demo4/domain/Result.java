package com.example.demo4.domain;

public class Result {
    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCode() {

        return code;
    }

    public String getData() {
        return data;
    }

    private String data;
}

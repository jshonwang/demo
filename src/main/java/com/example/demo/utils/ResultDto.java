package com.example.demo.utils;


import java.io.Serializable;

public class ResultDto<T> implements Serializable {
    public String code;
    public String message;
    private  T Data;
    public int pageNum;
    public int pageSize;
    public Long count;
    public int toalPageNum;

    public ResultDto(String code,String message,T data){
        this.code = code;
        this.message = message;
        this.Data = data;

    }

    public ResultDto(){}
    public ResultDto SUCCESS(T data){
        return new ResultDto(CodeSys.SUCCESS,CodeSys.SUCCESSMESSAGE,data);
    }

    public ResultDto FAIL(T data){
        return new ResultDto(CodeSys.FAIL,CodeSys.FAILMESSAGE,data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public ResultDto setPageNumIs(int pageNum) {
        this.setPageNum(pageNum);
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getToalPageNum() {
        return toalPageNum;
    }

    public void setToalPageNum(int toalPageNum) {
        this.toalPageNum = toalPageNum;
    }
}

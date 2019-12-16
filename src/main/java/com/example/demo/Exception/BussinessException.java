package com.example.demo.Exception;

import com.example.demo.utils.ResultDto;

public class BussinessException extends  RuntimeException {

    private ResultDto resultDto;

    public ResultDto getResultDto() {
        return resultDto;
    }

    public void setResultDto(ResultDto resultDto) {
        this.resultDto = resultDto;
    }

    public BussinessException() {
        super();
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinessException(Throwable cause) {
        super(cause);
    }



}

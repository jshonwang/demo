package com.example.demo.handler;

import com.example.demo.Exception.BussinessException;
import com.example.demo.utils.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试统一针对抛出的自定义异常返回给前端自定义的内容  针对非系统异常
 * 而是业务等异常能够具体的返回报错的内容
 */
@ControllerAdvice
public class ExceptionHandlerDemo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = BussinessException.class)
    public ResultDto exceptionHandler(Exception e) {
        if (e instanceof BussinessException) {
            logger.info("业务异常");
            return ((BussinessException) e).getResultDto();
        }
        e.getStackTrace();
        return null;
    }
}

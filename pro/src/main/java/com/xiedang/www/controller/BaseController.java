package com.xiedang.www.controller;

import com.xiedang.www.utils.common.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:29
 */
@ControllerAdvice
public class BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandle(Exception e) {
        CommonResult<Integer> result=new CommonResult<>(CommonResult.FAILURE_CODE);
        result.setMessage(e.getMessage());
        log.error("服务器异常，错误{}",e);
        return result;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Object httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        CommonResult<Integer> result=new CommonResult<>(CommonResult.FAILURE_CODE);
        result.setMessage(e.getMessage());
        log.error("服务器异常，错误{}",e);
        return result;
    }
}

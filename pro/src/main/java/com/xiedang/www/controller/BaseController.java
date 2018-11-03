package com.xiedang.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    public Object exceptionHandle(Exception e) {
        e.printStackTrace();
        log.error("服务器异常，{}",e);
        return null;
    }
}

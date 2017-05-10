package com.wentjiang.study.spring.controller;

import com.wentjiang.study.spring.bean.ResponseResult;
import com.wentjiang.study.spring.bean.ResponseType;
import com.wentjiang.study.spring.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangwentao on 2017/5/10 16:41.
 */
@ControllerAdvice
@Slf4j
public class SimpleExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult commonExceptionHandler(Exception e) {
        SystemException se;
        if (e instanceof SystemException) {
            se = (SystemException) e;
        } else if (e instanceof BindException) {
            se = new SystemException(ResponseType.PARAM_ERROR);
        } else {
            log.error("request error:", e);
            se = new SystemException(ResponseType.SYSTEM_ERROR);
        }
        return se.toJson();
    }

}

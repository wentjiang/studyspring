package com.wentjiang.study.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiangwentao on 2017/9/20 17:48.
 */
@Slf4j
@Controller
@RequestMapping("local")
public class LocalController{

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("")
    public String local(){

        String message = null;
//        message = applicationContext.get
        log.info("message:" + message);

        return "local";
    }
}

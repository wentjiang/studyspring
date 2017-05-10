package com.wentjiang.study.spring.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangwentao on 2017/5/10 10:23.
 */
@Controller
@EnableAutoConfiguration
public class IndexController {


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}

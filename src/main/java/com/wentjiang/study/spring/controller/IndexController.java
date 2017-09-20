package com.wentjiang.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangwentao on 2017/9/20 16:19.
 */
@Controller
@RequestMapping("")
public class IndexController {

    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "ok";
    }

    @RequestMapping("/404")
    public String page404(){
        return "common/404";
    }

    @RequestMapping("/500")
    public String page500(){
        return "common/500";
    }

}

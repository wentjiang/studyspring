package com.wentjiang.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ThemeResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiangwentao on 2017/9/20 15:08.
 */
@Controller
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeResolver themeResolver;

    @RequestMapping("")
    public String theme(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(defaultValue = "red", required = false) String theme){
        themeResolver.setThemeName(request, response, theme);
        return "theme";
    }
}

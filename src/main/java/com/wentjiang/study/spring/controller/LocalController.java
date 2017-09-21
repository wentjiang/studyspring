package com.wentjiang.study.spring.controller;

import com.wentjiang.study.spring.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiangwentao on 2017/9/20 17:48.
 */
@Slf4j
@Controller
@RequestMapping("local")
public class LocalController {

    @RequestMapping("")
    public String local() {
        String message1 = SpringUtil.getI18nMessage("message.args",new Object[]{"1","2"});
        String message2 = SpringUtil.getI18nMessage("message.local");

        log.info("message1:" + message1);
        log.info("message2:" + message2);
        return "local";
    }
}

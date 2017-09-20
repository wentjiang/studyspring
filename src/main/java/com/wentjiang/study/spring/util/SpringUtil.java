package com.wentjiang.study.spring.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by wentj on 2017/9/20.
 */
public class SpringUtil {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    public static ServletContext getServletContext() {
        return getHttpSession().getServletContext();
    }

    public static ApplicationContext getApplicationContext() {
        return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    public static Locale getRequestLocale() {
        return RequestContextUtils.getLocale(getHttpServletRequest());
    }

    public static String getI18nMessage(String code, Object[] args, Locale locale) {
        ApplicationContext applicationContext = getApplicationContext();
        return applicationContext.getMessage(code, args, locale);
    }

    public static String getI18nMessage(String code, Locale locale) {
        return getI18nMessage(code, null, locale);
    }

    public static String getI18nMessage(String code) {
        return getI18nMessage(code, getRequestLocale());
    }

}

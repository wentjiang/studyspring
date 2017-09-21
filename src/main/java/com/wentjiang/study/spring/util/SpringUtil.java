package com.wentjiang.study.spring.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;
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

    public static String getI18nMessage(String code) {
        RequestContext requestContext = new RequestContext(getHttpServletRequest());
        return getI18nMessage(code,null);
    }

    public static String getI18nMessage(String code, Object[] args) {
        RequestContext requestContext = new RequestContext(getHttpServletRequest());
        return requestContext.getMessage(code, args);
    }

}

package com.wentjiang.study.spring.bean;

/**
 * Created by jiangwentao on 2017/5/10 16:32.
 */
public enum ResponseType {
    SUCCESS(0, "成功"),
    params_error(1, "参数错误"),
    NEED_UPDATE(4, "需要更新"),

    REQUEST_FORBID(403, "403禁止访问"),
    NOT_FOUND(404, "找不到"),

    PARAM_ERROR(10001, "参数错误: {0}"),
    SIGN_ERROR(10002, "签名错误"),
    PARAM_MISS(10003, "缺少参数: {0}"),

    REQUEST_FAILED(20001, "请求失败: {0}"),
    SERVER_CONNECT_FAILED(20002, "服务器网络通信失败"),
    RESPONSE_ERROR(20003, "{0}"),

    TOKEN_INVALID(30001, "TOKEN无效"),
    TOKEN_EXPIRED(30002, "TOKEN过期"),

    APP_INVALID(40001, "APP无效"),

    SYSTEM_ERROR(90001, "系统内部错误");

    private int code;

    private String message;

    ResponseType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

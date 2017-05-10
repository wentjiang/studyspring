package com.wentjiang.study.spring.exception;

import com.wentjiang.study.spring.bean.ResponseResult;
import com.wentjiang.study.spring.bean.ResponseType;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jiangwentao on 2017/5/10 16:29.
 */
public class SystemException extends RuntimeException {

    @Getter
    private int code;

    @Setter
    @Getter
    private Object data;

    public SystemException(int code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(ResponseType type) {
        super(type.getMessage());
        this.code = type.getCode();
    }

    public ResponseResult toJson() {
        return new ResponseResult(code, getMessage(), data);
    }
}

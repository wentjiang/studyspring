package com.wentjiang.study.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiangwentao on 2017/5/10 16:50.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<E> extends BaseObject {

    private static final long serialVersionUID = 137923803593832313L;
    private int code;
    private String message;
    private E result;

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(int code, E result) {
        this.code = code;
        this.result = result;
    }
}

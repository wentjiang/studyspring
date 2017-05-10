package com.wentjiang.study.spring.bean;

/**
 * Created by jiangwentao on 2017/5/10 17:11.
 */
public class ResponseWrapper {
    public static ResponseResult responseResult(ResponseType responseType) {
        ResponseResult res = new ResponseResult();
        res.setCode(responseType.getCode());
        res.setMessage(responseType.getMessage());
        return res;
    }

    public static <T> ResponseResult<T> responseResult(T result) {
        return responseResult(ResponseType.SUCCESS, result);
    }

    public static <T> ResponseResult<T> responseResult(ResponseType responseType, T result) {
        ResponseResult<T> res = new ResponseResult<>();
        res.setCode(responseType.getCode());
        res.setMessage(responseType.getMessage());
        res.setResult(result);
        return res;
    }
}

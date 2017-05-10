package com.wentjiang.study.spring.service;

import com.wentjiang.study.spring.bean.form.CustomerAddForm;
import com.wentjiang.study.spring.bean.form.CustomerUpdateForm;
import com.wentjiang.study.spring.bean.vo.CustomerVo;

/**
 * Created by jiangwentao on 2017/5/10 16:23.
 */
public interface CustomerService {

    CustomerVo save(CustomerAddForm customerAddForm);

    CustomerVo get(long id);

    CustomerVo update(CustomerUpdateForm customerUpdateForm);

    void delete(long id);
}

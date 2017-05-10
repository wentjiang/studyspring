package com.wentjiang.study.spring.bean.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by jiangwentao on 2017/5/10 16:16.
 */
@Data
public class CustomerAddForm {
    @NotNull(message = "姓氏不能为空")
    private String firstName;
    @NotNull(message = "名字不能为空")
    private String lastName;
}

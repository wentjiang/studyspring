package com.wentjiang.study.spring.bean.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by jiangwentao on 2017/5/10 17:39.
 */
@Data
public class CustomerUpdateForm {

    @NotNull(message = "id不能为空")
    private long id;

    @NotNull(message = "姓氏不能为空")
    private String firstName;

    @NotNull(message = "名字不能为空")
    private String lastName;
}

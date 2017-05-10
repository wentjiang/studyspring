package com.wentjiang.study.spring.controller;

import com.wentjiang.study.spring.bean.ResponseResult;
import com.wentjiang.study.spring.bean.ResponseType;
import com.wentjiang.study.spring.bean.ResponseWrapper;
import com.wentjiang.study.spring.bean.form.CustomerAddForm;
import com.wentjiang.study.spring.bean.form.CustomerUpdateForm;
import com.wentjiang.study.spring.bean.vo.CustomerVo;
import com.wentjiang.study.spring.exception.SystemException;
import com.wentjiang.study.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jiangwentao on 2017/5/10 16:12.
 */
@RestController
@RequestMapping("")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseResult<CustomerVo> postCustomer(@Valid CustomerAddForm customerAddForm,
                                                   BindingResult bindingResult) {
        checkFormParams(bindingResult);
        CustomerVo customerVo = customerService.save(customerAddForm);
        return ResponseWrapper.responseResult(customerVo);
    }

    @GetMapping("/customer/{id}")
    public ResponseResult<CustomerVo> getCustomer(@PathVariable long id) {
        CustomerVo customerVo = customerService.get(id);
        return ResponseWrapper.responseResult(customerVo);
    }

    @PutMapping("/customer")
    public ResponseResult<CustomerVo> putCustomer(@Valid CustomerUpdateForm customerUpdateForm,
                                                  BindingResult bindingResult) {
        checkFormParams(bindingResult);
        CustomerVo customerVo = customerService.update(customerUpdateForm);
        return ResponseWrapper.responseResult(customerVo);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseResult deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
        return ResponseWrapper.responseResult(ResponseType.SUCCESS);
    }


    private void checkFormParams(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            throw new SystemException(ResponseType.params_error.getCode(), errorMessage);
        }
    }

}

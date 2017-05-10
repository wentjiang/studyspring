package com.wentjiang.study.spring.service.impl;

import com.wentjiang.study.spring.bean.ResponseType;
import com.wentjiang.study.spring.bean.form.CustomerAddForm;
import com.wentjiang.study.spring.bean.form.CustomerUpdateForm;
import com.wentjiang.study.spring.bean.vo.CustomerVo;
import com.wentjiang.study.spring.dao.CustomerRepository;
import com.wentjiang.study.spring.entity.Customer;
import com.wentjiang.study.spring.exception.SystemException;
import com.wentjiang.study.spring.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangwentao on 2017/5/10 16:24.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerVo save(CustomerAddForm customerAddForm) {
        Customer customer = addForm2Po(customerAddForm);
        customer = customerRepository.save(customer);
        return this.po2Vo(customer);
    }

    @Override
    public CustomerVo get(long id) {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw new SystemException(ResponseType.NOT_FOUND);
        }
        return this.po2Vo(customer);
    }

    @Override
    public CustomerVo update(CustomerUpdateForm customerUpdateForm) {
        Customer customer = updateForm2Po(customerUpdateForm);
        customer = customerRepository.update(customer);
        return po2Vo(customer);
    }

    @Override
    public void delete(long id) {
        if (!customerRepository.exists(id)) {
            throw new SystemException(ResponseType.NOT_FOUND);
        }
        customerRepository.delete(id);
    }

    private Customer addForm2Po(CustomerAddForm customerAddForm) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerAddForm, customer);
        return customer;
    }

    private CustomerVo po2Vo(Customer customer) {
        CustomerVo customerVo = new CustomerVo();
        customerVo.setName(customer.getFirstName() + " " + customer.getLastName());
        return customerVo;
    }

    private Customer updateForm2Po(CustomerUpdateForm customerUpdateForm) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerUpdateForm, customer);
        return customer;
    }

}

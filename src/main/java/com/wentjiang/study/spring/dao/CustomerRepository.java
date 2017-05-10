package com.wentjiang.study.spring.dao;

import com.wentjiang.study.spring.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jiangwentao on 2017/5/10 14:54.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    Customer update(Customer customer);

}

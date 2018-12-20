package com.lpy.springmvc.service;

import com.lpy.springmvc.pojo.Customer;
import com.lpy.springmvc.pojo.QueryVo;
import com.lpy.springmvc.utils.Page;

public interface CustomerService {

    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    void updateCustomerById(Customer customer);

    void deleteCustomerById(Long id);

    void addCustomer(Customer customer);
}

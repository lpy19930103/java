package com.lpy.springmvc.mapper;


import com.lpy.springmvc.pojo.QueryVo;

import java.util.List;

import com.lpy.springmvc.pojo.Customer;

public interface CustomerMapper {
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    int queryCountByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    void updateCustomerById(Customer customer);

    void deleteCustomerById(Long id);

    void addCustomer(Customer customer);

}

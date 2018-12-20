package com.lpy.springmvc.service.impl;

import com.lpy.springmvc.pojo.QueryVo;
import com.lpy.springmvc.utils.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lpy.springmvc.pojo.Customer;
import com.lpy.springmvc.mapper.CustomerMapper;
import com.lpy.springmvc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) *queryVo.getRows());
        List<Customer> customers = customerMapper.queryCustomerByQueryVo(queryVo);
        int total = customerMapper.queryCountByQueryVo(queryVo);
        Page<Customer> customerPage = new Page<>(total, queryVo.getPage(), queryVo.getRows(), customers);
        return customerPage;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerMapper.queryCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMapper.deleteCustomerById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }


}

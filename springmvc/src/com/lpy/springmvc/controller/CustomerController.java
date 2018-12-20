package com.lpy.springmvc.controller;

import com.lpy.springmvc.pojo.BaseDict;
import com.lpy.springmvc.pojo.Customer;
import com.lpy.springmvc.pojo.QueryVo;
import com.lpy.springmvc.service.BaseDictService;
import com.lpy.springmvc.service.CustomerService;
import com.lpy.springmvc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    @Value("${CUSTOMER_FROM_TYPE}")
    private String CUSTOMER_FROM_TYPE;
    @Value("${CUSTOMER_INDUSTYR_TYPE}")
    private String CUSTOMER_INDUSTYR_TYPE;
    @Value("${CUSTOMER_LEVEL_TYPE}")
    private String CUSTOMER_LEVEL_TYPE;

    @RequestMapping("list")
    private String queryCustomerList(QueryVo queryVo, Model model) {
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTYR_TYPE);
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        Page<Customer> customerPage = customerService.queryCustomerByQueryVo(queryVo);
        model.addAttribute("page", customerPage);
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        return "customer";
    }

    @RequestMapping("edit")
    @ResponseBody
    private Customer queryCustomerById(Long id) {
        return customerService.queryCustomerById(id);
    }

    @RequestMapping("update")
    @ResponseBody
    private String updateCustomerById(Customer customer) {
        customerService.updateCustomerById(customer);
        return "OK";
    }

    @RequestMapping("delete")
    @ResponseBody
    private String deleteCustomerById(Long id) {
        customerService.deleteCustomerById(id);
        return "OK";
    }

    @RequestMapping("add")
    @ResponseBody
    private String deleteCustomerById(Customer customer) {
        customerService.addCustomer(customer);
        return "OK";
    }
}

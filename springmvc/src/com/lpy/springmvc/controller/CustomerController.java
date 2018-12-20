package com.lpy.springmvc.controller;

import com.lpy.springmvc.pojo.BaseDict;
import com.lpy.springmvc.pojo.Customer;
import com.lpy.springmvc.pojo.QueryVo;
import com.lpy.springmvc.service.BaseDictService;
import com.lpy.springmvc.service.CustomerService;
import com.lpy.springmvc.utils.Page;
import com.lpy.springmvc.utils.ServerResponse;
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
    private ServerResponse updateCustomerById(Customer customer) {
        if (customer.isNull()) {
            return new ServerResponse<>(0, "参数异常");
        }
        customerService.updateCustomerById(customer);
        return new ServerResponse<>(1, "更新成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    private ServerResponse deleteCustomerById(Long id) {
        customerService.deleteCustomerById(id);
        return new ServerResponse<>(1, "删除成功");
    }

    @RequestMapping("add")
    @ResponseBody
    private ServerResponse deleteCustomerById(Customer customer) {
        if (customer.isNull()) {
            return new ServerResponse<>(0, "参数异常");
        }
        customerService.addCustomer(customer);
        return new ServerResponse<>(1, "添加成功");

    }
}

package com.lpy.springmvc.controller;

import com.lpy.springmvc.pojo.BaseDict;
import com.lpy.springmvc.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;

    @RequestMapping("list")
    private String queryCustomerList(Model model) {
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode("002");
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        return "customer";
    }
}

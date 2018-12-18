package com.lpy.springmvc.controller;

import com.lpy.springmvc.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ItemController {
    @RequestMapping("/itemList")
    public ModelAndView itemList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Item> items = Arrays.asList(new Item(0, "冰箱1", 10.00, new Date(), "哈哈哈哈1"),
                new Item(1, "冰箱2", 10.00, new Date(), "哈哈哈哈2"),
                new Item(2, "冰箱3", 10.00, new Date(), "哈哈哈哈3"),
                new Item(3, "冰箱4", 10.00, new Date(), "哈哈哈哈4"));
        modelAndView.addObject("itemList",items);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }
}


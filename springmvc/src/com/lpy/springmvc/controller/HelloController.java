package com.lpy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(){
        System.out.println("hello springmvc");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","hello springmvc");
        modelAndView.setViewName("/WEB-INF/jsp/hello.jsp");
        return modelAndView;
    }
}

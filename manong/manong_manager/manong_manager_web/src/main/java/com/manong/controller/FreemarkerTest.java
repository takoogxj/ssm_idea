package com.manong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerTest {

    @RequestMapping("/hello")
    public String sayHello(Model model){

        model.addAttribute("name","guxiaojie");

        return "hello";
    }

}

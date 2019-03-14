package com.manong.controller;

import com.manong.pojo.TbUser;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/{userid}")
    @ResponseBody
    public TbUser showUserInfo(@PathVariable(name = "userid" ,required = false) Integer id){

        TbUser user= userService.getUserById(id);

        return user;
    }

}

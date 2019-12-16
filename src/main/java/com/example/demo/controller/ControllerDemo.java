package com.example.demo.controller;

import com.example.demo.service.impl.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerDemo {
    @Autowired
    UserManagerService userManagerService;


    public void demo(){
        userManagerService.getUserDetailByUserName("123");
    }
}

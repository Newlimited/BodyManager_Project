package com.groupd.bodymanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController{
    
    public UserController(UserService userService){
        
    }

} 
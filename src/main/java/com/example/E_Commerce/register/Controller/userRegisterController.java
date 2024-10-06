package com.example.E_Commerce.register.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.register.Entity.register.userRegister;
import com.example.E_Commerce.register.Service.RegisterService.userRegisterService;

@RestController
@RequestMapping("/api")
public class userRegisterController {

    @Autowired
    private userRegisterService userRegisterService;

    @GetMapping("/user")
    public List<userRegister>getAllUser(){
        List<userRegister> users = userRegisterService.getAllUser();
        return users;
    }

    @PostMapping("/user")
    public userRegister createUser(@RequestBody userRegister userData) {
        userRegister user = userRegisterService.saveUser(userData);
        return user;
    }

}

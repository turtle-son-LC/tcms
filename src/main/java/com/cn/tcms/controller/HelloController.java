package com.cn.tcms.controller;

import com.cn.tcms.domain.User;
import com.cn.tcms.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String getName() {
        return "name";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.queryAllUsers();
        return users;
    }
}

package org.edu.tcms.controller;

import jakarta.annotation.Resource;
import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.domain.User;
import org.edu.tcms.domain.UserRegisterRequest;
import org.edu.tcms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Resource
    private UserService userService;

    @GetMapping("/all")
    public ResultResponse getUsers(@RequestParam(required = false) String account) {
        List<User> users = userService.queryAllUsers(account);
        return ResultResponse.success(users);
    }

    @PostMapping("/register")
    public ResultResponse registerUser(@RequestBody UserRegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }

    @PostMapping("/login")
    public ResultResponse loginUser(@RequestBody UserRegisterRequest registerRequest) {
        return userService.loginUser(registerRequest);
    }
}

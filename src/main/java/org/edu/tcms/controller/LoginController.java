package org.edu.tcms.controller;

import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.domain.User;
import org.edu.tcms.domain.UserRegisterRequest;
import org.edu.tcms.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tcms/user")
public class LoginController {
    @Resource
    private UserService userService;

    @GetMapping("/all")
    public ResultResponse getUsers(@RequestParam(required = false) String account) {
        System.out.println("getUsers");
        List<User> users = userService.queryAllUsers(account);
        return ResultResponse.success(users);
    }

    @PostMapping("/register")
    public ResultResponse registerUser(@RequestBody UserRegisterRequest registerRequest) {
        System.out.println("registerUser");
        return userService.registerUser(registerRequest);
    }

    @PostMapping("/login")
    public ResultResponse loginUser(@RequestBody UserRegisterRequest registerRequest) {
        System.out.println("loginUser");
        return userService.loginUser(registerRequest);
    }
}

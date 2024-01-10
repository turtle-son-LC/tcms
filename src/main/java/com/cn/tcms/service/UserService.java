package com.cn.tcms.service;

import com.cn.tcms.domain.User;
import com.cn.tcms.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> queryAllUsers() {
        return userMapper.queryAllUser();
    }
}

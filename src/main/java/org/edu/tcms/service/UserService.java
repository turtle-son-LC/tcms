package org.edu.tcms.service;

import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.domain.User;
import org.edu.tcms.domain.UserRegisterRequest;
import org.edu.tcms.domain.UserResponse;
import org.edu.tcms.mapper.UserMapper;
import org.edu.tcms.utls.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> queryAllUsers(String account) {
        return userMapper.queryAll(account);
    }

    public ResultResponse registerUser(UserRegisterRequest registerRequest) {
        String account = registerRequest.getAccount();
        String password = registerRequest.getPassword();
        String passwordCheck = registerRequest.getPasswordCheck();
        String regex = "[a-zA-Z0-9]+";

        if (StringUtils.hasLength(account)) {
            if (account.length() <= 3 || account.length() > 50) {
                return ResultResponse.badRequest("登录名长度为3~50位.");
            }
            if (!account.matches(regex)) {
                return ResultResponse.badRequest("登录名为英文字母或数字组合.");
            }
        } else {
            return ResultResponse.badRequest("登录名不能为空.");
        }

        if (StringUtils.hasLength(password)) {
            if (password.length() <= 3 || password.length() > 50) {
                return ResultResponse.badRequest("密码长度为3~50位.");
            }
            if (!account.matches(regex)) {
                return ResultResponse.badRequest("密码为英文字母或数字组合.");
            }
        } else {
            return ResultResponse.badRequest("密码不能为空.");
        }

        if (StringUtils.hasLength(passwordCheck)) {
            if (!passwordCheck.equals(password)) {
                return ResultResponse.badRequest("密码不一致.");
            }
        } else {
            return ResultResponse.badRequest("重复密码不能为空.");
        }

        List<User> usersByAccount = userMapper.queryByAccount(account);
        if (!CollectionUtils.isEmpty(usersByAccount)) {
            return ResultResponse.badRequest("账号已被注册，请重新输入.");
        }

        User user = new User();
        user.setUserId(UUIDUtil.getShortUUID());
        user.setAccount(account);
        // todo MD5
        user.setPassword(password);
        user.setDeleted(0);
        user.setCreateTime(System.currentTimeMillis());
        userMapper.createNew(user);

        return ResultResponse.success("账号注册成功");
    }

    public ResultResponse loginUser(UserRegisterRequest registerRequest) {
        String account = registerRequest.getAccount();
        String password = registerRequest.getPassword();
        if (!StringUtils.hasLength(account)) {
            return ResultResponse.badRequest("登录名不能为空.");
        }
        if (!StringUtils.hasLength(password)) {
            return ResultResponse.badRequest("密码不能为空.");
        }
        List<User> users = userMapper.queryByAccount(account);
        if (CollectionUtils.isEmpty(users)) {
            return ResultResponse.badRequest("登录用户不存在.");
        }
        User dbUser = users.get(0);
        if (!password.equals(dbUser.getPassword())) {
            return ResultResponse.badRequest("账号密码不匹配.");
        }

        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(dbUser, response);

        return ResultResponse.success(response);
    }
}

package com.cn.tcms.mapper;

import com.cn.tcms.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryAllUser();
}

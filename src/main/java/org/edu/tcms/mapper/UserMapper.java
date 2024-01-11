package org.edu.tcms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.edu.tcms.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryAll(String account);

    List<User> queryByAccount(String account);

    void createNew(User user);
}

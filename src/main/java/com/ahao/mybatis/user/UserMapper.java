package com.ahao.mybatis.user;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from ahaouser where id=#{id}")
    User findUser(Integer id);

    List<User> findUsers();

    void addUsers(List<User> users);
}

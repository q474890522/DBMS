package com.partner541.database.dao;

import com.partner541.database.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from tbUser where username = #{username}")
    User selectUserByUsername(@Param("username") String username);

    @Insert("insert into tbUser(username, password) values (#{username}, #{password})")
    boolean insertUser(User user);
}

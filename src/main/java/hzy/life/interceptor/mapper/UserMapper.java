package hzy.life.interceptor.mapper;


import hzy.life.interceptor.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int regUser(@Param("username")String username,@Param("password")String password);

    @Select("select* from user where username=#{username}")
    User loadByUsername(String username);

    @Select("select * from user where username=#{username} and password=#{password}")
    User loginUser(@Param("username")String username,@Param("password")String password);

}

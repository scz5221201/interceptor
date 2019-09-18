package hzy.life.interceptor.service;

import hzy.life.interceptor.mapper.UserMapper;
import hzy.life.interceptor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public int regUser(String username, String password){
        if (userMapper.loadByUsername(username)!=null){
            return -1;
        }
        return userMapper.regUser(username,password);
    }

    public User loginUser(User user){
        user = userMapper.loginUser(user.getUsername(),user.getPassword());
        return user;
    }

}

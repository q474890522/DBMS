package com.partner541.database.service;

import com.partner541.database.dao.UserDao;
import com.partner541.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean addUser(User user) {
        return userDao.insertUser(user);
    }

    public User getUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    public Map<String, Object> signUp(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        if(username == null) {
            map.put("msg", "用户名为空，注册失败");
            return map;
        }

        if(password == null) {
            map.put("msg", "密码为空，注册失败");
            return map;
        }

        User user = userDao.selectUserByUsername(username);
        if(user != null) {
            map.put("msg", "用户名已被注册");
            return map;
        }

        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean ifSucc = userDao.insertUser(user);
        if(!ifSucc) {
            map.put("msg", "用户注册失败");
            return map;
        }
        return null;
    }

    public Map<String, Object> signIn(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = userDao.selectUserByUsername(username);

        if(user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }

        if(!user.getUsername().equals(username)) {
            map.put("msg", "用户名错误");
            return map;
        }

        if(!user.getPassword().equals(password)) {
            map.put("msg", "密码错误");
            return map;
        }

        return null;

    }

}

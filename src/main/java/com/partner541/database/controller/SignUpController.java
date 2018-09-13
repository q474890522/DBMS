package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import com.partner541.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignUpController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/signupupdate")
    @ResponseBody
    public Object update(@RequestBody JSONObject params) {
        String username = params.getString("username");
        String password = params.getString("password");

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapCheck = userService.signUp(username, password);
        if(mapCheck == null) {
            map.put("success",true);
            return map;
        } else {
            String errorMsg = mapCheck.get("msg").toString();
            map.put(errorMsg, false);
            return map;
        }
        /*
        * 将新用户写进数据库
        * */
//        Map<String,Object> map = new HashMap<>();
//        map.put("success",true);

//        return map;
    }

    @RequestMapping("/signup")
    public String say() {
        return "SignUp";
    }
}

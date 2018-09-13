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
public class SignInController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/signinupdate")
    @ResponseBody
    public Object siginupdate(@RequestBody JSONObject params) {
        String username = params.getString("username");
        String password = params.getString("password");

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> checkMap = userService.signIn(username, password);

        if(checkMap != null) {
            String checkMsg = checkMap.get("msg").toString();
            map.put(checkMsg, false);
        } else {
            map.put("success", true);
        }
        System.out.println(map);
        return map;
        /*
        * 密码和用户名正确
        * */
//        Map<String,Object> map = new HashMap<>();
//        if (username.equals("2015211439") && password.equals("123")) {
//            map.put("success",true);
//        }
//        else {
//            map.put("success",false);
//        }
//        return map;

    }

    @RequestMapping("/")
    public String say(){
        return "SignIn";
    }
}

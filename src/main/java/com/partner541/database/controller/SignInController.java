package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignInController {
    @RequestMapping("/signin/update")
    @ResponseBody
    public Object siginupdate(@RequestBody JSONObject params) {
        String username = params.getString("username");
        String password = params.getString("password");

        /*
        * 密码和用户名正确
        * */
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/")
    public String say(){
        return "SignIn";
    }
}

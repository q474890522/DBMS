package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class DataController {
    @RequestMapping(path = "/newdata")
    @ResponseBody
    public Object newdata(@RequestBody JSONObject params) {
        System.out.println("fhkjhkwkhkjjkhk");

        Map<String, Object> map = new HashMap<>();
        map.put("success",true);

        return map;
    }

    @RequestMapping(path = "/computedata")
    public String demo() {
        return "ComputeData";
    }

    class person2{
        public String username;
        public String password;

        public person2(String username,String password){
            this.username = username;
            this.password = password;
        }
    }

}

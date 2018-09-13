package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class QueryController {
    @RequestMapping(path = "/cellnewdata")
    @ResponseBody
    public Object cellnewdata(@RequestBody JSONObject params){
        String SECTOR_Id = params.getString("SECTOR_ID");
        System.out.println(SECTOR_Id);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping(path = "/celldata")
    @ResponseBody
    public Object celldata() {
        List<person> list = new LinkedList<>();

        list.add(new person("user1","password1"));
        list.add(new person("user2","password2"));


        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",",");
        map.put("count",list.size());
        map.put("data",list);

        return map;
    }

    @RequestMapping(path = "/kpinewdata")
    @ResponseBody
    public Object kpinewdata(@RequestBody JSONObject params) {
        String kpibegintime = params.getString("KPIbegintime");
        Date kpiendtime   = params.getDate("KPIendtime");

        System.out.println(kpibegintime);
        System.out.println(kpiendtime);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }


    @RequestMapping(path = "/prbnewdata")
    @ResponseBody
    public Object prbnewdata(@RequestBody JSONObject params) {
        String prbbegintime = params.getString("PRBbegintime");
        Date prbendtime = params.getDate("PRBendtime");

        System.out.println(prbbegintime);
        System.out.println(prbendtime);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }


    @RequestMapping("/query")
    public String demo() {
        return "Query";
    }

    class person{
        public String username;
        public String password;

        public person(String username,String password){
            this.username = username;
            this.password = password;
        }
    }
}

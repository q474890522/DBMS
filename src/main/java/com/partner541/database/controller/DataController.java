package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import com.partner541.database.model.C2I3;
import com.partner541.database.service.C2Iservice;
import com.partner541.database.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    C2Iservice c2Iservice;

    public List<C2I3> list = null;
    @RequestMapping(path = "/newdata")
    @ResponseBody
    public void newdata(@RequestBody JSONObject params) {
        double parameter = params.getDouble("parameter");
        System.out.println("dataController");
        System.out.println(parameter);

        System.out.println("计算中");
        list = c2Iservice.re_tri(parameter);
        System.out.println("计算结束");


        if (list != null) {
            System.out.println(list.size());
        }
        else {
            System.out.println("list is empty");
        }
    }

    @RequestMapping(path = "/data")
    @ResponseBody
    public Object data() {
        System.out.println("dataController.table");
        if (list != null) {
            System.out.println(list.size());
        }
        else {
            System.out.println("list is empty");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",",");
        if (list == null){
            map.put("count",0);
        }
        else {
            map.put("count",list.size());
        }
        map.put("data",list);

        return map;
    }

    @RequestMapping(path = "/computedata")
    public String demo(){
        return "ComputeData";
    }

}

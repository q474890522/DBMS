package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExportController {
    @RequestMapping(path = "/exportdata")
    public String exportdata(){
        return "ExportData";
    }

    @RequestMapping(path = "/exportnewdata")
    @ResponseBody
    public void exportnewdata(@RequestBody JSONObject  params){
        String filename = params.getString("filename");
        String path = params.getString("path");
        String whichtable = params.getString("tables");

        System.out.println(filename);
        System.out.println(path);
        System.out.println(whichtable);
    }
}

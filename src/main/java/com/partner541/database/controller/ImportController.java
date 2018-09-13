package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import com.partner541.database.service.CellService;
import com.partner541.database.service.KPIService;
import com.partner541.database.service.PRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImportController {
    @Autowired
    CellService cellService;

    @Autowired
    KPIService kpiService;

    @Autowired
    PRBService prbService;

    @RequestMapping(path = "/importdata")
    public String importdata(){
        return "ImportData";
    }


    public String whichtable;
    @RequestMapping(path = "/willupload")
    @ResponseBody
    public void willupload(@RequestBody JSONObject params){
        whichtable = params.getString("city");
        System.out.println(whichtable);
    }


    @RequestMapping(path = "/upload")
    public void upload(MultipartFile file){
        if (null != file){
            if (whichtable.equals("0")){
                cellService.importTbCell(file);
            }
            else if (whichtable.equals("1")){
                kpiService.importTbKPI(file);
            }
            else if (whichtable.equals("2")){
                prbService.importPRB(file);
            }
        }
    }
}

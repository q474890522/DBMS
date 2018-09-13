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

@Controller
public class ExportController {
    @Autowired
    CellService cellService;

    @Autowired
    KPIService kpiService;

    @Autowired
    PRBService prbService;

    @RequestMapping(path = "/exportdata")
    public String exportdata(){
        return "ExportData";
    }

    @RequestMapping(path = "/exportnewdata")
    @ResponseBody
    public void exportnewdata(@RequestBody JSONObject  params){
        String filename = params.getString("filename") + ".xlsx";
        String path = params.getString("path");
        String whichtable = params.getString("tables");

        System.out.println(filename);
        System.out.println(path);
        System.out.println(whichtable);

        if (whichtable.equals("tbCell")){
            cellService.exportExcel(path,filename);
        }
        else if (whichtable.equals("tbKPI")) {
            kpiService.exportExcel(path,filename);
        }
        else if (whichtable.equals("tbPRB")) {
            prbService.exportExcel(path,filename);
        }
    }

}

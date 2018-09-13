package com.partner541.database.controller;

import com.partner541.database.service.CellService;
import com.partner541.database.service.KPIService;
import com.partner541.database.service.PRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

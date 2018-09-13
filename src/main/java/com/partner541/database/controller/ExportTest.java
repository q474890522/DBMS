package com.partner541.database.controller;

import com.partner541.database.service.CellService;
import com.partner541.database.service.KPIService;
import com.partner541.database.utils.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExportTest {

    @Autowired
    CellService cellService;

    @Autowired
    KPIService kpiService;

    @RequestMapping(path = "/exportCell", method = {RequestMethod.GET})
    @ResponseBody
    public String exportCell (HttpServletRequest request, HttpServletResponse response) {
        cellService.exportExcel("D:\\SQL\\excel", "Cell.xlsx");
        return "1111";
    }

    @RequestMapping(path = "/exportKPI", method = {RequestMethod.GET})
    @ResponseBody
    public String exportKPI () {
        kpiService.exportExcel("D:\\SQL\\excel", "newKPI.xlsx");
        return "1111";
    }

    @RequestMapping(path = "/exportPRB", method = {RequestMethod.GET})
    @ResponseBody
    public String exportPRB () {
        kpiService.exportExcel("D:\\SQL\\excel", "newPRB.xlsx");
        return "1111";
    }
}

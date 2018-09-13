package com.partner541.database.controller;

import com.partner541.database.service.CellService;
import com.partner541.database.service.KPIService;
import com.partner541.database.service.PRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class importTest {
    @Autowired
    CellService cellService;

    @Autowired
    KPIService kpiService;

    @Autowired
    PRBService prbService;

    @RequestMapping(path = {"/importCell"}, method = {RequestMethod.POST})
    @ResponseBody
    public String importCell(@RequestParam("file") MultipartFile file) {
        boolean ifSucc = cellService.importTbCell(file);
        return String.valueOf(ifSucc);
    }

    @RequestMapping(path = {"/importKPI"}, method = {RequestMethod.POST})
    @ResponseBody
    public String importKPI(@RequestParam("file") MultipartFile file) {
        boolean ifSucc = kpiService.importTbKPI(file);
        return String.valueOf(ifSucc);
    }

    @RequestMapping(path = {"/importPRB"}, method = {RequestMethod.POST})
    @ResponseBody
    public String importPRB(@RequestParam("file") MultipartFile file) {
        boolean ifSucc = prbService.importPRB(file);
        return String.valueOf(ifSucc);
    }

    @RequestMapping(path = {"/cleanCell"}, method = {RequestMethod.GET})
    @ResponseBody
    public String cleanCell() {
        int cleanNum = cellService.cleanTbCell();
        return String.format("成功删除%d条数据", cleanNum);
    }

    @RequestMapping(path = {"/cleanKPI"}, method = {RequestMethod.GET})
    @ResponseBody
    public String cleanKPI() {
        int cleanNum = kpiService.cleanTbKPI();
        return String.format("成功删除%d条数据", cleanNum);
    }

    @RequestMapping(path = {"/cleanPRB"}, method = {RequestMethod.GET})
    @ResponseBody
    public String cleanPRB() {
        int cleanNum = prbService.cleanPRB();
        return String.format("成功删除%d条数据", cleanNum);
    }
}

package com.partner541.database.controller;

import com.partner541.database.service.CellService;
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

    @RequestMapping(path = "/exportCell", method = {RequestMethod.GET})
    @ResponseBody
    public String exportCell (HttpServletRequest request, HttpServletResponse response) {
        cellService.exportExcel(response, "D:\\SQL\\excel", "Cell.xlsx");
        return "1111";
    }
}

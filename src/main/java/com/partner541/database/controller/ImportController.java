package com.partner541.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImportController {
    @RequestMapping(path = "/importdata")
    public String importdata(){
        return "ImportData";
    }
}

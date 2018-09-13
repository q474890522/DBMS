package com.partner541.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComputedataController {
    @RequestMapping(path = "/computedata")
    public String demo() {
        return "ComputeData";
    }
}

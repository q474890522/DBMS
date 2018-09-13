package com.partner541.database.controller;

import com.alibaba.fastjson.JSONObject;
import com.partner541.database.model.Cell;
import com.partner541.database.model.PRBpor;
import com.partner541.database.service.CellService;
import com.partner541.database.service.KPIService;
import com.partner541.database.service.PRBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class QueryController {
    @Autowired
    CellService cellService;

    @Autowired
    KPIService kpiService;

    @Autowired
    PRBService prbService;


    public String SECTOR_ID, SECTOR_NAME, ENODEBID, ENODEB_NAME;

    @RequestMapping(path = "/cellnewdata")
    @ResponseBody
    public Object cellnewdata(@RequestBody JSONObject params){
        SECTOR_ID = params.getString("SECTOR_ID");
        SECTOR_NAME = params.getString("SECTOR_NAME");
        ENODEBID = params.getString("ENODEBID");
        ENODEB_NAME = params.getString("ENODEB_NAME");

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping(path = "/celldata")
    @ResponseBody
    public Object celldata() {
        List<Cell> list = null;


        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",",");
        map.put("count",list.size());
        map.put("data",list);

        return map;
    }


    public String NENAME, parameter;
    public Date kpibegintime, kpiendtime;
    @RequestMapping(path = "/kpinewdata")
    @ResponseBody
    public Object kpinewdata(@RequestBody JSONObject params) {
        NENAME = params.getString("NENAME");
        parameter = params.getString("properties");
        kpibegintime = params.getDate("KPIbegintime");
        kpiendtime   = params.getDate("KPIendtime");

        System.out.println(NENAME);
        System.out.println(parameter);
        System.out.println(kpibegintime);
        System.out.println(kpiendtime);

        kpiService.selectRPC_CONN_RESET_RATE();

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }


    @RequestMapping(path = "/prbnewdata")
    @ResponseBody
    public Object prbnewdata(@RequestBody JSONObject params) {
        String NENAME = params.getString("NENAME");
        String properties = params.getString("properties");
        long timesize = params.getLong("timesize");
        Date prbbegintime = params.getDate("PRBbegintime");
        Date prbendtime = params.getDate("PRBendtime");

        System.out.println(timesize);

        //List<PRBpor> list = prbService.getXPRB(NENAME,prbbegintime,prbendtime,timesize,properties);

        List<PRBpor> list = new LinkedList<>();
        PRBpor temp1 = new PRBpor();
        PRBpor temp2 = new PRBpor();
        temp1.setX(8);
        temp2.setX(10);
        temp1.setSTARTTIME(prbbegintime);
        temp2.setSTARTTIME(prbendtime);
        list.add(temp1);
        list.add(temp2);

        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        return map;
    }


    @RequestMapping("/query")
    public String demo() {
        return "Query";
    }

    class person{
        public String username;
        public String password;

        public person(String username,String password){
            this.username = username;
            this.password = password;
        }
    }
}

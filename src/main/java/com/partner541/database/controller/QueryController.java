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


    public List<Cell> alist = null;

    @RequestMapping(path = "/cellnewdata")
    @ResponseBody
    public Object cellnewdata(@RequestBody JSONObject params){
        String SECTOR_ID = params.getString("SECTOR_ID");
        String SECTOR_NAME = params.getString("SECTOR_NAME");
        String ENODEBID = params.getString("ENODEBID");
        String ENODEB_NAME = params.getString("ENODEB_NAME");

        System.out.println(SECTOR_ID +" "+ SECTOR_NAME + " "+ ENODEBID +" "+  ENODEB_NAME + "before");
        try {
            alist = cellService.selectCell(SECTOR_ID,SECTOR_NAME,ENODEBID,ENODEB_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (alist != null) {
            System.out.println(alist.size());
        }
        else {
            System.out.println("alist is empty");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping(path = "/cellresult")
    public String cellresult(){
        return "CellResult";
    }

    @RequestMapping(path = "/celldata")
    @ResponseBody
    public Object celldata() {
        if (alist != null) {
            System.out.println(alist.size());
        }
        else {
            System.out.println("alist is empty");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",",");
        if (alist == null){
            map.put("count",0);
        }
        else {
            map.put("count",alist.size());
        }
        map.put("data",alist);

        return map;
    }


    @RequestMapping(path = "/kpinewdata")
    @ResponseBody
    public Object kpinewdata(@RequestBody JSONObject params) {
        //String NENAME = params.getString("NENAME");
        String parameter = params.getString("properties");
        //Date kpibegintime = params.getDate("KPIbegintime");
        //Date kpiendtime   = params.getDate("KPIendtime");

        //System.out.println(NENAME);
        System.out.println(parameter);
        //System.out.println(kpibegintime);
        //System.out.println(kpiendtime);

        switch (parameter){
            case "0":
                return kpiService.selectRRC_CONNECT_COMPLETE_TIME();
            case "1":
                return kpiService.selectRRC_CONNECT_REQUEST_TIME();
            case "2":
                return kpiService.selectRRC_SET_SUCC_RATE();
            case "3":
                return kpiService.selectERAB_SET_SUCCESS_TIME();
            case "4":
                return kpiService.selectERAB_TRY_CONNECT_TIME();

            case "5":
                return kpiService.selectERAB_SET_SUCCESS_TWO();
            case "6":
                return kpiService.selecteNodeB_TRYGGER_EXCEP_RELE_TIME();
            case "7":
                return kpiService.selectSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME();
            case "8":
                return kpiService.selectERAB_DROP_RATE();
            case "9":
                return kpiService.selectWIRELESS_CONN_RATE();
            case "10":
                return kpiService.selecteNodeB_INIT_S1();
            case "11":
                return kpiService.selectUE_Context_EXCEP_RELE_TIME();
            case "12":
                return kpiService.selectUE_Context_SET_SUCCESS_TIME();
            case "13":
                return kpiService.selectWIRELESS_DROP_RATE();
            case "14":
                return kpiService.selecteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME();
            case "15":
                return kpiService.selecteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME();
            case "16":
                return kpiService.selecteNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME();
            case "17":
                return kpiService.selecteNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME();
            case "18":
                return kpiService.selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME();
            case "19":
                return kpiService.selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME();
            case "20":
                return kpiService.selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME();
            case "21":
                return kpiService.selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME();
            case "22":
                return kpiService.selecteNB_IN_SWITCH_SUCC_RATE();
            case "23":
                return kpiService.selecteNB_BETWEEN_SWITCH_SUCC_RATE();
            case "24":
                return kpiService.selectSAME_FREQ_SWITCH_SUCC_ZSP();
            case "25":
                return kpiService.selectDIFF_FREQ_SWITCH_SUCC_ZSP();
            case "26":
                return kpiService.selectSWITCH_SUCC_RATE();
            case "27":
                return kpiService.selectSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT();
            case "28":
                return kpiService.selectSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT();
            case "29":
                return kpiService.selectRPC_RESET_REQUEST_TIME();
            case "30":
                return kpiService.selectRPC_CONN_RESET_RATE();
            case "31":
                return kpiService.selectTO_ONE();
            case "32":
                return kpiService.selectTO_TWO();
            case "33":
                return kpiService.selectTO_THREE();
            case "34":
                return kpiService.selectTO_FOUR();
            case "35":
                return kpiService.selecteNB_IN_SWITCH_SUCC_TIME();
            case "36":
                return kpiService.selecteNB_IN_SWITCH_REQUEST_TIME();
                default:break;
        }
        return null;
    }


    @RequestMapping(path = "/prbnewdata")
    @ResponseBody
    public Object prbnewdata(@RequestBody JSONObject params) {
        String NENAME = params.getString("NENAME");
        String properties = params.getString("properties");
        long timesize = params.getLong("timesize");
        Date prbbegintime = params.getDate("PRBbegintime");
        Date prbendtime = params.getDate("PRBendtime");

        System.out.println(NENAME);
        System.out.println(properties);
        System.out.println(timesize);
        System.out.println(prbbegintime);
        System.out.println(prbendtime);


        List<PRBpor> list = prbService.getXPRB(NENAME,prbbegintime,prbendtime,timesize,properties);

        System.out.println(list.size());

        /*
        List<PRBpor> list = new LinkedList<>();
        PRBpor temp1 = new PRBpor();
        PRBpor temp2 = new PRBpor();
        temp1.setX(8);
        temp2.setX(10);
        temp1.setSTARTTIME(prbbegintime);
        temp2.setSTARTTIME(prbendtime);
        list.add(temp1);
        list.add(temp2);*/


        return list;
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

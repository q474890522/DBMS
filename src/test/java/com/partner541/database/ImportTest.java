package com.partner541.database;

import com.partner541.database.model.C2I;
import com.partner541.database.model.C2I3;
import com.partner541.database.model.PRBpor;
import com.partner541.database.service.C2Iservice;
import com.partner541.database.service.PRBService;
import com.partner541.database.utils.ImportExcelSmall;
import com.partner541.database.utils.TableType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportTest {

    @Autowired
    ImportExcelSmall importExcelSmall;

    @Autowired
    PRBService prbService;

    @Autowired
    C2Iservice c2Iservice;

    @Test
    public void ImportTestMain() {
//        try {
//            //List<Object> list = importExcelSmall.exportListFromExcel(TableType.PRB.getValue());
//            //System.out.println(list.get(0).toString());
////            for(Object obj : list) {
////                System.out.println(obj.toString());
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //prbService.exportExcelnew("D:\\系统桌面\\薛顺国\\Desktop\\作业\\数据库系统原理课程设计\\数据库系统原理课程设计-18\\背景资料", "newPRBnew.xlsx");
//        Date date1 = new Date("05/07/17 00:00:00");
//        Date date2 = new Date("07/07/17 00:00:00");
//        List<PRBpor> list =prbService.getXPRB("三门峡义马跃进煤矿-HLHF",date1,date2,900000,"0");

        List<C2I3> list =  c2Iservice.re_tri(70);
        for(C2I3 i : list)
            System.out.println(i.getCELLa() + " " + i.getCELLb() + " " + i.getCELLc());
    }
}

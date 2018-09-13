package com.partner541.database;

import com.partner541.database.utils.ImportExcelBig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PRBImportTest {

    @Autowired
    ImportExcelBig importExcelBig;

    @Test
    public void PRBImportTestMain() {
        try {
            //importExcelBig.readOneSheet("G:\\大四上作业\\数据库系统原理课程设计\\数据库系统原理课程设计-18\\三门峡地区TD-LTE网络数据-2017-03\\PRB.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

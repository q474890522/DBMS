package com.partner541.database;

import com.partner541.database.dao.CellDao;
import com.partner541.database.dao.PRBDao;
import com.partner541.database.model.Cell;
import com.partner541.database.model.PRB;
import com.partner541.database.service.PRBService;
import com.partner541.database.utils.ExportExcel;
import com.partner541.database.utils.ImportExcelSmall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportTest {

    @Autowired
    ExportExcel exportExcel;

    @Autowired
    CellDao cellDao;

    @Autowired
    PRBDao prbDao;

    @Autowired
    PRBService prbService;

    @Test
    public void ImportTestMain() {
        Date date1 = new Date("05/07/17 00:00:00");
        Date date2 = new Date("05/07/17 01:00:00");
        List<PRB> aa = prbDao.getPRB();

        System.out.println("分割线---------------------------------------------------------------------------------------------------------------------------------------");
        List<PRB> list = prbService.getHPRB(new Date("05/07/17 00:00:00"),new Date("07/07/17 00:00:00"),(date2.getTime()-date1.getTime())/1);
//        for(PRB i :list)
//            System.out.println(i.toString());
//        System.out.println(list.size());
    }
}

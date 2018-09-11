package com.partner541.database;

import com.partner541.database.utils.ImportExcelSmall;
import com.partner541.database.utils.TableType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportTest {

    @Autowired
    ImportExcelSmall importExcelSmall;

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
    }
}

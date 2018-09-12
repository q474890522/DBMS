package com.partner541.database;

import com.partner541.database.dao.CellDao;
import com.partner541.database.model.Cell;
import com.partner541.database.utils.ExportExcel;
import com.partner541.database.utils.ImportExcelSmall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportTest {

    @Autowired
    ExportExcel exportExcel;

    @Autowired
    CellDao cellDao;

    @Test
    public void ImportTestMain() {
        List<Cell> cells = cellDao.select();
        for(Cell cell : cells) {
            System.out.println("CITY:"+cell.getCITY() + " SECTOR_ID:" + cell.getSECTORID() + " SECTOR_NAME:" + cell.getSECTORNAME() + " ENODEB_NAME:" + cell.getENODEBNAME()+""+cell.getSTYLE());
        }
    }
}

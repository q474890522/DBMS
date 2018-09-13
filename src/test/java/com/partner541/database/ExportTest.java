package com.partner541.database;

import com.partner541.database.dao.CellDao;
import com.partner541.database.model.Cell;
import com.partner541.database.service.CellService;
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

    @Autowired
    CellService cellService;
    @Test
    public void ImportTestMain() {
        try {
            System.out.println(Integer.valueOf("124672"));
            List<Cell> cells = cellService.selectCell("124672-0","三门峡渑池刘果-HLHF-1", "124672", "三门峡渑池刘果-HLHF");

            for(Cell cell : cells) {
                System.out.println(cells.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

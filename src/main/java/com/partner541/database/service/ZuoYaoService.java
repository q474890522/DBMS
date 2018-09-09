package com.partner541.database.service;

import com.partner541.database.model.TbCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

@Service
public class ZuoYaoService {
    public static List<Object> readExcel(String FilePath) {
        List<Object> list = new ArrayList<Object>();
        XSSFWorkbook workbook = null;

        try {
            // 读取Excel文件
            InputStream inputStream = new FileInputStream(FilePath);
            workbook = new XSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            final int SUMROL = xssfSheet.getRow(0).getPhysicalNumberOfCells();
            // 循环行
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
//
                // 将单元格中的内容存入集合
                Object[] temp=  new Object[SUMROL];
                TbCell tbCell = new TbCell(SUMROL);
                for(int colnum=0 ; colnum<SUMROL; ++colnum){

                    XSSFCell cell = xssfRow.getCell(colnum);
                    if (cell == null) {
                        continue;
                    }
                    if (cell.getCellType()==STRING){
                        temp[colnum] =cell.getStringCellValue();
                    }else if(cell.getCellType()==NUMERIC) {
                        temp[colnum] = cell.getNumericCellValue();
                    }


                }
                tbCell.setRow(temp);
                list.add(tbCell);
            }
        }
        return list;
    }
    public static void test(){
        XSSFWorkbook workbook = null;

        try {
            // 读取Excel文件
            InputStream inputStream = new FileInputStream("D:/tbCell.xlsx");
            workbook = new XSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        XSSFSheet xssfSheet = workbook.getSheetAt(0);
        for(int i=0 ;i<3 ;++i){
            System.out.println(xssfSheet.getRow(1).getCell(i).getStringCellValue());

        }

    }
}

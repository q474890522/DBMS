package com.partner541.database.utils;

import com.partner541.database.dao.CellDao;
import com.partner541.database.dao.KPIDao;
import com.partner541.database.dao.PRBDao;
import com.partner541.database.model.KPI;
import com.partner541.database.model.PRB;
import com.partner541.database.model.TbCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ImportExcelSmall {
    @Autowired
    CellDao cellDao;

    @Autowired
    KPIDao kpiDao;

    @Autowired
    PRBDao prbDao;

    private static final Logger logger = LoggerFactory.getLogger(ImportExcelSmall.class);


    //由指定的Sheet导出至List
    //MultiFile
    public int exportListFromExcel(int tableType, MultipartFile file) throws Exception {

        // 同时支持Excel 2003、2007
        //File excelFile = new File("G:\\大四上作业\\数据库系统原理课程设计\\数据库系统原理课程设计-18\\三门峡地区TD-LTE网络数据-2017-03\\PRB.xlsx"); // 创建文件对象
        InputStream is = file.getInputStream(); // 文件流
        Workbook workbook = getWorkbok(is, file.getOriginalFilename());
        //Workbook workbook = getSXSSWorkbook(is, excelFile);
        is.close();
        Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet
        List<Object> list = new ArrayList<>();
        int succCount = 0;

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            int colNum = row.getPhysicalNumberOfCells();
            Object[] object = new Object[colNum];
            TbCell tbCell = new TbCell(colNum);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell == null) continue;
                switch (cell.getCellType()) {
                    case STRING:
                        object[j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        object[j] = cell.getNumericCellValue();
                        break;
                }
            }
            tbCell.setRow(object);
            list.add(tbCell);
            if(i % 500 == 0) {
                succCount = succCount + insertIntoDB(tableType, list);
                System.out.println("第" + i + "条已经导入");
                list.clear();
            }
        }
        return succCount;
    }

    //判断Excel的版本,获取Workbook
    private Workbook getWorkbok(InputStream in, String fileName) throws IOException {
        Workbook wb = null;
        if (fileName.endsWith(StaticFinalUtil.EXCEL_XLS)) {  //Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (fileName.endsWith(StaticFinalUtil.EXCEL_XLSX)) {  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    private static int doubleToInt(Double d) {
        return d.intValue();
    }
    private static long doubleToLong(Double d) {
        return d.longValue();
    }
    private static double dealWithDouStr(Object obj) {
        if(obj.getClass() == String.class)
            return Double.valueOf((String) obj);
        return (double) obj;
    }

    private static Date strToDate(Object obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse((String) obj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private int insertIntoDB(int tableType, List<Object> list) throws Exception {
        int succCount = 0;
        if(tableType == TableType.Cell.getValue()) {
            for (Object obj : list) {
                //try {
                    TbCell tbCell = (TbCell) obj;
                    Object[] objects = tbCell.getRow();
                    com.partner541.database.model.Cell cell = new com.partner541.database.model.Cell();
                    cell.setCITY((String) objects[0]);
                    cell.setSECTOR_ID((String) objects[1]);
                    cell.setSECTOR_NAME((String) objects[2]);
                    cell.setENODEBID(doubleToInt((Double) objects[3]));
                    cell.setENODEB_NAME((String) objects[4]);
                    cell.setEARFCN(doubleToInt((Double) objects[5]));
                    cell.setPCI(doubleToInt((Double) objects[6]));
                    cell.setPSS(doubleToInt((Double) objects[7]));
                    cell.setSSS(doubleToInt((Double) objects[8]));
                    cell.setTAC(doubleToInt((Double) objects[9]));
                    cell.setVENDOR((String) objects[10]);
                    cell.setLONGITUDE(dealWithDouStr(objects[11]));
                    cell.setLATITUDE(dealWithDouStr(objects[12]));
                    cell.setSTYLE((String) objects[13]);
                    cell.setAZIMUTH(doubleToInt((Double) objects[14]));
                    cell.setHEIGHT(doubleToInt(dealWithDouStr(objects[15])));
                    cell.setELECTTILT(doubleToInt((Double) objects[16]));
                    cell.setMECHTILT(doubleToInt((Double) objects[17]));
                    cell.setTOTLETILT(doubleToInt((Double) objects[18]));
                    cellDao.insertCell(cell);
                    succCount++;
                //} catch (Exception e){
                    //logger.error(obj.toString()+ "----result: 没导进去----" + "why: " + e.getLocalizedMessage());
                //}
            }
        } else if(tableType == TableType.KPI.getValue()) {
            for (Object obj : list) {
                try {
                    TbCell tbCell = (TbCell) obj;
                    Object[] objects = tbCell.getRow();
                    KPI kpi = new KPI();
                    kpi.setSTART_TIME(strToDate(objects[0]));
                    kpi.setCYCLE(doubleToInt((Double) objects[1]));
                    kpi.setNE_NAME((String) objects[2]);
                    kpi.setSECTOR((String) objects[3]);
                    kpi.setSECTOR_NAME((String) objects[4]);
                    kpi.setRRC_CONNECT_COMPLETE_TIME(doubleToInt((Double) objects[5]));
                    kpi.setRRC_CONNECT_REQUEST_TIME(doubleToInt((Double) objects[6]));
                    kpi.setRRC_SET_SUCC_RATE((Double)objects[7]);
                    kpi.setERAB_SET_SUCCESS_TIME(doubleToInt((Double) objects[8]));
                    kpi.setERAB_TRY_CONNECT_TIME(doubleToInt((Double) objects[9]));
                    kpi.setERAB_SET_SUCCESS_TWO((Double) objects[10]);
                    kpi.seteNodeB_TRYGGER_EXCEP_RELE_TIME(doubleToInt((Double) objects[11]));
                    kpi.setSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME(doubleToInt((Double) objects[12]));
                    kpi.setERAB_DROP_RATE((Double) objects[13]);
                    kpi.setWIRELESS_CONN_RATE((Double) objects[14]);
                    kpi.seteNodeB_INIT_S1(doubleToInt((Double) objects[15]));
                    kpi.setUE_Context_EXCEP_RELE_TIME(doubleToInt((Double) objects[16]));
                    kpi.setUE_Context_SET_SUCCESS_TIME(doubleToInt((Double) objects[17]));
                    kpi.setWIRELESS_DROP_RATE((Double) objects[18]);
                    kpi.seteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME(doubleToInt((Double) objects[19]));
                    kpi.seteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME(doubleToInt((Double) objects[20]));
                    kpi.seteNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME(doubleToInt((Double) objects[21]));
                    kpi.seteNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME(doubleToInt((Double) objects[22]));
                    kpi.seteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME(doubleToInt((Double) objects[23]));
                    kpi.seteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME(doubleToInt((Double) objects[24]));
                    kpi.seteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME(doubleToInt((Double) objects[25]));
                    kpi.seteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME(doubleToInt((Double) objects[26]));
                    kpi.seteNB_IN_SWITCH_SUCC_RATE((Double) (objects[27]));
                    kpi.seteNB_BETWEEN_SWITCH_SUCC_RATE((Double) objects[28]);
                    kpi.setSAME_FREQ_SWITCH_SUCC_ZSP((Double) objects[29]);
                    kpi.setDIFF_FREQ_SWITCH_SUCC_ZSP((Double) objects[30]);
                    kpi.setSWITCH_SUCC_RATE((Double) objects[31]);
                    kpi.setSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT(doubleToLong((Double) objects[32]));
                    kpi.setSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT(doubleToLong((Double) objects[33]));
                    kpi.setRPC_RESET_REQUEST_TIME(doubleToInt((Double) objects[34]));
                    kpi.setRPC_CONN_RESET_RATE((Double) objects[35]);
                    kpi.setTO_ONE(doubleToInt((Double) objects[36]));
                    kpi.setTO_TWO(doubleToInt((Double) objects[37]));
                    kpi.setTO_THREE(doubleToInt((Double) objects[38]));
                    kpi.setTO_FOUR(doubleToInt((Double) objects[39]));
                    kpi.seteNB_IN_SWITCH_SUCC_TIME(doubleToInt((Double) objects[40]));
                    kpi.seteNB_IN_SWITCH_REQUEST_TIME(doubleToInt((Double) objects[41]));
                    kpiDao.insertKPI(kpi);
                    succCount++;
                } catch (Exception e){
                    logger.error(obj.toString()+ "----result: 没导进去----" + "why: " + e.getLocalizedMessage());
                }
            }
        } else {
            throw new Exception("目前没有该表可供导入");
        }
        return succCount;
    }
}

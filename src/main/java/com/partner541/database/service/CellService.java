package com.partner541.database.service;

import com.partner541.database.dao.CellDao;
import com.partner541.database.model.Cell;
import com.partner541.database.utils.ImportExcelSmall;
import com.partner541.database.utils.StaticFinalUtil;
import com.partner541.database.utils.TableType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class CellService {
    @Autowired
    ImportExcelSmall importExcelSmall;

    @Autowired
    CellDao cellDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导tbCell表
     * @param file 上传的文件
     * @return
     */
    public boolean importTbCell(MultipartFile file) {
        try {
            StaticFinalUtil.checkExcelVaild(file);
        } catch (Exception e) {
            logger.error("该文件不是Excel");
            return false;
        }
        int succCount = 0;
        try {
            succCount = importExcelSmall.exportListFromExcel(TableType.Cell.getValue(), file);
        } catch (Exception e) {
            logger.error("导入Cell Excel时失败");
            return false;
        }
        return true;
    }

    /**
     * 清空tbCell
     * @return 清空多少条数据
     */
    public int cleanTbCell() {
        return cellDao.deleteCell();
    }

    public void exportExcel(HttpServletResponse response, String path, String fileName) {
        //获取数据列表
        List<Cell> list =cellDao.selectCellAll();//list数据由数据库查询得到
        if(list!=null && list.size() > 0){
            //获取分页指标
            int total = list.size();//数据总数
            int mus = 1000000;//每个sheet中数据数量
            int avg = (total/mus)+1;//sheet数量

            //获取工作簿对象
            //第一步：创建Workbook，对应一个excel文件
            SXSSFWorkbook wb = new SXSSFWorkbook(100);//每次缓存100条到内存，其余的写到磁盘中，避免内存溢出
            //样式
            //创建样式1（列标识样式）
            CellStyle styleContent = wb.createCellStyle();
            styleContent.setFillBackgroundColor((short)13);//背景色
            styleContent.setFillForegroundColor((short)15);//前景色
            Font fontContent = wb.createFont();
            fontContent.setFontName("宋体");;
            fontContent.setFontHeightInPoints((short)10);//字体大小
            styleContent.setFont(fontContent);
            styleContent.setWrapText(true);//自动换行

            //创建样式2(数据项样式)
            CellStyle style= wb.createCellStyle();
            Font font = wb.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short)10);//字体大小
            style.setFont(font);
            style.setWrapText(true);//自动换行

            //创建样式3(数据项样式-日期)
            CellStyle style_date = wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            style_date.setDataFormat(format.getFormat("yyyy-MM-dd"));
            Font font_date = wb.createFont();
            font_date.setFontName("宋体");
            font_date.setFontHeightInPoints((short)10);//字体大小
            style_date.setFont(font_date);
            style_date.setWrapText(true);//自动换行

            //第二步：在workbook添加sheet
            for(int m = 0; m < avg; m++){
                SXSSFSheet sheet = wb.createSheet("sheet"+(m+1));
                int sheet_row = 0;
                //第三步：正文
                //无表头
                //正文
                SXSSFRow sheet_row1 = sheet.createRow(sheet_row);
                //sheet_row1.setHeight((short)400);//设置行高
                SXSSFCell sheetcell1 = sheet_row1.createCell(0);
                sheetcell1.setCellValue("CITY");
                sheetcell1.setCellStyle(styleContent);
                SXSSFCell sheetcell2 = sheet_row1.createCell(1);
                sheetcell2.setCellValue("SECTORID");
                sheetcell2.setCellStyle(styleContent);
                SXSSFCell sheetcell3 = sheet_row1.createCell(2);
                sheetcell3.setCellValue("SECTORNAME");
                sheetcell3.setCellStyle(styleContent);
                SXSSFCell sheetcell4 = sheet_row1.createCell(3);
                sheetcell4.setCellValue("ENODEBID");
                sheetcell4.setCellStyle(styleContent);
                SXSSFCell sheetcell5 = sheet_row1.createCell(4);
                sheetcell5.setCellValue("ENODEBNAME");
                sheetcell5.setCellStyle(styleContent);
                SXSSFCell sheetcell6 = sheet_row1.createCell(5);
                sheetcell6.setCellValue("EARFCN");
                sheetcell6.setCellStyle(styleContent);
                SXSSFCell sheetcell7 = sheet_row1.createCell(6);
                sheetcell7.setCellValue("PCI");
                sheetcell7.setCellStyle(styleContent);
                SXSSFCell sheetcell8 = sheet_row1.createCell(7);
                sheetcell8.setCellValue("PSS");
                sheetcell8.setCellStyle(styleContent);
                SXSSFCell sheetcell9 = sheet_row1.createCell(8);
                sheetcell9.setCellValue("SSS");
                sheetcell9.setCellStyle(styleContent);
                SXSSFCell sheetcell10 = sheet_row1.createCell(9);
                sheetcell10.setCellValue("TAC");
                sheetcell10.setCellStyle(styleContent);
                SXSSFCell sheetcell11 = sheet_row1.createCell(10);
                sheetcell11.setCellValue("VENDOR");
                sheetcell11.setCellStyle(styleContent);
                SXSSFCell sheetcell12 = sheet_row1.createCell(11);
                sheetcell12.setCellValue("LONGITUDE");
                sheetcell12.setCellStyle(styleContent);
                SXSSFCell sheetcell13 = sheet_row1.createCell(12);
                sheetcell13.setCellValue("LATITUDE");
                sheetcell13.setCellStyle(styleContent);
                SXSSFCell sheetcell14 = sheet_row1.createCell(13);
                sheetcell14.setCellValue("STYLE");
                sheetcell14.setCellStyle(styleContent);
                SXSSFCell sheetcell15 = sheet_row1.createCell(14);
                sheetcell15.setCellValue("AZIMUTH");
                sheetcell15.setCellStyle(styleContent);
                SXSSFCell sheetcell16 = sheet_row1.createCell(15);
                sheetcell16.setCellValue("HEIGHT");
                sheetcell16.setCellStyle(styleContent);
                SXSSFCell sheetcell17 = sheet_row1.createCell(16);
                sheetcell17.setCellValue("ELECTTILT");
                sheetcell17.setCellStyle(styleContent);
                SXSSFCell sheetcell18 = sheet_row1.createCell(17);
                sheetcell18.setCellValue("MECHTILT");
                sheetcell18.setCellStyle(styleContent);
                SXSSFCell sheetcell19 = sheet_row1.createCell(18);
                sheetcell19.setCellValue("TOTLETILT");
                sheetcell19.setCellStyle(styleContent);

                sheet_row = sheet_row+1;
                //数据渲染
                Cell pct =null;
                SXSSFRow sheet_rows = null;
                SXSSFCell sheetcell = null;
                for(int n = mus*m; n < mus*(m+1); n++){
                    if(n < total){
                        pct = list.get(n);
                        sheet_rows = sheet.createRow(sheet_row);
                        //sheet_rows.setHeight((short)400);//设置行高
                        sheetcell = sheet_rows.createCell(0);
                        sheetcell.setCellValue(pct.getCITY());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(1);
                        sheetcell.setCellValue(pct.getSECTORID());
                        sheetcell.setCellStyle(style);
                        System.out.println(pct.getSECTORNAME());
                        sheetcell = sheet_rows.createCell(2);
                        sheetcell.setCellValue(pct.getSECTORNAME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(3);
                        sheetcell.setCellValue(pct.getENODEBID());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(4);
                        sheetcell.setCellValue(pct.getENODEBNAME());
                        sheetcell.setCellStyle(style);
//                        if(pct.getContract_date()!=null){
//                            sheetcell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(pct.getContract_date()));
//                        }
//                        sheetcell.setCellStyle(style_date);
                        sheetcell = sheet_rows.createCell(5);
                        sheetcell.setCellValue(pct.getEARFCN());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(6);
                        sheetcell.setCellValue(pct.getPCI());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(7);
                        sheetcell.setCellValue(pct.getPSS());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(8);
                        sheetcell.setCellValue(pct.getSSS());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(9);
                        sheetcell.setCellValue(pct.getTAC());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(10);
                        sheetcell.setCellValue(pct.getVENDOR());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(11);
                        sheetcell.setCellValue(pct.getLONGITUDE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(12);
                        sheetcell.setCellValue(pct.getLATITUDE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(13);
                        sheetcell.setCellValue(pct.getSTYLE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(14);
                        sheetcell.setCellValue(pct.getAZIMUTH());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(15);
                        sheetcell.setCellValue(pct.getHEIGHT());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(16);
                        sheetcell.setCellValue(pct.getELECTTILT());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(17);
                        sheetcell.setCellValue(pct.getMECHTILT());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(18);
                        sheetcell.setCellValue(pct.getTOTLETILT());
                        sheetcell.setCellStyle(style);
                        sheet_row = sheet_row +1;
                        pct = null;
                        sheet_rows = null;
                        sheetcell = null;
                    }
                }
            }
            //第四步：保存
            try {
//                response.setContentType("applicatin/ms-excel");
//                response.setHeader("Content-Disposition",
//                        "attachment;filename="+new String(fileName.getBytes("gb2312"),"iso-8859-1"));
                response.addHeader("Content-Disposition",
                        "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
                wb.write(response.getOutputStream());
                FileOutputStream outputStream = new FileOutputStream(path + "\\" + fileName);
                wb.write(outputStream);
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }else{
        }
    }
}

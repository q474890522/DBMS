package com.partner541.database.service;

import com.partner541.database.dao.KPIDao;
import com.partner541.database.model.Cell;
import com.partner541.database.model.KPI;
import com.partner541.database.utils.ImportExcelSmall;
import com.partner541.database.utils.StaticFinalUtil;
import com.partner541.database.utils.TableType;
import org.apache.ibatis.annotations.Select;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class    KPIService {
    @Autowired
    ImportExcelSmall importExcelSmall;

    @Autowired
    KPIDao kpiDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导入数据到KPI表
     * @param file 上传的文件
     * @return
     */
    public boolean importTbKPI(MultipartFile file) {
        try {
            StaticFinalUtil.checkExcelVaild(file);
        } catch (Exception e) {
            logger.error("该文件不是Excel");
            return false;
        }
        int succCount = 0;
//        try {
            succCount = importExcelSmall.exportListFromExcel(TableType.KPI.getValue(), file);
//        } catch (Exception e) {
//            logger.error("导入KPI Excel时失败");
//            return false;
//        }
        return true;
    }

    /**
     * 清空KPI表
     * @return 清空几条数据
     */
    public int cleanTbKPI() {
        return kpiDao.deleteKPI();
    }

    public void exportExcel(String path, String fileName) {
        //获取数据列表
        List<KPI> list =kpiDao.selectKPIAll();//list数据由数据库查询得到
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
            //styleContent.setWrapText(true);//自动换行

            //创建样式2(数据项样式)
            CellStyle style= wb.createCellStyle();
            Font font = wb.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short)10);//字体大小
            style.setFont(font);
           // style.setWrapText(true);//自动换行

            //创建样式3(数据项样式-日期)
            CellStyle style_date = wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            style_date.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
            Font font_date = wb.createFont();
            font_date.setFontName("宋体");
            font_date.setFontHeightInPoints((short)10);//字体大小
            style_date.setFont(font_date);
           // style_date.setWrapText(true);//自动换行

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
                sheetcell1.setCellValue("START_TIME");
                sheetcell1.setCellStyle(styleContent);
                SXSSFCell sheetcell2 = sheet_row1.createCell(1);
                sheetcell2.setCellValue("CYCLE");
                sheetcell2.setCellStyle(styleContent);
                SXSSFCell sheetcell3 = sheet_row1.createCell(2);
                sheetcell3.setCellValue("NE_NAME");
                sheetcell3.setCellStyle(styleContent);
                SXSSFCell sheetcell4 = sheet_row1.createCell(3);
                sheetcell4.setCellValue("SECTOR");
                sheetcell4.setCellStyle(styleContent);
                SXSSFCell sheetcell5 = sheet_row1.createCell(4);
                sheetcell5.setCellValue("SECTOR_NAME");
                sheetcell5.setCellStyle(styleContent);
                SXSSFCell sheetcell6 = sheet_row1.createCell(5);
                sheetcell6.setCellValue("RRC_CONNECT_COMPLETE_TIME");
                sheetcell6.setCellStyle(styleContent);
                SXSSFCell sheetcell7 = sheet_row1.createCell(6);
                sheetcell7.setCellValue("RRC_CONNECT_REQUEST_TIME");
                sheetcell7.setCellStyle(styleContent);
                SXSSFCell sheetcell8 = sheet_row1.createCell(7);
                sheetcell8.setCellValue("RRC_SET_SUCC_RATE");
                sheetcell8.setCellStyle(styleContent);
                SXSSFCell sheetcell9 = sheet_row1.createCell(8);
                sheetcell9.setCellValue("ERAB_SET_SUCCESS_TIME");
                sheetcell9.setCellStyle(styleContent);
                SXSSFCell sheetcell10 = sheet_row1.createCell(9);
                sheetcell10.setCellValue("ERAB_TRY_CONNECT_TIME");
                sheetcell10.setCellStyle(styleContent);
                SXSSFCell sheetcell11 = sheet_row1.createCell(10);
                sheetcell11.setCellValue("ERAB_SET_SUCCESS_TWO");
                sheetcell11.setCellStyle(styleContent);
                SXSSFCell sheetcell12 = sheet_row1.createCell(11);
                sheetcell12.setCellValue("eNodeB_TRYGGER_EXCEP_RELE_TIME");
                sheetcell12.setCellStyle(styleContent);
                SXSSFCell sheetcell13 = sheet_row1.createCell(12);
                sheetcell13.setCellValue("SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME");
                sheetcell13.setCellStyle(styleContent);
                SXSSFCell sheetcell14 = sheet_row1.createCell(13);
                sheetcell14.setCellValue("ERAB_DROP_RATE");
                sheetcell14.setCellStyle(styleContent);
                SXSSFCell sheetcell15 = sheet_row1.createCell(14);
                sheetcell15.setCellValue("WIRELESS_CONN_RATE");
                sheetcell15.setCellStyle(styleContent);
                SXSSFCell sheetcell16 = sheet_row1.createCell(15);
                sheetcell16.setCellValue("eNodeB_INIT_S1");
                sheetcell16.setCellStyle(styleContent);
                SXSSFCell sheetcell17 = sheet_row1.createCell(16);
                sheetcell17.setCellValue("UE_Context_EXCEP_RELE_TIME");
                sheetcell17.setCellStyle(styleContent);
                SXSSFCell sheetcell18 = sheet_row1.createCell(17);
                sheetcell18.setCellValue("UE_Context_SET_SUCCESS_TIME");
                sheetcell18.setCellStyle(styleContent);
                SXSSFCell sheetcell19 = sheet_row1.createCell(18);
                sheetcell19.setCellValue("WIRELESS_DROP_RATE");
                sheetcell19.setCellStyle(styleContent);
                SXSSFCell sheetcell20 = sheet_row1.createCell(19);
                sheetcell20.setCellValue("eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME");
                sheetcell20.setCellStyle(styleContent);
                SXSSFCell sheetcell21 = sheet_row1.createCell(20);
                sheetcell21.setCellValue("eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME");
                sheetcell21.setCellStyle(styleContent);
                SXSSFCell sheetcell22 = sheet_row1.createCell(21);
                sheetcell22.setCellValue("eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME");
                sheetcell22.setCellStyle(styleContent);
                SXSSFCell sheetcell23 = sheet_row1.createCell(22);
                sheetcell23.setCellValue("eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME");
                sheetcell23.setCellStyle(styleContent);
                SXSSFCell sheetcell24 = sheet_row1.createCell(23);
                sheetcell24.setCellValue("eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME");
                sheetcell24.setCellStyle(styleContent);
                SXSSFCell sheetcell25 = sheet_row1.createCell(24);
                sheetcell25.setCellValue("eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME");
                sheetcell25.setCellStyle(styleContent);
                SXSSFCell sheetcell26 = sheet_row1.createCell(25);
                sheetcell26.setCellValue("eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME");
                sheetcell26.setCellStyle(styleContent);
                SXSSFCell sheetcell27 = sheet_row1.createCell(26);
                sheetcell27.setCellValue("eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME");
                sheetcell27.setCellStyle(styleContent);
                SXSSFCell sheetcell28 = sheet_row1.createCell(27);
                sheetcell28.setCellValue("eNB_IN_SWITCH_SUCC_RATE");
                sheetcell28.setCellStyle(styleContent);
                SXSSFCell sheetcell29 = sheet_row1.createCell(28);
                sheetcell29.setCellValue("eNB_BETWEEN_SWITCH_SUCC_RATE");
                sheetcell29.setCellStyle(styleContent);
                SXSSFCell sheetcell30 = sheet_row1.createCell(29);
                sheetcell30.setCellValue("SAME_FREQ_SWITCH_SUCC_ZSP");
                sheetcell30.setCellStyle(styleContent);
                SXSSFCell sheetcell31 = sheet_row1.createCell(30);
                sheetcell31.setCellValue("DIFF_FREQ_SWITCH_SUCC_ZSP");
                sheetcell31.setCellStyle(styleContent);
                SXSSFCell sheetcell32 = sheet_row1.createCell(31);
                sheetcell32.setCellValue("SWITCH_SUCC_RATE");
                sheetcell32.setCellStyle(styleContent);
                SXSSFCell sheetcell33 = sheet_row1.createCell(32);
                sheetcell33.setCellValue("SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT");
                sheetcell33.setCellStyle(styleContent);
                SXSSFCell sheetcell34 = sheet_row1.createCell(33);
                sheetcell34.setCellValue("SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT");
                sheetcell34.setCellStyle(styleContent);
                SXSSFCell sheetcell35 = sheet_row1.createCell(34);
                sheetcell35.setCellValue("RPC_RESET_REQUEST_TIME");
                sheetcell35.setCellStyle(styleContent);
                SXSSFCell sheetcell36 = sheet_row1.createCell(35);
                sheetcell36.setCellValue("RPC_CONN_RESET_RATE");
                sheetcell36.setCellStyle(styleContent);
                SXSSFCell sheetcell37 = sheet_row1.createCell(36);
                sheetcell37.setCellValue("TO_ONE");
                sheetcell37.setCellStyle(styleContent);
                SXSSFCell sheetcell38 = sheet_row1.createCell(37);
                sheetcell38.setCellValue("TO_TWO");
                sheetcell38.setCellStyle(styleContent);
                SXSSFCell sheetcell39 = sheet_row1.createCell(38);
                sheetcell39.setCellValue("TO_THREE");
                sheetcell39.setCellStyle(styleContent);
                SXSSFCell sheetcell40 = sheet_row1.createCell(39);
                sheetcell40.setCellValue("TO_FOUR");
                sheetcell40.setCellStyle(styleContent);
                SXSSFCell sheetcell41 = sheet_row1.createCell(40);
                sheetcell41.setCellValue("eNB_IN_SWITCH_SUCC_TIME");
                sheetcell41.setCellStyle(styleContent);
                SXSSFCell sheetcell42 = sheet_row1.createCell(41);
                sheetcell42.setCellValue("eNB_IN_SWITCH_REQUEST_TIME");
                sheetcell42.setCellStyle(styleContent);

                sheet_row = sheet_row+1;
                //数据渲染
                KPI pct =null;
                SXSSFRow sheet_rows = null;
                SXSSFCell sheetcell = null;
                for(int n = mus*m; n < mus*(m+1); n++){
                    if(n < total){
                        pct = list.get(n);
                        sheet_rows = sheet.createRow(sheet_row);
                        //sheet_rows.setHeight((short)400);//设置行高
                        sheetcell = sheet_rows.createCell(0);
                        if (pct.getSTARTTIME() != null) {
                            sheetcell.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pct.getSTARTTIME()));
                        }
                        sheetcell.setCellStyle(style_date);
                        sheetcell = sheet_rows.createCell(1);
                        sheetcell.setCellValue(pct.getCYCLE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(2);
                        sheetcell.setCellValue(pct.getNENAME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(3);
                        sheetcell.setCellValue(pct.getSECTOR());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(4);
                        sheetcell.setCellValue(pct.getSECTORNAME());
                        sheetcell.setCellStyle(style);
//                        if(pct.getContract_date()!=null){
//                            sheetcell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(pct.getContract_date()));
//                        }
//                        sheetcell.setCellStyle(style_date);
                        sheetcell = sheet_rows.createCell(5);
                        sheetcell.setCellValue(pct.getRRCCONNECTCOMPLETETIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(6);
                        sheetcell.setCellValue(pct.getRRCCONNECTREQUESTTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(7);
                        sheetcell.setCellValue(pct.getRRCSETSUCCRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(8);
                        sheetcell.setCellValue(pct.getERABSETSUCCESSTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(9);
                        sheetcell.setCellValue(pct.getERABTRYCONNECTTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(10);
                        sheetcell.setCellValue(pct.getERABSETSUCCESSTWO());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(11);
                        sheetcell.setCellValue(pct.geteNodeBTRYGGEREXCEPRELETIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(12);
                        sheetcell.setCellValue(pct.getSECTORSWITCHERABEXCEPRELETIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(13);
                        sheetcell.setCellValue(pct.getERABDROPRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(14);
                        sheetcell.setCellValue(pct.getWIRELESSCONNRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(15);
                        sheetcell.setCellValue(pct.geteNodeBINITS1());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(16);
                        sheetcell.setCellValue(pct.getUEContextEXCEPRELETIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(17);
                        sheetcell.setCellValue(pct.getUEContextSETSUCCESSTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(18);
                        sheetcell.setCellValue(pct.getWIRELESSDROPRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(19);
                        sheetcell.setCellValue(pct.geteNodeBINDIFFFREQSWITCHSUCCTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(20);
                        sheetcell.setCellValue(pct.geteNodeBINDIFFFREQSWITCHTRYTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(21);
                        sheetcell.setCellValue(pct.geteNodeBINSAMEFREQSWITCHSUCCTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(22);
                        sheetcell.setCellValue(pct.geteNodeBINSAMEFREQSWITCHTRYTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(23);
                        sheetcell.setCellValue(pct.geteNodeBBETWEENDIFFFREQSWITCHSUCCTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(24);
                        sheetcell.setCellValue(pct.geteNodeBBETWEENDIFFFREQSWITCHTRYTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(25);
                        sheetcell.setCellValue(pct.geteNodeBBETWEENSAMEFREQSWITCHSUCCTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(26);
                        sheetcell.setCellValue(pct.geteNodeBBETWEENSAMEFREQSWITCHTRYTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(27);
                        sheetcell.setCellValue(pct.geteNBINSWITCHSUCCRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(28);
                        sheetcell.setCellValue(pct.geteNBBETWEENSWITCHSUCCRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(29);
                        sheetcell.setCellValue(pct.getSAMEFREQSWITCHSUCCZSP());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(30);
                        sheetcell.setCellValue(pct.getDIFFFREQSWITCHSUCCZSP());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(31);
                        sheetcell.setCellValue(pct.getSWITCHSUCCRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(32);
                        sheetcell.setCellValue(pct.getSECTORDPCPRECVUPDATETHROUGHPUT());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(33);
                        sheetcell.setCellValue(pct.getSECTORDPCPRECVDOWNDATETHROUGHPUT());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(34);
                        sheetcell.setCellValue(pct.getRPCRESETREQUESTTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(35);
                        sheetcell.setCellValue(pct.getRPCCONNRESETRATE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(36);
                        sheetcell.setCellValue(pct.getTOONE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(37);
                        sheetcell.setCellValue(pct.getTOTWO());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(38);
                        sheetcell.setCellValue(pct.getTOTHREE());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(39);
                        sheetcell.setCellValue(pct.getTOFOUR());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(40);
                        sheetcell.setCellValue(pct.geteNBINSWITCHSUCCTIME());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(41);
                        sheetcell.setCellValue(pct.geteNBINSWITCHREQUESTTIME());
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
//                response.addHeader("Content-Disposition",
//                        "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
//                wb.write(response.getOutputStream());
                FileOutputStream outputStream = new FileOutputStream(path + "\\" + fileName);
                wb.write(outputStream);
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Date> selectSTART_TIME() {
        return kpiDao.selectSTART_TIME();
    }

    public List<Integer> selectCYCLE() {
        return kpiDao.selectCYCLE();
    }

    public List<String> selectNE_NAME() {
        return kpiDao.selectNE_NAME();
    }

    public List<String> selectSECTOR() {
        return kpiDao.selectSECTOR();
    }

    public List<String> selectSECTOR_NAME() {
        return kpiDao.selectSECTOR_NAME();
    }

    public List<Integer> selectRRC_CONNECT_COMPLETE_TIME() {
        return kpiDao.selectRRC_CONNECT_COMPLETE_TIME();
    }

    public List<Integer>selectRRC_CONNECT_REQUEST_TIME() {
        return kpiDao.selectRRC_CONNECT_REQUEST_TIME();
    }

    public List<Double> selectRRC_SET_SUCC_RATE() {
        return kpiDao.selectRRC_SET_SUCC_RATE();
    }

    public List<Integer> selectERAB_SET_SUCCESS_TIME() {
        return kpiDao.selectERAB_SET_SUCCESS_TIME();
    }

    public List<Double> selectERAB_TRY_CONNECT_TIME() {
        return kpiDao.selectERAB_TRY_CONNECT_TIME();
    }

    public List<Integer> selectERAB_SET_SUCCESS_TWO() {
        return kpiDao.selectERAB_SET_SUCCESS_TWO();
    }

    public List<Integer> selecteNodeB_TRYGGER_EXCEP_RELE_TIME() {
        return kpiDao.selecteNodeB_TRYGGER_EXCEP_RELE_TIME();
    }

    public List<Double> selectSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME() {
        return kpiDao.selectSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME();
    }

    public List<Double> selectERAB_DROP_RATE() {
        return kpiDao.selectERAB_DROP_RATE();
    }

    public List<Integer> selectWIRELESS_CONN_RATE() {
        return kpiDao.selectWIRELESS_CONN_RATE();
    }

    public List<Integer> selecteNodeB_INIT_S1() {
        return kpiDao.selecteNodeB_INIT_S1();
    }

    public List<Integer> selectUE_Context_EXCEP_RELE_TIME() {
        return kpiDao.selectUE_Context_EXCEP_RELE_TIME();
    }

    public List<Double> selectUE_Context_SET_SUCCESS_TIME() {
        return kpiDao.selectUE_Context_SET_SUCCESS_TIME();
    }

    public List<Integer> selectWIRELESS_DROP_RATE() {
        return kpiDao.selectWIRELESS_DROP_RATE();
    }

    public List<Integer> selecteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME() {
        return kpiDao.selecteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME();
    }

    public List<Integer> selecteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME() {
        return kpiDao.selecteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME();
    }

    public List<Integer> selecteNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME() {
        return kpiDao.selecteeNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME();
    }

    public List<Integer> selecteNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME() {
        return kpiDao.selecteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME();
    }

    public List<Integer> selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME() {
        return kpiDao.selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME();
    }

    public List<Integer> selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME() {
        return kpiDao.selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME();
    }

    public List<Integer> selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME() {
        return kpiDao.selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME();
    }

    public List<Integer> selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME() {
        return kpiDao.selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME();
    }

    public List<Double> selecteNB_IN_SWITCH_SUCC_RATE() {
        return kpiDao.selecteNB_IN_SWITCH_SUCC_RATE();
    }

    public List<Double> selecteNB_BETWEEN_SWITCH_SUCC_RATE() {
        return kpiDao.selecteNB_BETWEEN_SWITCH_SUCC_RATE();
    }

    public List<Double> selectSAME_FREQ_SWITCH_SUCC_ZSP() {
        return kpiDao.selectSAME_FREQ_SWITCH_SUCC_ZSP();
    }


    public List<Double> selectDIFF_FREQ_SWITCH_SUCC_ZSP() {
        return kpiDao.selectDIFF_FREQ_SWITCH_SUCC_ZSP();
    }

    public List<Double> selectSWITCH_SUCC_RATE() {
        return kpiDao.selectSWITCH_SUCC_RATE();
    }

    public List<Long> selectSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT() {
        return kpiDao.selectSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT();
    }

    public List<Long> selectSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT() {
        return kpiDao.selectSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT();
    }

    public List<Integer> selectRPC_RESET_REQUEST_TIME() {
        return kpiDao.selectRPC_RESET_REQUEST_TIME();
    }

    public List<Double> selectRPC_CONN_RESET_RATE() {
        return kpiDao.selectRPC_CONN_RESET_RATE();
    }

    public List<Integer> selectTO_ONE() {
        return kpiDao.selectTO_ONE();
    }

    public List<Integer> selectTO_TWO() {
        return kpiDao.selectTO_TWO();
    }

    public List<Integer> selectTO_THREE() {
        return kpiDao.selectTO_THREE();
    }

    public List<Integer> selectTO_FOUR() {
        return kpiDao.selectTO_FOUR();
    }

    public List<Integer> selecteNB_IN_SWITCH_SUCC_TIME() {
        return kpiDao.selecteNB_IN_SWITCH_SUCC_TIME();
    }

    public List<Integer> selecteNB_IN_SWITCH_REQUEST_TIME() {
        return kpiDao.selecteNB_IN_SWITCH_REQUEST_TIME();
    }
}

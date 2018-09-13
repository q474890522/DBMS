package com.partner541.database.service;

import com.partner541.database.dao.PRBDao;
import com.partner541.database.model.KPI;
import com.partner541.database.model.PRB;
import com.partner541.database.utils.ImportExcelBig;
import com.partner541.database.utils.StaticFinalUtil;
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

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class PRBService {
    @Autowired
    ImportExcelBig importExcelBig;

    @Autowired
    PRBDao prbDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导入数据到PRB表
     * @param file 上传的文件
     * @return
     */
    public boolean importPRB(MultipartFile file) {
        try {
            StaticFinalUtil.checkExcelVaild(file);
        } catch (Exception e) {
            logger.error("该文件不是Excel");
            return false;
        }
        int succCount = 0;
        try {
            succCount = importExcelBig.readOneSheet(file.getInputStream());
        } catch (Exception e) {
            logger.error("导入PRB Excel失败");
            return false;
        }
        return true;
    }

    public int cleanPRB() {
        return prbDao.deletePRB();
    }

    public void exportExcel(String path, String fileName) {
        //获取数据列表
        List<PRB> list =prbDao.selectPRBAll();//list数据由数据库查询得到
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
            //style.setWrapText(true);//自动换行

            //创建样式3(数据项样式-日期)
            CellStyle style_date = wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            style_date.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
            Font font_date = wb.createFont();
            font_date.setFontName("宋体");
            font_date.setFontHeightInPoints((short)10);//字体大小
            style_date.setFont(font_date);
            //style_date.setWrapText(true);//自动换行

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
                sheetcell6.setCellValue("P0");
                sheetcell6.setCellStyle(styleContent);
                SXSSFCell sheetcell7 = sheet_row1.createCell(6);
                sheetcell7.setCellValue("P1");
                sheetcell7.setCellStyle(styleContent);
                SXSSFCell sheetcell8 = sheet_row1.createCell(7);
                sheetcell8.setCellValue("P2");
                sheetcell8.setCellStyle(styleContent);
                SXSSFCell sheetcell9 = sheet_row1.createCell(8);
                sheetcell9.setCellValue("P3");
                sheetcell9.setCellStyle(styleContent);
                SXSSFCell sheetcell10 = sheet_row1.createCell(9);
                sheetcell10.setCellValue("P4");
                sheetcell10.setCellStyle(styleContent);
                SXSSFCell sheetcell11 = sheet_row1.createCell(10);
                sheetcell11.setCellValue("P5");
                sheetcell11.setCellStyle(styleContent);
                SXSSFCell sheetcell12 = sheet_row1.createCell(11);
                sheetcell12.setCellValue("P6");
                sheetcell12.setCellStyle(styleContent);
                SXSSFCell sheetcell13 = sheet_row1.createCell(12);
                sheetcell13.setCellValue("P7");
                sheetcell13.setCellStyle(styleContent);
                SXSSFCell sheetcell14 = sheet_row1.createCell(13);
                sheetcell14.setCellValue("P8");
                sheetcell14.setCellStyle(styleContent);
                SXSSFCell sheetcell15 = sheet_row1.createCell(14);
                sheetcell15.setCellValue("P9");
                sheetcell15.setCellStyle(styleContent);
                SXSSFCell sheetcell16 = sheet_row1.createCell(15);
                sheetcell16.setCellValue("P10");
                sheetcell16.setCellStyle(styleContent);
                SXSSFCell sheetcell17 = sheet_row1.createCell(16);
                sheetcell17.setCellValue("P11");
                sheetcell17.setCellStyle(styleContent);
                SXSSFCell sheetcell18 = sheet_row1.createCell(17);
                sheetcell18.setCellValue("P12");
                sheetcell18.setCellStyle(styleContent);
                SXSSFCell sheetcell19 = sheet_row1.createCell(18);
                sheetcell19.setCellValue("P13");
                sheetcell19.setCellStyle(styleContent);
                SXSSFCell sheetcell20 = sheet_row1.createCell(19);
                sheetcell20.setCellValue("P14");
                sheetcell20.setCellStyle(styleContent);
                SXSSFCell sheetcell21 = sheet_row1.createCell(20);
                sheetcell21.setCellValue("P15");
                sheetcell21.setCellStyle(styleContent);
                SXSSFCell sheetcell22 = sheet_row1.createCell(21);
                sheetcell22.setCellValue("P16");
                sheetcell22.setCellStyle(styleContent);
                SXSSFCell sheetcell23 = sheet_row1.createCell(22);
                sheetcell23.setCellValue("P17");
                sheetcell23.setCellStyle(styleContent);
                SXSSFCell sheetcell24 = sheet_row1.createCell(23);
                sheetcell24.setCellValue("P18");
                sheetcell24.setCellStyle(styleContent);
                SXSSFCell sheetcell25 = sheet_row1.createCell(24);
                sheetcell25.setCellValue("P19");
                sheetcell25.setCellStyle(styleContent);
                SXSSFCell sheetcell26 = sheet_row1.createCell(25);
                sheetcell26.setCellValue("P20");
                sheetcell26.setCellStyle(styleContent);
                SXSSFCell sheetcell27 = sheet_row1.createCell(26);
                sheetcell27.setCellValue("P21");
                sheetcell27.setCellStyle(styleContent);
                SXSSFCell sheetcell28 = sheet_row1.createCell(27);
                sheetcell28.setCellValue("P22");
                sheetcell28.setCellStyle(styleContent);
                SXSSFCell sheetcell29 = sheet_row1.createCell(28);
                sheetcell29.setCellValue("P23");
                sheetcell29.setCellStyle(styleContent);
                SXSSFCell sheetcell30 = sheet_row1.createCell(29);
                sheetcell30.setCellValue("P24");
                sheetcell30.setCellStyle(styleContent);
                SXSSFCell sheetcell31 = sheet_row1.createCell(30);
                sheetcell31.setCellValue("P25");
                sheetcell31.setCellStyle(styleContent);
                SXSSFCell sheetcell32 = sheet_row1.createCell(31);
                sheetcell32.setCellValue("P26");
                sheetcell32.setCellStyle(styleContent);
                SXSSFCell sheetcell33 = sheet_row1.createCell(32);
                sheetcell33.setCellValue("P27");
                sheetcell33.setCellStyle(styleContent);
                SXSSFCell sheetcell34 = sheet_row1.createCell(33);
                sheetcell34.setCellValue("P28");
                sheetcell34.setCellStyle(styleContent);
                SXSSFCell sheetcell35 = sheet_row1.createCell(34);
                sheetcell35.setCellValue("P29");
                sheetcell35.setCellStyle(styleContent);
                SXSSFCell sheetcell36 = sheet_row1.createCell(35);
                sheetcell36.setCellValue("P30");
                sheetcell36.setCellStyle(styleContent);
                SXSSFCell sheetcell37 = sheet_row1.createCell(36);
                sheetcell37.setCellValue("P31");
                sheetcell37.setCellStyle(styleContent);
                SXSSFCell sheetcell38 = sheet_row1.createCell(37);
                sheetcell38.setCellValue("P32");
                sheetcell38.setCellStyle(styleContent);
                SXSSFCell sheetcell39 = sheet_row1.createCell(38);
                sheetcell39.setCellValue("P33");
                sheetcell39.setCellStyle(styleContent);
                SXSSFCell sheetcell40 = sheet_row1.createCell(39);
                sheetcell40.setCellValue("P34");
                sheetcell40.setCellStyle(styleContent);
                SXSSFCell sheetcell41 = sheet_row1.createCell(40);
                sheetcell41.setCellValue("P35");
                sheetcell41.setCellStyle(styleContent);
                SXSSFCell sheetcell42 = sheet_row1.createCell(41);
                sheetcell42.setCellValue("P36");
                sheetcell42.setCellStyle(styleContent);
                SXSSFCell sheetcell43 = sheet_row1.createCell(42);
                sheetcell43.setCellValue("P37");
                sheetcell43.setCellStyle(styleContent);
                SXSSFCell sheetcell44 = sheet_row1.createCell(43);
                sheetcell44.setCellValue("P38");
                sheetcell44.setCellStyle(styleContent);
                SXSSFCell sheetcell45 = sheet_row1.createCell(44);
                sheetcell45.setCellValue("P39");
                sheetcell45.setCellStyle(styleContent);
                SXSSFCell sheetcell46 = sheet_row1.createCell(45);
                sheetcell46.setCellValue("P40");
                sheetcell46.setCellStyle(styleContent);
                SXSSFCell sheetcell47 = sheet_row1.createCell(46);
                sheetcell47.setCellValue("P41");
                sheetcell47.setCellStyle(styleContent);
                SXSSFCell sheetcell48 = sheet_row1.createCell(47);
                sheetcell48.setCellValue("P42");
                sheetcell48.setCellStyle(styleContent);
                SXSSFCell sheetcell49 = sheet_row1.createCell(48);
                sheetcell49.setCellValue("P43");
                sheetcell49.setCellStyle(styleContent);
                SXSSFCell sheetcell50 = sheet_row1.createCell(49);
                sheetcell50.setCellValue("P44");
                sheetcell50.setCellStyle(styleContent);
                SXSSFCell sheetcell51 = sheet_row1.createCell(50);
                sheetcell51.setCellValue("P45");
                sheetcell51.setCellStyle(styleContent);
                SXSSFCell sheetcell52 = sheet_row1.createCell(51);
                sheetcell52.setCellValue("P46");
                sheetcell52.setCellStyle(styleContent);
                SXSSFCell sheetcell53 = sheet_row1.createCell(52);
                sheetcell53.setCellValue("P47");
                sheetcell53.setCellStyle(styleContent);
                SXSSFCell sheetcell54 = sheet_row1.createCell(53);
                sheetcell54.setCellValue("P48");
                sheetcell54.setCellStyle(styleContent);
                SXSSFCell sheetcell55 = sheet_row1.createCell(54);
                sheetcell55.setCellValue("P49");
                sheetcell55.setCellStyle(styleContent);
                SXSSFCell sheetcell56 = sheet_row1.createCell(55);
                sheetcell56.setCellValue("P50");
                sheetcell56.setCellStyle(styleContent);
                SXSSFCell sheetcell57 = sheet_row1.createCell(56);
                sheetcell57.setCellValue("P51");
                sheetcell57.setCellStyle(styleContent);
                SXSSFCell sheetcell58 = sheet_row1.createCell(57);
                sheetcell58.setCellValue("P52");
                sheetcell58.setCellStyle(styleContent);
                SXSSFCell sheetcell59 = sheet_row1.createCell(58);
                sheetcell59.setCellValue("P53");
                sheetcell59.setCellStyle(styleContent);
                SXSSFCell sheetcell60 = sheet_row1.createCell(59);
                sheetcell60.setCellValue("P54");
                sheetcell60.setCellStyle(styleContent);
                SXSSFCell sheetcell61 = sheet_row1.createCell(60);
                sheetcell61.setCellValue("P55");
                sheetcell61.setCellStyle(styleContent);
                SXSSFCell sheetcell62 = sheet_row1.createCell(61);
                sheetcell62.setCellValue("P56");
                sheetcell62.setCellStyle(styleContent);
                SXSSFCell sheetcell63 = sheet_row1.createCell(62);
                sheetcell63.setCellValue("P57");
                sheetcell63.setCellStyle(styleContent);
                SXSSFCell sheetcell64 = sheet_row1.createCell(63);
                sheetcell64.setCellValue("P58");
                sheetcell64.setCellStyle(styleContent);
                SXSSFCell sheetcell65 = sheet_row1.createCell(64);
                sheetcell65.setCellValue("P59");
                sheetcell65.setCellStyle(styleContent);
                SXSSFCell sheetcell66 = sheet_row1.createCell(65);
                sheetcell66.setCellValue("P60");
                sheetcell66.setCellStyle(styleContent);
                SXSSFCell sheetcell67 = sheet_row1.createCell(66);
                sheetcell67.setCellValue("P61");
                sheetcell67.setCellStyle(styleContent);
                SXSSFCell sheetcell68 = sheet_row1.createCell(67);
                sheetcell68.setCellValue("P62");
                sheetcell68.setCellStyle(styleContent);
                SXSSFCell sheetcell69 = sheet_row1.createCell(68);
                sheetcell69.setCellValue("P63");
                sheetcell69.setCellStyle(styleContent);
                SXSSFCell sheetcell70 = sheet_row1.createCell(69);
                sheetcell70.setCellValue("P64");
                sheetcell70.setCellStyle(styleContent);
                SXSSFCell sheetcell71 = sheet_row1.createCell(70);
                sheetcell71.setCellValue("P65");
                sheetcell71.setCellStyle(styleContent);
                SXSSFCell sheetcell72 = sheet_row1.createCell(71);
                sheetcell72.setCellValue("P66");
                sheetcell72.setCellStyle(styleContent);
                SXSSFCell sheetcell73 = sheet_row1.createCell(72);
                sheetcell73.setCellValue("P67");
                sheetcell73.setCellStyle(styleContent);
                SXSSFCell sheetcell74 = sheet_row1.createCell(73);
                sheetcell74.setCellValue("P68");
                sheetcell74.setCellStyle(styleContent);
                SXSSFCell sheetcell75 = sheet_row1.createCell(74);
                sheetcell75.setCellValue("P69");
                sheetcell75.setCellStyle(styleContent);
                SXSSFCell sheetcell76 = sheet_row1.createCell(75);
                sheetcell76.setCellValue("P70");
                sheetcell76.setCellStyle(styleContent);
                SXSSFCell sheetcell77 = sheet_row1.createCell(76);
                sheetcell77.setCellValue("P71");
                sheetcell77.setCellStyle(styleContent);
                SXSSFCell sheetcell78 = sheet_row1.createCell(77);
                sheetcell78.setCellValue("P72");
                sheetcell78.setCellStyle(styleContent);
                SXSSFCell sheetcell79 = sheet_row1.createCell(78);
                sheetcell79.setCellValue("P73");
                sheetcell79.setCellStyle(styleContent);
                SXSSFCell sheetcell80 = sheet_row1.createCell(79);
                sheetcell80.setCellValue("P74");
                sheetcell80.setCellStyle(styleContent);
                SXSSFCell sheetcell81 = sheet_row1.createCell(80);
                sheetcell81.setCellValue("P75");
                sheetcell81.setCellStyle(styleContent);
                SXSSFCell sheetcell82 = sheet_row1.createCell(81);
                sheetcell82.setCellValue("P76");
                sheetcell82.setCellStyle(styleContent);
                SXSSFCell sheetcell83 = sheet_row1.createCell(82);
                sheetcell83.setCellValue("P77");
                sheetcell83.setCellStyle(styleContent);
                SXSSFCell sheetcell84 = sheet_row1.createCell(83);
                sheetcell84.setCellValue("P78");
                sheetcell84.setCellStyle(styleContent);
                SXSSFCell sheetcell85 = sheet_row1.createCell(84);
                sheetcell85.setCellValue("P79");
                sheetcell85.setCellStyle(styleContent);
                SXSSFCell sheetcell86 = sheet_row1.createCell(85);
                sheetcell86.setCellValue("P80");
                sheetcell86.setCellStyle(styleContent);
                SXSSFCell sheetcell87 = sheet_row1.createCell(86);
                sheetcell87.setCellValue("P81");
                sheetcell87.setCellStyle(styleContent);
                SXSSFCell sheetcell88 = sheet_row1.createCell(87);
                sheetcell88.setCellValue("P82");
                sheetcell88.setCellStyle(styleContent);
                SXSSFCell sheetcell89 = sheet_row1.createCell(88);
                sheetcell89.setCellValue("P83");
                sheetcell89.setCellStyle(styleContent);
                SXSSFCell sheetcell90 = sheet_row1.createCell(89);
                sheetcell90.setCellValue("P84");
                sheetcell90.setCellStyle(styleContent);
                SXSSFCell sheetcell91 = sheet_row1.createCell(90);
                sheetcell91.setCellValue("P85");
                sheetcell91.setCellStyle(styleContent);
                SXSSFCell sheetcell92 = sheet_row1.createCell(91);
                sheetcell92.setCellValue("P86");
                sheetcell92.setCellStyle(styleContent);
                SXSSFCell sheetcell93 = sheet_row1.createCell(92);
                sheetcell93.setCellValue("P87");
                sheetcell93.setCellStyle(styleContent);
                SXSSFCell sheetcell94 = sheet_row1.createCell(93);
                sheetcell94.setCellValue("P88");
                sheetcell94.setCellStyle(styleContent);
                SXSSFCell sheetcell95 = sheet_row1.createCell(94);
                sheetcell95.setCellValue("P89");
                sheetcell95.setCellStyle(styleContent);
                SXSSFCell sheetcell96 = sheet_row1.createCell(95);
                sheetcell96.setCellValue("P90");
                sheetcell96.setCellStyle(styleContent);
                SXSSFCell sheetcell97 = sheet_row1.createCell(96);
                sheetcell97.setCellValue("P91");
                sheetcell97.setCellStyle(styleContent);
                SXSSFCell sheetcell98 = sheet_row1.createCell(97);
                sheetcell98.setCellValue("P92");
                sheetcell98.setCellStyle(styleContent);
                SXSSFCell sheetcell99 = sheet_row1.createCell(98);
                sheetcell99.setCellValue("P93");
                sheetcell99.setCellStyle(styleContent);
                SXSSFCell sheetcell100 = sheet_row1.createCell(99);
                sheetcell100.setCellValue("P94");
                sheetcell100.setCellStyle(styleContent);
                SXSSFCell sheetcell101 = sheet_row1.createCell(100);
                sheetcell101.setCellValue("P95");
                sheetcell101.setCellStyle(styleContent);
                SXSSFCell sheetcell102 = sheet_row1.createCell(101);
                sheetcell102.setCellValue("P96");
                sheetcell102.setCellStyle(styleContent);
                SXSSFCell sheetcell103 = sheet_row1.createCell(102);
                sheetcell103.setCellValue("P97");
                sheetcell103.setCellStyle(styleContent);
                SXSSFCell sheetcell104 = sheet_row1.createCell(103);
                sheetcell104.setCellValue("P98");
                sheetcell104.setCellStyle(styleContent);
                SXSSFCell sheetcell105 = sheet_row1.createCell(104);
                sheetcell105.setCellValue("P99");
                sheetcell105.setCellStyle(styleContent);
                sheet_row = sheet_row+1;
                //数据渲染
                PRB pct =null;
                SXSSFRow sheet_rows = null;
                SXSSFCell sheetcell = null;
                for(int n = mus*m; n < mus*(m+1); n++){
                    if(n < total){
                        pct = list.get(n);
                        sheet_rows = sheet.createRow(sheet_row);
                        //sheet_rows.setHeight((short)200);//设置行高
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
                        sheetcell.setCellValue(pct.getP0());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(6);
                        sheetcell.setCellValue(pct.getP1());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(7);
                        sheetcell.setCellValue(pct.getP2());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(8);
                        sheetcell.setCellValue(pct.getP3());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(9);
                        sheetcell.setCellValue(pct.getP4());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(10);
                        sheetcell.setCellValue(pct.getP5());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(11);
                        sheetcell.setCellValue(pct.getP6());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(12);
                        sheetcell.setCellValue(pct.getP7());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(13);
                        sheetcell.setCellValue(pct.getP8());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(14);
                        sheetcell.setCellValue(pct.getP9());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(15);
                        sheetcell.setCellValue(pct.getP10());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(16);
                        sheetcell.setCellValue(pct.getP11());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(17);
                        sheetcell.setCellValue(pct.getP12());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(18);
                        sheetcell.setCellValue(pct.getP13());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(19);
                        sheetcell.setCellValue(pct.getP14());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(20);
                        sheetcell.setCellValue(pct.getP15());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(21);
                        sheetcell.setCellValue(pct.getP16());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(22);
                        sheetcell.setCellValue(pct.getP17());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(23);
                        sheetcell.setCellValue(pct.getP18());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(24);
                        sheetcell.setCellValue(pct.getP19());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(25);
                        sheetcell.setCellValue(pct.getP20());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(26);
                        sheetcell.setCellValue(pct.getP21());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(27);
                        sheetcell.setCellValue(pct.getP22());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(28);
                        sheetcell.setCellValue(pct.getP23());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(29);
                        sheetcell.setCellValue(pct.getP24());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(30);
                        sheetcell.setCellValue(pct.getP25());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(31);
                        sheetcell.setCellValue(pct.getP26());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(32);
                        sheetcell.setCellValue(pct.getP27());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(33);
                        sheetcell.setCellValue(pct.getP28());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(34);
                        sheetcell.setCellValue(pct.getP29());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(35);
                        sheetcell.setCellValue(pct.getP30());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(36);
                        sheetcell.setCellValue(pct.getP31());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(37);
                        sheetcell.setCellValue(pct.getP32());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(38);
                        sheetcell.setCellValue(pct.getP33());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(39);
                        sheetcell.setCellValue(pct.getP34());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(40);
                        sheetcell.setCellValue(pct.getP35());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(41);
                        sheetcell.setCellValue(pct.getP36());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(42);
                        sheetcell.setCellValue(pct.getP37());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(43);
                        sheetcell.setCellValue(pct.getP38());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(44);
                        sheetcell.setCellValue(pct.getP39());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(45);
                        sheetcell.setCellValue(pct.getP40());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(46);
                        sheetcell.setCellValue(pct.getP41());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(47);
                        sheetcell.setCellValue(pct.getP42());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(48);
                        sheetcell.setCellValue(pct.getP43());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(49);
                        sheetcell.setCellValue(pct.getP44());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(50);
                        sheetcell.setCellValue(pct.getP45());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(51);
                        sheetcell.setCellValue(pct.getP46());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(52);
                        sheetcell.setCellValue(pct.getP47());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(53);
                        sheetcell.setCellValue(pct.getP48());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(54);
                        sheetcell.setCellValue(pct.getP49());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(55);
                        sheetcell.setCellValue(pct.getP50());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(56);
                        sheetcell.setCellValue(pct.getP51());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(57);
                        sheetcell.setCellValue(pct.getP52());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(58);
                        sheetcell.setCellValue(pct.getP53());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(59);
                        sheetcell.setCellValue(pct.getP54());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(60);
                        sheetcell.setCellValue(pct.getP55());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(61);
                        sheetcell.setCellValue(pct.getP56());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(62);
                        sheetcell.setCellValue(pct.getP57());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(63);
                        sheetcell.setCellValue(pct.getP58());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(64);
                        sheetcell.setCellValue(pct.getP59());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(65);
                        sheetcell.setCellValue(pct.getP60());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(66);
                        sheetcell.setCellValue(pct.getP61());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(67);
                        sheetcell.setCellValue(pct.getP62());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(68);
                        sheetcell.setCellValue(pct.getP63());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(69);
                        sheetcell.setCellValue(pct.getP64());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(70);
                        sheetcell.setCellValue(pct.getP65());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(71);
                        sheetcell.setCellValue(pct.getP66());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(72);
                        sheetcell.setCellValue(pct.getP67());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(73);
                        sheetcell.setCellValue(pct.getP68());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(74);
                        sheetcell.setCellValue(pct.getP69());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(75);
                        sheetcell.setCellValue(pct.getP70());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(76);
                        sheetcell.setCellValue(pct.getP71());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(77);
                        sheetcell.setCellValue(pct.getP72());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(78);
                        sheetcell.setCellValue(pct.getP73());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(79);
                        sheetcell.setCellValue(pct.getP74());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(80);
                        sheetcell.setCellValue(pct.getP75());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(81);
                        sheetcell.setCellValue(pct.getP76());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(82);
                        sheetcell.setCellValue(pct.getP77());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(83);
                        sheetcell.setCellValue(pct.getP78());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(84);
                        sheetcell.setCellValue(pct.getP79());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(85);
                        sheetcell.setCellValue(pct.getP80());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(86);
                        sheetcell.setCellValue(pct.getP81());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(87);
                        sheetcell.setCellValue(pct.getP82());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(88);
                        sheetcell.setCellValue(pct.getP83());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(89);
                        sheetcell.setCellValue(pct.getP84());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(90);
                        sheetcell.setCellValue(pct.getP85());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(91);
                        sheetcell.setCellValue(pct.getP86());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(92);
                        sheetcell.setCellValue(pct.getP87());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(93);
                        sheetcell.setCellValue(pct.getP88());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(94);
                        sheetcell.setCellValue(pct.getP89());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(95);
                        sheetcell.setCellValue(pct.getP90());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(96);
                        sheetcell.setCellValue(pct.getP91());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(97);
                        sheetcell.setCellValue(pct.getP92());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(98);
                        sheetcell.setCellValue(pct.getP93());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(99);
                        sheetcell.setCellValue(pct.getP94());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(100);
                        sheetcell.setCellValue(pct.getP95());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(101);
                        sheetcell.setCellValue(pct.getP96());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(102);
                        sheetcell.setCellValue(pct.getP97());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(103);
                        sheetcell.setCellValue(pct.getP98());
                        sheetcell.setCellStyle(style);
                        sheetcell = sheet_rows.createCell(104);
                        sheetcell.setCellValue(pct.getP99());
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
}

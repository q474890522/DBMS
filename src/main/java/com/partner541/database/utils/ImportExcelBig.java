package com.partner541.database.utils;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.partner541.database.dao.PRBDao;
import com.partner541.database.model.PRB;
import com.partner541.database.model.TbCell;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

@Component
public class ImportExcelBig extends DefaultHandler{

    @Autowired
    PRBDao prbDao;

    private SharedStringsTable sst;
    private String lastContents;
    private boolean nextIsString;

    private int sheetIndex = -1;
    private List<String> rowlist = new ArrayList<String>();
    private int curRow = 0;
    private int curCol = 0;


    /**
     * 读取第一个工作簿的入口方法
     * @param in
     */
    public int readOneSheet(InputStream in) throws Exception {
        OPCPackage pkg = OPCPackage.open(in);
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst);

        InputStream sheet = r.getSheet("rId1");

        InputSource sheetSource = new InputSource(sheet);
        parser.parse(sheetSource);

        sheet.close();
        return curRow - 1;
    }


    /**
     * 读取所有工作簿的入口方法
     * @param path
     * @throws Exception
     */
    public void process(String path) throws Exception {
        OPCPackage pkg = OPCPackage.open(path);
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst);

        Iterator<InputStream> sheets = r.getSheetsData();
        while (sheets.hasNext()) {
            curRow = 0;
            sheetIndex++;
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
        }
    }

    private static Date strToDate(String obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(obj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static double strToDouble(String str) {
        double db = Double.valueOf(str);
        return db;
    }

    private static int strToInt(String str) {
        return Integer.valueOf(str);
    }

    /**
     * 该方法自动被调用，每读一行调用一次，在方法中写自己的业务逻辑即可
     * @param sheetIndex 工作簿序号
     * @param curRow 处理到第几行
     * @param rowList 当前数据行的数据集合
     */
    public void optRow(int sheetIndex, int curRow, List<String> rowList) {
//        String temp = "";
//        for(String str : rowList) {
//            temp += str + "_";
//        }
//        System.out.println(temp);
        if(curRow ==0) return;
        PRB prb = new PRB();
        prb.setSTARTTIME(strToDate(rowList.get(0)));
        prb.setCYCLE(strToInt(rowList.get(1)));
        prb.setNENAME(rowList.get(2));
        prb.setSECTOR(rowList.get(3));
        prb.setSECTORNAME(rowList.get(4));
        prb.setP0(strToInt(rowList.get(5)));
        prb.setP1(strToInt(rowList.get(6)));
        prb.setP2(strToInt(rowList.get(7)));
        prb.setP3(strToInt(rowList.get(8)));
        prb.setP4(strToInt(rowList.get(9)));
        prb.setP5(strToInt(rowList.get(10)));
        prb.setP6(strToInt(rowList.get(11)));
        prb.setP7(strToInt(rowList.get(12)));
        prb.setP8(strToInt(rowList.get(13)));
        prb.setP9(strToInt(rowList.get(14)));
        prb.setP10(strToInt(rowList.get(15)));
        prb.setP11(strToInt(rowList.get(16)));
        prb.setP12(strToInt(rowList.get(17)));
        prb.setP13(strToInt(rowList.get(18)));
        prb.setP14(strToInt(rowList.get(19)));
        prb.setP15(strToInt(rowList.get(20)));
        prb.setP16(strToInt(rowList.get(21)));
        prb.setP17(strToInt(rowList.get(22)));
        prb.setP18(strToInt(rowList.get(23)));
        prb.setP19(strToInt(rowList.get(24)));
        prb.setP20(strToInt(rowList.get(25)));
        prb.setP21(strToInt(rowList.get(26)));
        prb.setP22(strToInt(rowList.get(27)));
        prb.setP23(strToInt(rowList.get(28)));
        prb.setP24(strToInt(rowList.get(29)));
        prb.setP25(strToInt(rowList.get(30)));
        prb.setP26(strToInt(rowList.get(31)));
        prb.setP27(strToInt(rowList.get(32)));
        prb.setP28(strToInt(rowList.get(33)));
        prb.setP29(strToInt(rowList.get(34)));
        prb.setP30(strToInt(rowList.get(35)));
        prb.setP31(strToInt(rowList.get(36)));
        prb.setP32(strToInt(rowList.get(37)));
        prb.setP33(strToInt(rowList.get(38)));
        prb.setP34(strToInt(rowList.get(39)));
        prb.setP35(strToInt(rowList.get(40)));
        prb.setP36(strToInt(rowList.get(41)));
        prb.setP37(strToInt(rowList.get(42)));
        prb.setP38(strToInt(rowList.get(43)));
        prb.setP39(strToInt(rowList.get(44)));
        prb.setP40(strToInt(rowList.get(45)));
        prb.setP41(strToInt(rowList.get(46)));
        prb.setP42(strToInt(rowList.get(47)));
        prb.setP43(strToInt(rowList.get(48)));
        prb.setP44(strToInt(rowList.get(49)));
        prb.setP45(strToInt(rowList.get(50)));
        prb.setP46(strToInt(rowList.get(51)));
        prb.setP47(strToInt(rowList.get(52)));
        prb.setP48(strToInt(rowList.get(53)));
        prb.setP49(strToInt(rowList.get(54)));
        prb.setP50(strToInt(rowList.get(55)));
        prb.setP51(strToInt(rowList.get(56)));
        prb.setP52(strToInt(rowList.get(57)));
        prb.setP53(strToInt(rowList.get(58)));
        prb.setP54(strToInt(rowList.get(59)));
        prb.setP55(strToInt(rowList.get(60)));
        prb.setP56(strToInt(rowList.get(61)));
        prb.setP57(strToInt(rowList.get(62)));
        prb.setP58(strToInt(rowList.get(63)));
        prb.setP59(strToInt(rowList.get(64)));
        prb.setP60(strToInt(rowList.get(65)));
        prb.setP61(strToInt(rowList.get(66)));
        prb.setP62(strToInt(rowList.get(67)));
        prb.setP63(strToInt(rowList.get(68)));
        prb.setP64(strToInt(rowList.get(69)));
        prb.setP65(strToInt(rowList.get(70)));
        prb.setP66(strToInt(rowList.get(71)));
        prb.setP67(strToInt(rowList.get(72)));
        prb.setP68(strToInt(rowList.get(73)));
        prb.setP69(strToInt(rowList.get(74)));
        prb.setP70(strToInt(rowList.get(75)));
        prb.setP71(strToInt(rowList.get(76)));
        prb.setP72(strToInt(rowList.get(77)));
        prb.setP73(strToInt(rowList.get(78)));
        prb.setP74(strToInt(rowList.get(79)));
        prb.setP75(strToInt(rowList.get(80)));
        prb.setP76(strToInt(rowList.get(81)));
        prb.setP77(strToInt(rowList.get(82)));
        prb.setP78(strToInt(rowList.get(83)));
        prb.setP79(strToInt(rowList.get(84)));
        prb.setP80(strToInt(rowList.get(85)));
        prb.setP81(strToInt(rowList.get(86)));
        prb.setP82(strToInt(rowList.get(87)));
        prb.setP83(strToInt(rowList.get(88)));
        prb.setP84(strToInt(rowList.get(89)));
        prb.setP85(strToInt(rowList.get(90)));
        prb.setP86(strToInt(rowList.get(91)));
        prb.setP87(strToInt(rowList.get(92)));
        prb.setP88(strToInt(rowList.get(93)));
        prb.setP89(strToInt(rowList.get(94)));
        prb.setP90(strToInt(rowList.get(95)));
        prb.setP91(strToInt(rowList.get(96)));
        prb.setP92(strToInt(rowList.get(97)));
        prb.setP93(strToInt(rowList.get(98)));
        prb.setP94(strToInt(rowList.get(99)));
        prb.setP95(strToInt(rowList.get(100)));
        prb.setP96(strToInt(rowList.get(101)));
        prb.setP97(strToInt(rowList.get(102)));
        prb.setP98(strToInt(rowList.get(103)));
        prb.setP99(strToInt(rowList.get(104)));

        prbDao.insertPRB(prb);
    }


    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser = XMLReaderFactory
                .createXMLReader("org.apache.xerces.parsers.SAXParser");
        this.sst = sst;
        parser.setContentHandler(this);
        return parser;
    }

    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        // c => 单元格
        if (name.equals("c")) {
            // 如果下一个元素是 SST 的索引，则将nextIsString标记为true
            String cellType = attributes.getValue("t");
            if (cellType != null && cellType.equals("s")) {
                nextIsString = true;
            } else {
                nextIsString = false;
            }
        }
        // 置空
        lastContents = "";
    }


    public void endElement(String uri, String localName, String name)
            throws SAXException {
        // 根据SST的索引值的到单元格的真正要存储的字符串
        // 这时characters()方法可能会被调用多次
        if (nextIsString) {
            try {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx))
                        .toString();
            } catch (Exception e) {

            }
        }

        // v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引
        // 将单元格内容加入rowlist中，在这之前先去掉字符串前后的空白符
        if (name.equals("v")) {
            String value = lastContents.trim();
            value = value.equals("") ? " " : value;
            rowlist.add(curCol, value);
            curCol++;
        } else {
            // 如果标签名称为 row ，这说明已到行尾，调用 optRows() 方法
            if (name.equals("row")) {
                optRow(sheetIndex, curRow, rowlist);
                rowlist.clear();
                curRow++;
                curCol = 0;
            }
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // 得到单元格内容的值
        lastContents += new String(ch, start, length);
    }
}

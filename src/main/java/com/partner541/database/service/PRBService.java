package com.partner541.database.service;

import com.partner541.database.dao.PRBDao;
import com.partner541.database.model.PRB;
import com.partner541.database.model.KPI;
import com.partner541.database.model.PRB;
import com.partner541.database.model.PRBpor;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void getHPRBnew(Date startT, Date endT, long granularity) {
        List<PRB> list = prbDao.getPRB();
        List<PRB> listnew = new ArrayList<>();
        int m = list.size();
        Date date = new Date();
        date.getTime();
        Date start0 = new Date();//起始时间
        start0.setTime(startT.getTime());
        Date start2 = new Date();//终止时间
        start2.setTime(endT.getTime());
        long gran = granularity;//粒度
        String cell1, cell2;
        int rank = (int) (gran / (1000 * 60 * 15));

        while(start0.getTime() < start2.getTime()+gran ) {
            for (int i = 0; i < m; i++) {
                if (list.get(i).getSTARTTIME().getTime() >= start0.getTime()
                        && list.get(i).getSTARTTIME().getTime() < start0.getTime() + gran
                        && list.get(i).getSTARTTIME().getTime() <= start2.getTime()) {
                    int p0 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0;
                    int p10 = 0, p11 = 0, p12 = 0, p13 = 0, p14 = 0, p15 = 0, p16 = 0, p17 = 0, p18 = 0, p19 = 0;
                    int p20 = 0, p21 = 0, p22 = 0, p23 = 0, p24 = 0, p25 = 0, p26 = 0, p27 = 0, p28 = 0, p29 = 0;
                    int p30 = 0, p31 = 0, p32 = 0, p33 = 0, p34 = 0, p35 = 0, p36 = 0, p37 = 0, p38 = 0, p39 = 0;
                    int p40 = 0, p41 = 0, p42 = 0, p43 = 0, p44 = 0, p45 = 0, p46 = 0, p47 = 0, p48 = 0, p49 = 0;
                    int p50 = 0, p51 = 0, p52 = 0, p53 = 0, p54 = 0, p55 = 0, p56 = 0, p57 = 0, p58 = 0, p59 = 0;
                    int p60 = 0, p61 = 0, p62 = 0, p63 = 0, p64 = 0, p65 = 0, p66 = 0, p67 = 0, p68 = 0, p69 = 0;
                    int p70 = 0, p71 = 0, p72 = 0, p73 = 0, p74 = 0, p75 = 0, p76 = 0, p77 = 0, p78 = 0, p79 = 0;
                    int p80 = 0, p81 = 0, p82 = 0, p83 = 0, p84 = 0, p85 = 0, p86 = 0, p87 = 0, p88 = 0, p89 = 0;
                    int p90 = 0, p91 = 0, p92 = 0, p93 = 0, p94 = 0, p95 = 0, p96 = 0, p97 = 0, p98 = 0, p99 = 0;
                    int ave = 0;
                    cell1 = list.get(i).getSECTOR();
                    cell2 = list.get(i).getSECTORNAME();
                    PRB prb = new PRB();
                    for (int t = i; t < m; t++) {
                        if (list.get(t).getSECTOR().equals(cell1) && list.get(t).getSECTORNAME().equals(cell2)
                                && list.get(t).getSTARTTIME().getTime() >= start0.getTime()
                                && list.get(t).getSTARTTIME().getTime() < start0.getTime() + gran
                                && list.get(t).getSTARTTIME().getTime() <= start2.getTime()) {
                            p0 = list.get(t).getP0() + p0;
                            p1 = list.get(t).getP1() + p1;
                            p2 = list.get(t).getP2() + p2;
                            p3 = list.get(t).getP3() + p3;
                            p4 = list.get(t).getP4() + p4;
                            p5 = list.get(t).getP5() + p5;
                            p6 = list.get(t).getP6() + p6;
                            p7 = list.get(t).getP7() + p7;
                            p8 = list.get(t).getP8() + p8;
                            p9 = list.get(t).getP9() + p9;

                            p10 = list.get(t).getP10() + p10;
                            p11 = list.get(t).getP11() + p11;
                            p12 = list.get(t).getP12() + p12;
                            p13 = list.get(t).getP13() + p13;
                            p14 = list.get(t).getP14() + p14;
                            p15 = list.get(t).getP15() + p15;
                            p16 = list.get(t).getP16() + p16;
                            p17 = list.get(t).getP17() + p17;
                            p18 = list.get(t).getP18() + p18;
                            p19 = list.get(t).getP19() + p19;

                            p20 = list.get(t).getP20() + p20;
                            p21 = list.get(t).getP21() + p21;
                            p22 = list.get(t).getP22() + p22;
                            p23 = list.get(t).getP23() + p23;
                            p24 = list.get(t).getP24() + p24;
                            p25 = list.get(t).getP25() + p25;
                            p26 = list.get(t).getP26() + p26;
                            p27 = list.get(t).getP27() + p27;
                            p28 = list.get(t).getP28() + p28;
                            p29 = list.get(t).getP29() + p29;

                            p30 = list.get(t).getP30() + p30;
                            p31 = list.get(t).getP31() + p31;
                            p32 = list.get(t).getP32() + p32;
                            p33 = list.get(t).getP33() + p33;
                            p34 = list.get(t).getP34() + p34;
                            p35 = list.get(t).getP35() + p35;
                            p36 = list.get(t).getP36() + p36;
                            p37 = list.get(t).getP37() + p37;
                            p38 = list.get(t).getP38() + p38;
                            p39 = list.get(t).getP39() + p39;

                            p40 = list.get(t).getP40() + p40;
                            p41 = list.get(t).getP41() + p41;
                            p42 = list.get(t).getP42() + p42;
                            p43 = list.get(t).getP43() + p43;
                            p44 = list.get(t).getP44() + p44;
                            p45 = list.get(t).getP45() + p45;
                            p46 = list.get(t).getP46() + p46;
                            p47 = list.get(t).getP47() + p47;
                            p48 = list.get(t).getP48() + p48;
                            p49 = list.get(t).getP49() + p49;

                            p50 = list.get(t).getP50() + p50;
                            p51 = list.get(t).getP51() + p51;
                            p52 = list.get(t).getP52() + p52;
                            p53 = list.get(t).getP53() + p53;
                            p54 = list.get(t).getP54() + p54;
                            p55 = list.get(t).getP55() + p55;
                            p56 = list.get(t).getP56() + p56;
                            p57 = list.get(t).getP57() + p57;
                            p58 = list.get(t).getP58() + p58;
                            p59 = list.get(t).getP59() + p59;

                            p60 = list.get(t).getP60() + p60;
                            p61 = list.get(t).getP61() + p61;
                            p62 = list.get(t).getP62() + p62;
                            p63 = list.get(t).getP63() + p63;
                            p64 = list.get(t).getP64() + p64;
                            p65 = list.get(t).getP65() + p65;
                            p66 = list.get(t).getP66() + p66;
                            p67 = list.get(t).getP67() + p67;
                            p68 = list.get(t).getP68() + p68;
                            p69 = list.get(t).getP69() + p69;

                            p70 = list.get(t).getP70() + p70;
                            p71 = list.get(t).getP71() + p71;
                            p72 = list.get(t).getP72() + p72;
                            p73 = list.get(t).getP73() + p73;
                            p74 = list.get(t).getP74() + p74;
                            p75 = list.get(t).getP75() + p75;
                            p76 = list.get(t).getP76() + p76;
                            p77 = list.get(t).getP77() + p77;
                            p78 = list.get(t).getP78() + p78;
                            p79 = list.get(t).getP79() + p79;

                            p80 = list.get(t).getP80() + p80;
                            p81 = list.get(t).getP81() + p81;
                            p82 = list.get(t).getP82() + p82;
                            p83 = list.get(t).getP83() + p83;
                            p84 = list.get(t).getP84() + p84;
                            p85 = list.get(t).getP85() + p85;
                            p86 = list.get(t).getP86() + p86;
                            p87 = list.get(t).getP87() + p87;
                            p88 = list.get(t).getP88() + p88;
                            p89 = list.get(t).getP89() + p89;

                            p90 = list.get(t).getP90() + p90;
                            p91 = list.get(t).getP91() + p91;
                            p92 = list.get(t).getP92() + p92;
                            p93 = list.get(t).getP93() + p93;
                            p94 = list.get(t).getP94() + p94;
                            p95 = list.get(t).getP95() + p95;
                            p96 = list.get(t).getP96() + p96;
                            p97 = list.get(t).getP97() + p97;
                            p98 = list.get(t).getP98() + p98;
                            p99 = list.get(t).getP99() + p99;

                            list.remove(t);
                            m--;
                            t--;
                        }
                    }
                    p0 = (int) (p0 / (gran / (1000 * 60 * 15)));
                    p1 = (int) (p1 / (gran / (1000 * 60 * 15)));
                    p2 = (int) (p2 / (gran / (1000 * 60 * 15)));
                    p3 = (int) (p3 / (gran / (1000 * 60 * 15)));
                    p4 = (int) (p4 / (gran / (1000 * 60 * 15)));
                    p5 = (int) (p5 / (gran / (1000 * 60 * 15)));
                    p6 = (int) (p6 / (gran / (1000 * 60 * 15)));
                    p7 = (int) (p7 / (gran / (1000 * 60 * 15)));
                    p8 = (int) (p8 / (gran / (1000 * 60 * 15)));
                    p9 = (int) (p9 / (gran / (1000 * 60 * 15)));

                    p10 = (int) (p10 / (gran / (1000 * 60 * 15)));
                    p11 = (int) (p11 / (gran / (1000 * 60 * 15)));
                    p12 = (int) (p12 / (gran / (1000 * 60 * 15)));
                    p13 = (int) (p13 / (gran / (1000 * 60 * 15)));
                    p14 = (int) (p14 / (gran / (1000 * 60 * 15)));
                    p15 = (int) (p15 / (gran / (1000 * 60 * 15)));
                    p16 = (int) (p16 / (gran / (1000 * 60 * 15)));
                    p17 = (int) (p17 / (gran / (1000 * 60 * 15)));
                    p18 = (int) (p18 / (gran / (1000 * 60 * 15)));
                    p19 = (int) (p19 / (gran / (1000 * 60 * 15)));

                    p20 = (int) (p20 / (gran / (1000 * 60 * 15)));
                    p21 = (int) (p21 / (gran / (1000 * 60 * 15)));
                    p22 = (int) (p22 / (gran / (1000 * 60 * 15)));
                    p23 = (int) (p23 / (gran / (1000 * 60 * 15)));
                    p24 = (int) (p24 / (gran / (1000 * 60 * 15)));
                    p25 = (int) (p25 / (gran / (1000 * 60 * 15)));
                    p26 = (int) (p26 / (gran / (1000 * 60 * 15)));
                    p27 = (int) (p27 / (gran / (1000 * 60 * 15)));
                    p28 = (int) (p28 / (gran / (1000 * 60 * 15)));
                    p29 = (int) (p29 / (gran / (1000 * 60 * 15)));

                    p30 = (int) (p30 / (gran / (1000 * 60 * 15)));
                    p31 = (int) (p31 / (gran / (1000 * 60 * 15)));
                    p32 = (int) (p32 / (gran / (1000 * 60 * 15)));
                    p33 = (int) (p33 / (gran / (1000 * 60 * 15)));
                    p34 = (int) (p34 / (gran / (1000 * 60 * 15)));
                    p35 = (int) (p35 / (gran / (1000 * 60 * 15)));
                    p36 = (int) (p36 / (gran / (1000 * 60 * 15)));
                    p37 = (int) (p37 / (gran / (1000 * 60 * 15)));
                    p38 = (int) (p38 / (gran / (1000 * 60 * 15)));
                    p39 = (int) (p39 / (gran / (1000 * 60 * 15)));

                    p40 = (int) (p40 / (gran / (1000 * 60 * 15)));
                    p41 = (int) (p41 / (gran / (1000 * 60 * 15)));
                    p42 = (int) (p42 / (gran / (1000 * 60 * 15)));
                    p43 = (int) (p43 / (gran / (1000 * 60 * 15)));
                    p44 = (int) (p44 / (gran / (1000 * 60 * 15)));
                    p45 = (int) (p45 / (gran / (1000 * 60 * 15)));
                    p46 = (int) (p46 / (gran / (1000 * 60 * 15)));
                    p47 = (int) (p47 / (gran / (1000 * 60 * 15)));
                    p48 = (int) (p48 / (gran / (1000 * 60 * 15)));
                    p49 = (int) (p49 / (gran / (1000 * 60 * 15)));

                    p50 = (int) (p50 / (gran / (1000 * 60 * 15)));
                    p51 = (int) (p51 / (gran / (1000 * 60 * 15)));
                    p52 = (int) (p52 / (gran / (1000 * 60 * 15)));
                    p53 = (int) (p53 / (gran / (1000 * 60 * 15)));
                    p54 = (int) (p54 / (gran / (1000 * 60 * 15)));
                    p55 = (int) (p55 / (gran / (1000 * 60 * 15)));
                    p56 = (int) (p56 / (gran / (1000 * 60 * 15)));
                    p57 = (int) (p57 / (gran / (1000 * 60 * 15)));
                    p58 = (int) (p58 / (gran / (1000 * 60 * 15)));
                    p59 = (int) (p59 / (gran / (1000 * 60 * 15)));

                    p60 = (int) (p60 / (gran / (1000 * 60 * 15)));
                    p61 = (int) (p61 / (gran / (1000 * 60 * 15)));
                    p62 = (int) (p62 / (gran / (1000 * 60 * 15)));
                    p63 = (int) (p63 / (gran / (1000 * 60 * 15)));
                    p64 = (int) (p64 / (gran / (1000 * 60 * 15)));
                    p65 = (int) (p65 / (gran / (1000 * 60 * 15)));
                    p66 = (int) (p66 / (gran / (1000 * 60 * 15)));
                    p67 = (int) (p67 / (gran / (1000 * 60 * 15)));
                    p68 = (int) (p68 / (gran / (1000 * 60 * 15)));
                    p69 = (int) (p69 / (gran / (1000 * 60 * 15)));

                    p70 = (int) (p70 / (gran / (1000 * 60 * 15)));
                    p71 = (int) (p71 / (gran / (1000 * 60 * 15)));
                    p72 = (int) (p72 / (gran / (1000 * 60 * 15)));
                    p73 = (int) (p73 / (gran / (1000 * 60 * 15)));
                    p74 = (int) (p74 / (gran / (1000 * 60 * 15)));
                    p75 = (int) (p75 / (gran / (1000 * 60 * 15)));
                    p76 = (int) (p76 / (gran / (1000 * 60 * 15)));
                    p77 = (int) (p77 / (gran / (1000 * 60 * 15)));
                    p78 = (int) (p78 / (gran / (1000 * 60 * 15)));
                    p79 = (int) (p79 / (gran / (1000 * 60 * 15)));

                    p80 = (int) (p80 / (gran / (1000 * 60 * 15)));
                    p81 = (int) (p81 / (gran / (1000 * 60 * 15)));
                    p82 = (int) (p82 / (gran / (1000 * 60 * 15)));
                    p83 = (int) (p83 / (gran / (1000 * 60 * 15)));
                    p84 = (int) (p84 / (gran / (1000 * 60 * 15)));
                    p85 = (int) (p85 / (gran / (1000 * 60 * 15)));
                    p86 = (int) (p86 / (gran / (1000 * 60 * 15)));
                    p87 = (int) (p87 / (gran / (1000 * 60 * 15)));
                    p88 = (int) (p88 / (gran / (1000 * 60 * 15)));
                    p89 = (int) (p89 / (gran / (1000 * 60 * 15)));

                    p90 = (int) (p90 / (gran / (1000 * 60 * 15)));
                    p91 = (int) (p91 / (gran / (1000 * 60 * 15)));
                    p92 = (int) (p92 / (gran / (1000 * 60 * 15)));
                    p93 = (int) (p93 / (gran / (1000 * 60 * 15)));
                    p94 = (int) (p94 / (gran / (1000 * 60 * 15)));
                    p95 = (int) (p95 / (gran / (1000 * 60 * 15)));
                    p96 = (int) (p96 / (gran / (1000 * 60 * 15)));
                    p97 = (int) (p97 / (gran / (1000 * 60 * 15)));
                    p98 = (int) (p98 / (gran / (1000 * 60 * 15)));
                    p99 = (int) (p99 / (gran / (1000 * 60 * 15)));

                    ave = ( p0 + p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 +
                            p10 + p11 + p12 + p13 + p14 + p15 + p16 + p17 + p18 + p19 +
                            p20 + p21 + p22 + p23 + p24 + p25 + p26 + p27 + p28 + p29 +
                            p30 + p31 + p32 + p33 + p34 + p35 + p36 + p37 + p38 + p39 +
                            p40 + p41 + p42 + p43 + p44 + p45 + p46 + p47 + p48 + p49 +
                            p50 + p51 + p52 + p53 + p54 + p55 + p56 + p57 + p58 + p59 +
                            p60 + p61 + p62 + p63 + p64 + p65 + p66 + p67 + p68 + p69 +
                            p70 + p71 + p72 + p73 + p74 + p75 + p76 + p77 + p78 + p79 +
                            p80 + p81 + p82 + p83 + p84 + p85 + p86 + p87 + p88 + p89 +
                            p90 + p91 + p92 + p93 + p94 + p95 + p96 + p97 + p98 + p99 )/100;

                    prb.setSTARTTIME(list.get(i).getSTARTTIME());
                    prb.setCYCLE(list.get(i).getCYCLE());
                    prb.setNENAME(list.get(i).getNENAME());
                    prb.setSECTOR(list.get(i).getSECTOR());
                    prb.setSECTORNAME(list.get(i).getSECTORNAME());
                    prb.setP0(p0);
                    prb.setP1(p1);
                    prb.setP2(p2);
                    prb.setP3(p3);
                    prb.setP4(p4);
                    prb.setP5(p5);
                    prb.setP6(p6);
                    prb.setP7(p7);
                    prb.setP8(p8);
                    prb.setP9(p9);

                    prb.setP10(p10);
                    prb.setP11(p11);
                    prb.setP12(p12);
                    prb.setP13(p13);
                    prb.setP14(p14);
                    prb.setP15(p15);
                    prb.setP16(p16);
                    prb.setP17(p17);
                    prb.setP18(p18);
                    prb.setP19(p19);

                    prb.setP20(p20);
                    prb.setP21(p21);
                    prb.setP22(p22);
                    prb.setP23(p23);
                    prb.setP24(p24);
                    prb.setP25(p25);
                    prb.setP26(p26);
                    prb.setP27(p27);
                    prb.setP28(p28);
                    prb.setP29(p29);

                    prb.setP30(p30);
                    prb.setP31(p31);
                    prb.setP32(p32);
                    prb.setP33(p33);
                    prb.setP34(p34);
                    prb.setP35(p35);
                    prb.setP36(p36);
                    prb.setP37(p37);
                    prb.setP38(p38);
                    prb.setP39(p39);

                    prb.setP40(p40);
                    prb.setP41(p41);
                    prb.setP42(p42);
                    prb.setP43(p43);
                    prb.setP44(p44);
                    prb.setP45(p45);
                    prb.setP46(p46);
                    prb.setP47(p47);
                    prb.setP48(p48);
                    prb.setP49(p49);

                    prb.setP50(p50);
                    prb.setP51(p51);
                    prb.setP52(p52);
                    prb.setP53(p53);
                    prb.setP54(p54);
                    prb.setP55(p55);
                    prb.setP56(p56);
                    prb.setP57(p57);
                    prb.setP58(p58);
                    prb.setP59(p59);

                    prb.setP60(p60);
                    prb.setP61(p61);
                    prb.setP62(p62);
                    prb.setP63(p63);
                    prb.setP64(p64);
                    prb.setP65(p65);
                    prb.setP66(p66);
                    prb.setP67(p67);
                    prb.setP68(p68);
                    prb.setP69(p69);

                    prb.setP70(p70);
                    prb.setP71(p71);
                    prb.setP72(p72);
                    prb.setP73(p73);
                    prb.setP74(p74);
                    prb.setP75(p75);
                    prb.setP76(p76);
                    prb.setP77(p77);
                    prb.setP78(p78);
                    prb.setP79(p79);

                    prb.setP80(p80);
                    prb.setP81(p81);
                    prb.setP82(p82);
                    prb.setP83(p83);
                    prb.setP84(p84);
                    prb.setP85(p85);
                    prb.setP86(p86);
                    prb.setP87(p87);
                    prb.setP88(p88);
                    prb.setP89(p89);

                    prb.setP90(p90);
                    prb.setP91(p91);
                    prb.setP92(p92);
                    prb.setP93(p93);
                    prb.setP94(p94);
                    prb.setP95(p95);
                    prb.setP96(p96);
                    prb.setP97(p97);
                    prb.setP98(p98);
                    prb.setP99(p99);
                    prb.setAve(ave);

                    listnew.add(prb);
                    //prbDao.insertPRBnew(prb);

                    i--;

                }
            }
            start0.setTime(start0.getTime() + gran);
        }

//        for (PRB c : list)
//            System.out.println(c.toString());
//        System.out.println(list.size());

        //排序
        Collections.sort(listnew, new Comparator<PRB>() {
            @Override
            public int compare(PRB o1, PRB o2) {
                return (int) (o1.getSTARTTIME().getTime() - o2.getSTARTTIME().getTime());
            }
        });
        //格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (PRB i : listnew) {
            try {
                String tt = sdf.format(i.getSTARTTIME());
                i.setSTARTTIME(sdf.parse(tt));
                prbDao.insertPRBnew(i);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public List<PRBpor> getXPRB(String name , Date startT, Date endT, long granularity , String P) {
        List<PRB> list = prbDao.getPRB();
        List<PRBpor> listnew = new ArrayList<>();
        int m = list.size();
        Date date = new Date();
        date.getTime();
        Date start0 = new Date();//起始时间
        start0.setTime(startT.getTime());
        Date start2 = new Date();//终止时间
        start2.setTime(endT.getTime());
        long gran = granularity;//粒度
        String cell1, cell2;
        int rank = (int) (gran / (1000 * 60 * 15));
        while(start0.getTime() < start2.getTime()+gran ) {
            for (int i = 0; i < m; i++) {
                if (list.get(i).getSTARTTIME().getTime() >= start0.getTime()
                        && list.get(i).getSTARTTIME().getTime() < start0.getTime() + gran
                        && list.get(i).getSTARTTIME().getTime() <= start2.getTime()
                        && list.get(i).getNENAME().equals(name)) {
                    System.out.println("****");
                    int p0 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0;
                    int p10 = 0, p11 = 0, p12 = 0, p13 = 0, p14 = 0, p15 = 0, p16 = 0, p17 = 0, p18 = 0, p19 = 0;
                    int p20 = 0, p21 = 0, p22 = 0, p23 = 0, p24 = 0, p25 = 0, p26 = 0, p27 = 0, p28 = 0, p29 = 0;
                    int p30 = 0, p31 = 0, p32 = 0, p33 = 0, p34 = 0, p35 = 0, p36 = 0, p37 = 0, p38 = 0, p39 = 0;
                    int p40 = 0, p41 = 0, p42 = 0, p43 = 0, p44 = 0, p45 = 0, p46 = 0, p47 = 0, p48 = 0, p49 = 0;
                    int p50 = 0, p51 = 0, p52 = 0, p53 = 0, p54 = 0, p55 = 0, p56 = 0, p57 = 0, p58 = 0, p59 = 0;
                    int p60 = 0, p61 = 0, p62 = 0, p63 = 0, p64 = 0, p65 = 0, p66 = 0, p67 = 0, p68 = 0, p69 = 0;
                    int p70 = 0, p71 = 0, p72 = 0, p73 = 0, p74 = 0, p75 = 0, p76 = 0, p77 = 0, p78 = 0, p79 = 0;
                    int p80 = 0, p81 = 0, p82 = 0, p83 = 0, p84 = 0, p85 = 0, p86 = 0, p87 = 0, p88 = 0, p89 = 0;
                    int p90 = 0, p91 = 0, p92 = 0, p93 = 0, p94 = 0, p95 = 0, p96 = 0, p97 = 0, p98 = 0, p99 = 0;
                    int ave = 0;
                    cell1 = list.get(i).getSECTOR();
                    cell2 = list.get(i).getSECTORNAME();
                    PRBpor prb = new PRBpor();
                    for (int t = i; t < m; t++) {
                        if (list.get(t).getSECTOR().equals(cell1) && list.get(t).getSECTORNAME().equals(cell2)
                                && list.get(t).getSTARTTIME().getTime() >= start0.getTime()
                                && list.get(t).getSTARTTIME().getTime() < start0.getTime() + gran
                                && list.get(t).getSTARTTIME().getTime() <= start2.getTime()
                                && list.get(i).getNENAME().equals(name)) {
                            p0 = list.get(t).getP0() + p0;
                            p1 = list.get(t).getP1() + p1;
                            p2 = list.get(t).getP2() + p2;
                            p3 = list.get(t).getP3() + p3;
                            p4 = list.get(t).getP4() + p4;
                            p5 = list.get(t).getP5() + p5;
                            p6 = list.get(t).getP6() + p6;
                            p7 = list.get(t).getP7() + p7;
                            p8 = list.get(t).getP8() + p8;
                            p9 = list.get(t).getP9() + p9;

                            p10 = list.get(t).getP10() + p10;
                            p11 = list.get(t).getP11() + p11;
                            p12 = list.get(t).getP12() + p12;
                            p13 = list.get(t).getP13() + p13;
                            p14 = list.get(t).getP14() + p14;
                            p15 = list.get(t).getP15() + p15;
                            p16 = list.get(t).getP16() + p16;
                            p17 = list.get(t).getP17() + p17;
                            p18 = list.get(t).getP18() + p18;
                            p19 = list.get(t).getP19() + p19;

                            p20 = list.get(t).getP20() + p20;
                            p21 = list.get(t).getP21() + p21;
                            p22 = list.get(t).getP22() + p22;
                            p23 = list.get(t).getP23() + p23;
                            p24 = list.get(t).getP24() + p24;
                            p25 = list.get(t).getP25() + p25;
                            p26 = list.get(t).getP26() + p26;
                            p27 = list.get(t).getP27() + p27;
                            p28 = list.get(t).getP28() + p28;
                            p29 = list.get(t).getP29() + p29;

                            p30 = list.get(t).getP30() + p30;
                            p31 = list.get(t).getP31() + p31;
                            p32 = list.get(t).getP32() + p32;
                            p33 = list.get(t).getP33() + p33;
                            p34 = list.get(t).getP34() + p34;
                            p35 = list.get(t).getP35() + p35;
                            p36 = list.get(t).getP36() + p36;
                            p37 = list.get(t).getP37() + p37;
                            p38 = list.get(t).getP38() + p38;
                            p39 = list.get(t).getP39() + p39;

                            p40 = list.get(t).getP40() + p40;
                            p41 = list.get(t).getP41() + p41;
                            p42 = list.get(t).getP42() + p42;
                            p43 = list.get(t).getP43() + p43;
                            p44 = list.get(t).getP44() + p44;
                            p45 = list.get(t).getP45() + p45;
                            p46 = list.get(t).getP46() + p46;
                            p47 = list.get(t).getP47() + p47;
                            p48 = list.get(t).getP48() + p48;
                            p49 = list.get(t).getP49() + p49;

                            p50 = list.get(t).getP50() + p50;
                            p51 = list.get(t).getP51() + p51;
                            p52 = list.get(t).getP52() + p52;
                            p53 = list.get(t).getP53() + p53;
                            p54 = list.get(t).getP54() + p54;
                            p55 = list.get(t).getP55() + p55;
                            p56 = list.get(t).getP56() + p56;
                            p57 = list.get(t).getP57() + p57;
                            p58 = list.get(t).getP58() + p58;
                            p59 = list.get(t).getP59() + p59;

                            p60 = list.get(t).getP60() + p60;
                            p61 = list.get(t).getP61() + p61;
                            p62 = list.get(t).getP62() + p62;
                            p63 = list.get(t).getP63() + p63;
                            p64 = list.get(t).getP64() + p64;
                            p65 = list.get(t).getP65() + p65;
                            p66 = list.get(t).getP66() + p66;
                            p67 = list.get(t).getP67() + p67;
                            p68 = list.get(t).getP68() + p68;
                            p69 = list.get(t).getP69() + p69;

                            p70 = list.get(t).getP70() + p70;
                            p71 = list.get(t).getP71() + p71;
                            p72 = list.get(t).getP72() + p72;
                            p73 = list.get(t).getP73() + p73;
                            p74 = list.get(t).getP74() + p74;
                            p75 = list.get(t).getP75() + p75;
                            p76 = list.get(t).getP76() + p76;
                            p77 = list.get(t).getP77() + p77;
                            p78 = list.get(t).getP78() + p78;
                            p79 = list.get(t).getP79() + p79;

                            p80 = list.get(t).getP80() + p80;
                            p81 = list.get(t).getP81() + p81;
                            p82 = list.get(t).getP82() + p82;
                            p83 = list.get(t).getP83() + p83;
                            p84 = list.get(t).getP84() + p84;
                            p85 = list.get(t).getP85() + p85;
                            p86 = list.get(t).getP86() + p86;
                            p87 = list.get(t).getP87() + p87;
                            p88 = list.get(t).getP88() + p88;
                            p89 = list.get(t).getP89() + p89;

                            p90 = list.get(t).getP90() + p90;
                            p91 = list.get(t).getP91() + p91;
                            p92 = list.get(t).getP92() + p92;
                            p93 = list.get(t).getP93() + p93;
                            p94 = list.get(t).getP94() + p94;
                            p95 = list.get(t).getP95() + p95;
                            p96 = list.get(t).getP96() + p96;
                            p97 = list.get(t).getP97() + p97;
                            p98 = list.get(t).getP98() + p98;
                            p99 = list.get(t).getP99() + p99;

                            list.remove(t);
                            m--;
                            t--;
                        }
                    }
                    p0 = (int) (p0 / (gran / (1000 * 60 * 15)));
                    p1 = (int) (p1 / (gran / (1000 * 60 * 15)));
                    p2 = (int) (p2 / (gran / (1000 * 60 * 15)));
                    p3 = (int) (p3 / (gran / (1000 * 60 * 15)));
                    p4 = (int) (p4 / (gran / (1000 * 60 * 15)));
                    p5 = (int) (p5 / (gran / (1000 * 60 * 15)));
                    p6 = (int) (p6 / (gran / (1000 * 60 * 15)));
                    p7 = (int) (p7 / (gran / (1000 * 60 * 15)));
                    p8 = (int) (p8 / (gran / (1000 * 60 * 15)));
                    p9 = (int) (p9 / (gran / (1000 * 60 * 15)));

                    p10 = (int) (p10 / (gran / (1000 * 60 * 15)));
                    p11 = (int) (p11 / (gran / (1000 * 60 * 15)));
                    p12 = (int) (p12 / (gran / (1000 * 60 * 15)));
                    p13 = (int) (p13 / (gran / (1000 * 60 * 15)));
                    p14 = (int) (p14 / (gran / (1000 * 60 * 15)));
                    p15 = (int) (p15 / (gran / (1000 * 60 * 15)));
                    p16 = (int) (p16 / (gran / (1000 * 60 * 15)));
                    p17 = (int) (p17 / (gran / (1000 * 60 * 15)));
                    p18 = (int) (p18 / (gran / (1000 * 60 * 15)));
                    p19 = (int) (p19 / (gran / (1000 * 60 * 15)));

                    p20 = (int) (p20 / (gran / (1000 * 60 * 15)));
                    p21 = (int) (p21 / (gran / (1000 * 60 * 15)));
                    p22 = (int) (p22 / (gran / (1000 * 60 * 15)));
                    p23 = (int) (p23 / (gran / (1000 * 60 * 15)));
                    p24 = (int) (p24 / (gran / (1000 * 60 * 15)));
                    p25 = (int) (p25 / (gran / (1000 * 60 * 15)));
                    p26 = (int) (p26 / (gran / (1000 * 60 * 15)));
                    p27 = (int) (p27 / (gran / (1000 * 60 * 15)));
                    p28 = (int) (p28 / (gran / (1000 * 60 * 15)));
                    p29 = (int) (p29 / (gran / (1000 * 60 * 15)));

                    p30 = (int) (p30 / (gran / (1000 * 60 * 15)));
                    p31 = (int) (p31 / (gran / (1000 * 60 * 15)));
                    p32 = (int) (p32 / (gran / (1000 * 60 * 15)));
                    p33 = (int) (p33 / (gran / (1000 * 60 * 15)));
                    p34 = (int) (p34 / (gran / (1000 * 60 * 15)));
                    p35 = (int) (p35 / (gran / (1000 * 60 * 15)));
                    p36 = (int) (p36 / (gran / (1000 * 60 * 15)));
                    p37 = (int) (p37 / (gran / (1000 * 60 * 15)));
                    p38 = (int) (p38 / (gran / (1000 * 60 * 15)));
                    p39 = (int) (p39 / (gran / (1000 * 60 * 15)));

                    p40 = (int) (p40 / (gran / (1000 * 60 * 15)));
                    p41 = (int) (p41 / (gran / (1000 * 60 * 15)));
                    p42 = (int) (p42 / (gran / (1000 * 60 * 15)));
                    p43 = (int) (p43 / (gran / (1000 * 60 * 15)));
                    p44 = (int) (p44 / (gran / (1000 * 60 * 15)));
                    p45 = (int) (p45 / (gran / (1000 * 60 * 15)));
                    p46 = (int) (p46 / (gran / (1000 * 60 * 15)));
                    p47 = (int) (p47 / (gran / (1000 * 60 * 15)));
                    p48 = (int) (p48 / (gran / (1000 * 60 * 15)));
                    p49 = (int) (p49 / (gran / (1000 * 60 * 15)));

                    p50 = (int) (p50 / (gran / (1000 * 60 * 15)));
                    p51 = (int) (p51 / (gran / (1000 * 60 * 15)));
                    p52 = (int) (p52 / (gran / (1000 * 60 * 15)));
                    p53 = (int) (p53 / (gran / (1000 * 60 * 15)));
                    p54 = (int) (p54 / (gran / (1000 * 60 * 15)));
                    p55 = (int) (p55 / (gran / (1000 * 60 * 15)));
                    p56 = (int) (p56 / (gran / (1000 * 60 * 15)));
                    p57 = (int) (p57 / (gran / (1000 * 60 * 15)));
                    p58 = (int) (p58 / (gran / (1000 * 60 * 15)));
                    p59 = (int) (p59 / (gran / (1000 * 60 * 15)));

                    p60 = (int) (p60 / (gran / (1000 * 60 * 15)));
                    p61 = (int) (p61 / (gran / (1000 * 60 * 15)));
                    p62 = (int) (p62 / (gran / (1000 * 60 * 15)));
                    p63 = (int) (p63 / (gran / (1000 * 60 * 15)));
                    p64 = (int) (p64 / (gran / (1000 * 60 * 15)));
                    p65 = (int) (p65 / (gran / (1000 * 60 * 15)));
                    p66 = (int) (p66 / (gran / (1000 * 60 * 15)));
                    p67 = (int) (p67 / (gran / (1000 * 60 * 15)));
                    p68 = (int) (p68 / (gran / (1000 * 60 * 15)));
                    p69 = (int) (p69 / (gran / (1000 * 60 * 15)));

                    p70 = (int) (p70 / (gran / (1000 * 60 * 15)));
                    p71 = (int) (p71 / (gran / (1000 * 60 * 15)));
                    p72 = (int) (p72 / (gran / (1000 * 60 * 15)));
                    p73 = (int) (p73 / (gran / (1000 * 60 * 15)));
                    p74 = (int) (p74 / (gran / (1000 * 60 * 15)));
                    p75 = (int) (p75 / (gran / (1000 * 60 * 15)));
                    p76 = (int) (p76 / (gran / (1000 * 60 * 15)));
                    p77 = (int) (p77 / (gran / (1000 * 60 * 15)));
                    p78 = (int) (p78 / (gran / (1000 * 60 * 15)));
                    p79 = (int) (p79 / (gran / (1000 * 60 * 15)));

                    p80 = (int) (p80 / (gran / (1000 * 60 * 15)));
                    p81 = (int) (p81 / (gran / (1000 * 60 * 15)));
                    p82 = (int) (p82 / (gran / (1000 * 60 * 15)));
                    p83 = (int) (p83 / (gran / (1000 * 60 * 15)));
                    p84 = (int) (p84 / (gran / (1000 * 60 * 15)));
                    p85 = (int) (p85 / (gran / (1000 * 60 * 15)));
                    p86 = (int) (p86 / (gran / (1000 * 60 * 15)));
                    p87 = (int) (p87 / (gran / (1000 * 60 * 15)));
                    p88 = (int) (p88 / (gran / (1000 * 60 * 15)));
                    p89 = (int) (p89 / (gran / (1000 * 60 * 15)));

                    p90 = (int) (p90 / (gran / (1000 * 60 * 15)));
                    p91 = (int) (p91 / (gran / (1000 * 60 * 15)));
                    p92 = (int) (p92 / (gran / (1000 * 60 * 15)));
                    p93 = (int) (p93 / (gran / (1000 * 60 * 15)));
                    p94 = (int) (p94 / (gran / (1000 * 60 * 15)));
                    p95 = (int) (p95 / (gran / (1000 * 60 * 15)));
                    p96 = (int) (p96 / (gran / (1000 * 60 * 15)));
                    p97 = (int) (p97 / (gran / (1000 * 60 * 15)));
                    p98 = (int) (p98 / (gran / (1000 * 60 * 15)));
                    p99 = (int) (p99 / (gran / (1000 * 60 * 15)));

                    ave = ( p0 + p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 +
                            p10 + p11 + p12 + p13 + p14 + p15 + p16 + p17 + p18 + p19 +
                            p20 + p21 + p22 + p23 + p24 + p25 + p26 + p27 + p28 + p29 +
                            p30 + p31 + p32 + p33 + p34 + p35 + p36 + p37 + p38 + p39 +
                            p40 + p41 + p42 + p43 + p44 + p45 + p46 + p47 + p48 + p49 +
                            p50 + p51 + p52 + p53 + p54 + p55 + p56 + p57 + p58 + p59 +
                            p60 + p61 + p62 + p63 + p64 + p65 + p66 + p67 + p68 + p69 +
                            p70 + p71 + p72 + p73 + p74 + p75 + p76 + p77 + p78 + p79 +
                            p80 + p81 + p82 + p83 + p84 + p85 + p86 + p87 + p88 + p89 +
                            p90 + p91 + p92 + p93 + p94 + p95 + p96 + p97 + p98 + p99 )/100;

                    if(P.equals("0"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p0);
                    }
                    if(P.equals("1"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p1);
                    }
                    if(P.equals("2"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p2);
                    }
                    if(P.equals("3"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p3);
                    }
                    if(P.equals("4"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p4);
                    }
                    if(P.equals("5"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p5);
                    }
                    if(P.equals("6"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p6);
                    }
                    if(P.equals("7"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p7);
                    }
                    if(P.equals("8"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p8);
                    }
                    if(P.equals("9"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p9);
                    }

                    if(P.equals("10"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p10);
                    }
                    if(P.equals("11"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p11);
                    }
                    if(P.equals("12"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p12);
                    }
                    if(P.equals("13"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p13);
                    }
                    if(P.equals("14"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p14);
                    }
                    if(P.equals("15"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p15);
                    }
                    if(P.equals("16"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p16);
                    }
                    if(P.equals("17"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p17);
                    }
                    if(P.equals("18"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p18);
                    }
                    if(P.equals("19"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p19);
                    }

                    if(P.equals("20"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p20);
                    }
                    if(P.equals("21"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p21);
                    }
                    if(P.equals("22"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p22);
                    }
                    if(P.equals("23"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p23);
                    }
                    if(P.equals("24"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p24);
                    }
                    if(P.equals("25"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p25);
                    }
                    if(P.equals("26"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p26);
                    }
                    if(P.equals("27"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p27);
                    }
                    if(P.equals("28"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p28);
                    }
                    if(P.equals("29"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p29);
                    }

                    if(P.equals("30"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p30);
                    }
                    if(P.equals("31"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p31);
                    }
                    if(P.equals("32"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p32);
                    }
                    if(P.equals("33"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p33);
                    }
                    if(P.equals("34"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p34);
                    }
                    if(P.equals("35"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p35);
                    }
                    if(P.equals("36"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p36);
                    }
                    if(P.equals("37"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p37);
                    }
                    if(P.equals("38"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p38);
                    }
                    if(P.equals("39"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p39);
                    }

                    if(P.equals("40"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p40);
                    }
                    if(P.equals("41"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p41);
                    }
                    if(P.equals("42"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p42);
                    }
                    if(P.equals("43"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p43);
                    }
                    if(P.equals("44"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p44);
                    }
                    if(P.equals("45"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p45);
                    }
                    if(P.equals("46"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p46);
                    }
                    if(P.equals("47"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p47);
                    }
                    if(P.equals("48"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p48);
                    }
                    if(P.equals("49"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p49);
                    }

                    if(P.equals("50"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p50);
                    }
                    if(P.equals("51"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p51);
                    }
                    if(P.equals("52"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p52);
                    }
                    if(P.equals("53"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p53);
                    }
                    if(P.equals("54"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p54);
                    }
                    if(P.equals("55"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p55);
                    }
                    if(P.equals("56"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p56);
                    }
                    if(P.equals("57"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p57);
                    }
                    if(P.equals("58"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p58);
                    }
                    if(P.equals("59"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p59);
                    }

                    if(P.equals("60"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p60);
                    }
                    if(P.equals("61"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p61);
                    }
                    if(P.equals("62"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p62);
                    }
                    if(P.equals("63"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p63);
                    }
                    if(P.equals("64"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p64);
                    }
                    if(P.equals("65"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p65);
                    }
                    if(P.equals("66"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p66);
                    }
                    if(P.equals("67"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p67);
                    }
                    if(P.equals("68"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p68);
                    }
                    if(P.equals("69"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p69);
                    }

                    if(P.equals("70"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p70);
                    }
                    if(P.equals("71"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p71);
                    }
                    if(P.equals("72"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p72);
                    }
                    if(P.equals("73"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p73);
                    }
                    if(P.equals("74"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p74);
                    }
                    if(P.equals("75"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p75);
                    }
                    if(P.equals("76"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p76);
                    }
                    if(P.equals("77"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p77);
                    }
                    if(P.equals("78"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p78);
                    }
                    if(P.equals("79"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p79);
                    }

                    if(P.equals("80"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p80);
                    }
                    if(P.equals("81"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p81);
                    }
                    if(P.equals("82"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p82);
                    }
                    if(P.equals("83"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p83);
                    }
                    if(P.equals("84"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p84);
                    }
                    if(P.equals("85"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p85);
                    }
                    if(P.equals("86"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p86);
                    }
                    if(P.equals("87"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p87);
                    }
                    if(P.equals("88"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p88);
                    }
                    if(P.equals("89"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p89);
                    }

                    if(P.equals("90"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p90);
                    }
                    if(P.equals("91"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p91);
                    }
                    if(P.equals("92"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p92);
                    }
                    if(P.equals("93"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p93);
                    }
                    if(P.equals("94"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p94);
                    }
                    if(P.equals("95"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p95);
                    }
                    if(P.equals("96"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p96);
                    }
                    if(P.equals("97"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p97);
                    }
                    if(P.equals("98"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p98);
                    }
                    if(P.equals("99"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(p99);
                    }

                    if(P.equals("100"))
                    {
                        prb.setSTARTTIME(list.get(i).getSTARTTIME());
                        prb.setENDTIME(list.get(i).getSTARTTIME().getTime()+gran);
                        prb.setX(ave);
                    }

//                    prb.setSTARTTIME(list.get(i).getSTARTTIME());
//                    prb.setCYCLE(list.get(i).getCYCLE());
//                    prb.setNENAME(list.get(i).getNENAME());
//                    prb.setSECTOR(list.get(i).getSECTOR());
//                    prb.setSECTORNAME(list.get(i).getSECTORNAME());
//                    prb.setP0(p0);
//                    prb.setP1(p1);
//                    prb.setP2(p2);
//                    prb.setP3(p3);
//                    prb.setP4(p4);
//                    prb.setP5(p5);
//                    prb.setP6(p6);
//                    prb.setP7(p7);
//                    prb.setP8(p8);
//                    prb.setP9(p9);
//
//                    prb.setP10(p10);
//                    prb.setP11(p11);
//                    prb.setP12(p12);
//                    prb.setP13(p13);
//                    prb.setP14(p14);
//                    prb.setP15(p15);
//                    prb.setP16(p16);
//                    prb.setP17(p17);
//                    prb.setP18(p18);
//                    prb.setP19(p19);
//
//                    prb.setP20(p20);
//                    prb.setP21(p21);
//                    prb.setP22(p22);
//                    prb.setP23(p23);
//                    prb.setP24(p24);
//                    prb.setP25(p25);
//                    prb.setP26(p26);
//                    prb.setP27(p27);
//                    prb.setP28(p28);
//                    prb.setP29(p29);
//
//                    prb.setP30(p30);
//                    prb.setP31(p31);
//                    prb.setP32(p32);
//                    prb.setP33(p33);
//                    prb.setP34(p34);
//                    prb.setP35(p35);
//                    prb.setP36(p36);
//                    prb.setP37(p37);
//                    prb.setP38(p38);
//                    prb.setP39(p39);
//
//                    prb.setP40(p40);
//                    prb.setP41(p41);
//                    prb.setP42(p42);
//                    prb.setP43(p43);
//                    prb.setP44(p44);
//                    prb.setP45(p45);
//                    prb.setP46(p46);
//                    prb.setP47(p47);
//                    prb.setP48(p48);
//                    prb.setP49(p49);
//
//                    prb.setP50(p50);
//                    prb.setP51(p51);
//                    prb.setP52(p52);
//                    prb.setP53(p53);
//                    prb.setP54(p54);
//                    prb.setP55(p55);
//                    prb.setP56(p56);
//                    prb.setP57(p57);
//                    prb.setP58(p58);
//                    prb.setP59(p59);
//
//                    prb.setP60(p60);
//                    prb.setP61(p61);
//                    prb.setP62(p62);
//                    prb.setP63(p63);
//                    prb.setP64(p64);
//                    prb.setP65(p65);
//                    prb.setP66(p66);
//                    prb.setP67(p67);
//                    prb.setP68(p68);
//                    prb.setP69(p69);
//
//                    prb.setP70(p70);
//                    prb.setP71(p71);
//                    prb.setP72(p72);
//                    prb.setP73(p73);
//                    prb.setP74(p74);
//                    prb.setP75(p75);
//                    prb.setP76(p76);
//                    prb.setP77(p77);
//                    prb.setP78(p78);
//                    prb.setP79(p79);
//
//                    prb.setP80(p80);
//                    prb.setP81(p81);
//                    prb.setP82(p82);
//                    prb.setP83(p83);
//                    prb.setP84(p84);
//                    prb.setP85(p85);
//                    prb.setP86(p86);
//                    prb.setP87(p87);
//                    prb.setP88(p88);
//                    prb.setP89(p89);
//
//                    prb.setP90(p90);
//                    prb.setP91(p91);
//                    prb.setP92(p92);
//                    prb.setP93(p93);
//                    prb.setP94(p94);
//                    prb.setP95(p95);
//                    prb.setP96(p96);
//                    prb.setP97(p97);
//                    prb.setP98(p98);
//                    prb.setP99(p99);
//                    prb.setAve(ave);

                    listnew.add(prb);
                    //prbDao.insertPRBnew(prb);

                    i--;

                }
            }
            start0.setTime(start0.getTime() + gran);
        }

//        for (PRB c : list)
//            System.out.println(c.toString());
//        System.out.println(list.size());

        //排序
        Collections.sort(listnew, new Comparator<PRBpor>() {
            @Override
            public int compare(PRBpor o1, PRBpor o2) {
                return (int) (o1.getSTARTTIME().getTime() - o2.getSTARTTIME().getTime());
            }
        });
        //格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        for (PRBpor i : listnew) {
//            try {
//                String tt = sdf.format(i.getSTARTTIME());
//                i.setSTARTTIME(sdf.parse(tt));
//                //prbDao.insertPRBnew(i);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
        for(PRBpor i : listnew)
            System.out.println(i.getSTARTTIME() + " " + i.getENDTIME() + " " + i.getX());
        return listnew;
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

    public void exportExcelnew(String path, String fileName) {
        //获取数据列表
        List<PRB> list =prbDao.getPRBnew();//list数据由数据库查询得到
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
                SXSSFCell sheetcell106 = sheet_row1.createCell(105);
                sheetcell106.setCellValue("ave");
                sheetcell106.setCellStyle(styleContent);

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
                        sheetcell = sheet_rows.createCell(105);
                        sheetcell.setCellValue(pct.getAve());
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

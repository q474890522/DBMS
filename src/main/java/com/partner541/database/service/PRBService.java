package com.partner541.database.service;

import com.partner541.database.dao.PRBDao;
import com.partner541.database.model.PRB;
import com.partner541.database.utils.ImportExcelBig;
import com.partner541.database.utils.StaticFinalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PRBService {
    @Autowired
    ImportExcelBig importExcelBig;

    @Autowired
    PRBDao prbDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导入数据到PRB表
     *
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

    public List<PRB> getHPRB(Date startT, Date endT, long granularity) {
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
                    prbDao.insertPRBnew(prb);

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
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return listnew;
    }
}

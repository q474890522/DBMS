package com.partner541.database.service;

import com.partner541.database.dao.C2InewDao;
import com.partner541.database.dao.MRODao;
import com.partner541.database.model.C2Inew;
import com.partner541.database.model.MROData;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MROService {
    @Autowired
    MRODao mroDao;

    @Autowired
    C2InewDao c2InewDao;

    public void comC2I(){

        int number = 0;
        double total = 0,C2I_Mean,std,Prb9,PrbABS6;
        C2Inew c2Inew  = new C2Inew();
        List<MROData> list = mroDao.getC2I();
        String SCELL;
        String NCELL;
        int m = list.size();

        while( m > 0 ) {
            number = 0;
            total = 0;
            SCELL = list.get(0).getServingSector();
            NCELL = list.get(0).getInterferingSector();
            //平均数
            for (MROData i : list) {
                if (i.getServingSector().equals(SCELL) && i.getInterferingSector().equals(NCELL)) {
                    total = total + i.getLteScRSRP() - i.getLteNcRSRP();
                    number++;
                }
            }
            C2I_Mean = total / number;
            c2Inew.setSCELL(SCELL);
            c2Inew.setNCELL(NCELL);
            c2Inew.setC2IMean(C2I_Mean);

            //标准差
            total = 0;
            int len = list.size();
            for (int t = 0;t<len ; t++) {
                if (list.get(t).getServingSector().equals(SCELL) && list.get(t).getInterferingSector().equals(NCELL)) {
                    total = (C2I_Mean - list.get(t).getLteScRSRP() + list.get(t).getLteNcRSRP()) * (C2I_Mean - list.get(t).getLteScRSRP() + list.get(t).getLteNcRSRP()) + total;
                    list.remove(t);
                    t--;
                    len--;
                    m--;
                }
            }
            std = Math.sqrt(total / number);
            c2Inew.setStd(std);

            //正态
            if(std != 0) {
                NormalDistribution nd = new NormalDistribution(C2I_Mean, std);
                if (C2I_Mean <= 9)
                    Prb9 = (0.5 + nd.probability(C2I_Mean, 9)) * 100;
                else Prb9 = (1 - 2 * nd.probability(9, C2I_Mean)) / 2 * 100;
                c2Inew.setPrb9(Prb9);

                if (C2I_Mean <= 6)
                    PrbABS6 = nd.probability(2 * C2I_Mean - 6, 6) * 100;
                else PrbABS6 = nd.probability(6, 2 * C2I_Mean - 6) * 100;
                c2Inew.setPrbABS6(PrbABS6);
            }
            else
            {
                c2Inew.setPrb9((double)0);
                c2Inew.setPrbABS6((double)0);
            }
            //清除list中已经计算过的小区
//            int len = list.size();
//            for (int t = 0;t<len ; t++)//for(int i0; i<list.size();i++)
//                if (list.get(t).getServingSector().equals(SCELL) && list.get(t).getInterferingSector().equals(NCELL)) {
//                    list.remove(t);
//                    t = 0;
//                    len--;
//                    m--;
//                }

            //插入数据库
            c2InewDao.addC2Inew(c2Inew);

            System.out.println("还有"+m+"条数据");

        }
    }
}

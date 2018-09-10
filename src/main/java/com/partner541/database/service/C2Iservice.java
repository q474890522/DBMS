package com.partner541.database.service;

import com.partner541.database.dao.C2I3Dao;
import com.partner541.database.dao.C2InewDao;
import com.partner541.database.model.C2I3;
import com.partner541.database.model.C2Inew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C2Iservice {
    @Autowired
    C2I3Dao c2I3Dao;

    @Autowired
    C2InewDao c2InewDao;

    public void re_tri(double x){
        c2I3Dao.deleteC2I3();
        C2I3 c2I3 = new C2I3();
        List<C2Inew> list = c2InewDao.getC2Inew();
        String a,b,c;
        for(int m = 0 ; m < list.size() ; m++)
        {
            a = list.get(m).getSCELL();
            b = list.get(m).getNCELL();
            if(list.get(m).getPrbABS6() >= x)
            for(int i = m+1 ; i < list.size() ; i++ )
            {
                if(list.get(i).getSCELL().equals(a)) {
                    c = list.get(i).getNCELL();
                    for(int t = m+1 ; t < list.size() ; t++)
                        if((list.get(t).getSCELL().equals(c) && list.get(t).getNCELL().equals(b) && list.get(t).getPrbABS6() >= x)
                           ||(list.get(t).getSCELL().equals(b) && list.get(t).getNCELL().equals(c)) && list.get(t).getPrbABS6() >= x)
                        {
                            c2I3 .setCELLa(a);
                            c2I3 .setCELLb(b);
                            c2I3 .setCELLc(c);
                            c2I3Dao.addC2I3(c2I3);
                        }
                }
            }
        }
    }
}

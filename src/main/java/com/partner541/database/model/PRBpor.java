package com.partner541.database.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PRBpor {
    private Date STARTTIME;
    private Date ENDTIME;
    private int X;

    public Date getSTARTTIME() {
        return STARTTIME;
    }

    public void setSTARTTIME(Date STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    public Date getENDTIME() {
        return ENDTIME;
    }

    public void setENDTIME(Long ENDTIME) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                String tt = sdf.format(ENDTIME);
                this.ENDTIME = sdf.parse(tt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }
}

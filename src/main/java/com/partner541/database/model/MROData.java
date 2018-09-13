package com.partner541.database.model;

public class MROData {
    private String TimeStamp			;//nvarchar(50) not null,
    private String ServingSector		;//nvarchar(50) not null,
    private String InterferingSector	;//nvarchar(50) not null,
    private int LteScRSRP			;//int not null,
    private int LteNcRSRP			;//int not null,
    private int LteNcEarfcn 			;//int not null,
    private int LteNcPcinot			;//int null,


    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getServingSector() {
        return ServingSector;
    }

    public void setServingSector(String servingSector) {
        ServingSector = servingSector;
    }

    public String getInterferingSector() {
        return InterferingSector;
    }

    public void setInterferingSector(String interferingSector) {
        InterferingSector = interferingSector;
    }

    public int getLteScRSRP() {
        return LteScRSRP;
    }

    public void setLteScRSRP(int lteScRSRP) {
        LteScRSRP = lteScRSRP;
    }

    public int getLteNcRSRP() {
        return LteNcRSRP;
    }

    public void setLteNcRSRP(int lteNcRSRP) {
        LteNcRSRP = lteNcRSRP;
    }

    public int getLteNcEarfcn() {
        return LteNcEarfcn;
    }

    public void setLteNcEarfcn(int lteNcEarfcn) {
        LteNcEarfcn = lteNcEarfcn;
    }

    public int getLteNcPcinot() {
        return LteNcPcinot;
    }

    public void setLteNcPcinot(int lteNcPcinot) {
        LteNcPcinot = lteNcPcinot;
    }
}

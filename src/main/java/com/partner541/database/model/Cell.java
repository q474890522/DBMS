package com.partner541.database.model;

public class Cell {            //SQL 中对应的定义
    private String CITY 		;//nvarchar(10)	not null,
    private String SECTOR_ID 	;//nvarchar(10)	not null,
    private String SECTOR_NAME 	;//nvarchar(50) not null,
    private int ENODEBID 	;//int not null,
    private String ENODEB_NAME	;//nvarchar(50) not null,
    private int EARFCN		;//int not null,
    private int PCI	 		;//int not null,
    private int PSS	 		;//int not null,
    private int SSS			;//int not null,
    private int TAC	 		;//int not null,
    private String VENDOR		;//nvarchar(10) not null,
    private double LONGITUDE 	;//float null,
    private double LATITUDE		;//float null,
    private String STYLE		;//nvarchar(10) not null,
    private int AZIMUTH		;//int not null,
    private int HEIGHT		;//int null,
    private int ELECTTILT	;//int null,
    private int MECHTILT		;//int null,
    private int TOTLETILT 	;//int null,

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSECTOR_ID() {
        return SECTOR_ID;
    }

    public void setSECTOR_ID(String SECTOR_ID) {
        this.SECTOR_ID = SECTOR_ID;
    }

    public String getSECTOR_NAME() {
        return SECTOR_NAME;
    }

    public void setSECTOR_NAME(String SECTOR_NAME) {
        this.SECTOR_NAME = SECTOR_NAME;
    }

    public int getENODEBID() {
        return ENODEBID;
    }

    public void setENODEBID(int ENODEBID) {
        this.ENODEBID = ENODEBID;
    }

    public String getENODEB_NAME() {
        return ENODEB_NAME;
    }

    public void setENODEB_NAME(String ENODEB_NAME) {
        this.ENODEB_NAME = ENODEB_NAME;
    }

    public int getEARFCN() {
        return EARFCN;
    }

    public void setEARFCN(int EARFCN) {
        this.EARFCN = EARFCN;
    }

    public int getPCI() {
        return PCI;
    }

    public void setPCI(int PCI) {
        this.PCI = PCI;
    }

    public int getPSS() {
        return PSS;
    }

    public void setPSS(int PSS) {
        this.PSS = PSS;
    }

    public int getSSS() {
        return SSS;
    }

    public void setSSS(int SSS) {
        this.SSS = SSS;
    }

    public int getTAC() {
        return TAC;
    }

    public void setTAC(int TAC) {
        this.TAC = TAC;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public double getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(double LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public double getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(double LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getSTYLE() {
        return STYLE;
    }

    public void setSTYLE(String STYLE) {
        this.STYLE = STYLE;
    }

    public int getAZIMUTH() {
        return AZIMUTH;
    }

    public void setAZIMUTH(int AZIMUTH) {
        this.AZIMUTH = AZIMUTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getELECTTILT() {
        return ELECTTILT;
    }

    public void setELECTTILT(int ELECTTILT) {
        this.ELECTTILT = ELECTTILT;
    }

    public int getMECHTILT() {
        return MECHTILT;
    }

    public void setMECHTILT(int MECHTILT) {
        this.MECHTILT = MECHTILT;
    }

    public int getTOTLETILT() {
        return TOTLETILT;
    }

    public void setTOTLETILT(int TOTLETILT) {
        this.TOTLETILT = TOTLETILT;
    }
}


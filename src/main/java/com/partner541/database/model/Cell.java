package com.partner541.database.model;

public class Cell {            //SQL 中对应的定义
    public String CITY 		;//nvarchar(10)	not null,
    public String SECTORID 	;//nvarchar(10)	not null,
    public String SECTORNAME 	;//nvarchar(50) not null,
    public int ENODEBID 	;//int not null,
    public String ENODEBNAME	;//nvarchar(50) not null,
    public int EARFCN		;//int not null,
    public int PCI	 		;//int not null,
    public int PSS	 		;//int not null,
    public int SSS			;//int not null,
    public int TAC	 		;//int not null,
    public String VENDOR		;//nvarchar(10) not null,
    public double LONGITUDE 	;//float null,
    public double LATITUDE		;//float null,
    public String STYLE		;//nvarchar(10) not null,
    public int AZIMUTH		;//int not null,
    public int HEIGHT		;//int null,
    public int ELECTTILT	;//int null,
    public int MECHTILT		;//int null,
    public int TOTLETILT 	;//int null,

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSECTORID() {
        return SECTORID;
    }

    public void setSECTORID(String SECTORID) {
        this.SECTORID = SECTORID;
    }

    public String getSECTORNAME() {
        return SECTORNAME;
    }

    public void setSECTORNAME(String SECTORNAME) {
        this.SECTORNAME = SECTORNAME;
    }

    public int getENODEBID() {
        return ENODEBID;
    }

    public void setENODEBID(int ENODEBID) {
        this.ENODEBID = ENODEBID;
    }

    public String getENODEBNAME() {
        return ENODEBNAME;
    }

    public void setENODEBNAME(String ENODEBNAME) {
        this.ENODEBNAME = ENODEBNAME;
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


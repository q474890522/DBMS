package com.partner541.database.model;

public class C2Inew {
    private String SCELL;
    private String NCELL;
    private Double C2IMean;
    private Double std;
    private Double Prb9;
    private Double PrbABS6;

    public String getSCELL() {
        return SCELL;
    }

    public void setSCELL(String SCELL) {
        this.SCELL = SCELL;
    }

    public String getNCELL() {
        return NCELL;
    }

    public void setNCELL(String NCELL) {
        this.NCELL = NCELL;
    }

    public Double getC2IMean() {
        return C2IMean;
    }

    public void setC2IMean(Double c2IMean) {
        C2IMean = c2IMean;
    }

    public Double getStd() {
        return std;
    }

    public void setStd(Double std) {
        this.std = std;
    }

    public Double getPrb9() {
        return Prb9;
    }

    public void setPrb9(Double prb9) {
        Prb9 = prb9;
    }

    public Double getPrbABS6() {
        return PrbABS6;
    }

    public void setPrbABS6(Double prbABS6) {
        PrbABS6 = prbABS6;
    }

}

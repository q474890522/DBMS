package com.partner541.database.model;

public class C2I {
    private String CITY;
    private String SCELL;
    private String NCELL;
    private int PrC2I9;
    private Double C2I_Mean;
    private Double td;
    private int SampleCount;
    private int WeightedC2I;

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

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

    public int getPrC2I9() {
        return PrC2I9;
    }

    public void setPrC2I9(int prC2I9) {
        PrC2I9 = prC2I9;
    }

    public Double getC2I_Mean() {
        return C2I_Mean;
    }

    public void setC2I_Mean(Double c2I_Mean) {
        C2I_Mean = c2I_Mean;
    }

    public Double getTd() {
        return td;
    }

    public void setTd(Double td) {
        this.td = td;
    }

    public int getSampleCount() {
        return SampleCount;
    }

    public void setSampleCount(int sampleCount) {
        SampleCount = sampleCount;
    }

    public int getWeightedC2I() {
        return WeightedC2I;
    }

    public void setWeightedC2I(int weightedC2I) {
        WeightedC2I = weightedC2I;
    }
}

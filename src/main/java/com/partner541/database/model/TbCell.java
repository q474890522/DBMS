package com.partner541.database.model;

public class TbCell {
    private Object[] col;
    private int sum;
    public TbCell(int sum){
        this.sum=sum;
        col = new Object[sum];
    }

    public Object[] getRow() {
        return col;
    }

    public void setRow(Object[] row) {
        this.col = row;
    }
    @Override
    public String toString() {
        String out ="";
        for(int i=0; i<sum ;++i){
            out=out.concat(" "+col[i]);
        }
        return out;
    }
}

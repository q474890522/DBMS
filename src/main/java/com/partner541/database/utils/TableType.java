package com.partner541.database.utils;

public enum TableType {
    Cell(0),
    KPI(1),
    PRB(2);

    private int value;

    TableType (int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

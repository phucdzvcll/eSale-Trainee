package com.hqsoft.esales.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "OM_SALESORDDET", primaryKeys = {"OrderNbr", "LineRef"})
public class SalesOrderDetLocalEntity {
    @NonNull
    @ColumnInfo(name = "OrderNbr")
    final private String orderNbr;
    @ColumnInfo(name = "LineRef")
    @NonNull
    final private int lineRef;
    @ColumnInfo(name = "InvtID")
    final private String invtId;
    @ColumnInfo(name = "LineAmt")
    final private double lineAmt;
    @ColumnInfo(name = "LineQty")
    final private double lineQty;

    @NonNull
    public String getOrderNbr() {
        return orderNbr;
    }

    @NonNull
    public int getLineRef() {
        return lineRef;
    }

    public String getInvtId() {
        return invtId;
    }

    public double getLineAmt() {
        return lineAmt;
    }

    public double getLineQty() {
        return lineQty;
    }

    public SalesOrderDetLocalEntity(@NonNull String orderNbr, @NonNull int lineRef, String invtId, double lineAmt, double lineQty) {
        this.orderNbr = orderNbr;
        this.lineRef = lineRef;
        this.invtId = invtId;
        this.lineAmt = lineAmt;
        this.lineQty = lineQty;
    }
}

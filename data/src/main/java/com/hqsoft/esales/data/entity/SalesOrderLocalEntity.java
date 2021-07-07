package com.hqsoft.esales.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.hqsoft.esales.data.common.DateConverter;

import java.util.Date;


@Entity(tableName = "OM_SALESORD")
public class SalesOrderLocalEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "OrderNbr")
    private final String orderNbr;
    @ColumnInfo(name = "SlsperID")
    private final String slsperId;
    @ColumnInfo(name = "CustID")
    private final String customerId;
    @ColumnInfo(name = "OrdAmt")
    private final double orderAmt;
    @ColumnInfo(name = "OrdQty")
    private final double orderQty;
    @ColumnInfo(name = "OrderDate")
    @TypeConverters({DateConverter.class})
    private final Date orderDate;
    @ColumnInfo(name = "Remark")
    private final String remark;

    @NonNull
    public String getOrderNbr() {
        return orderNbr;
    }

    public String getSlsperId() {
        return slsperId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getOrderAmt() {
        return orderAmt;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getRemark() {
        return remark;
    }

    public SalesOrderLocalEntity(@NonNull String orderNbr, String slsperId, String customerId, double orderAmt, double orderQty, Date orderDate, String remark) {
        this.orderNbr = orderNbr;
        this.slsperId = slsperId;
        this.customerId = customerId;
        this.orderAmt = orderAmt;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.remark = remark;
    }
}

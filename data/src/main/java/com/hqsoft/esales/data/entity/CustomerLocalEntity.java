package com.hqsoft.esales.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AR_CUSTOMER")
public class CustomerLocalEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "CustID")
    private final String cusId;
    @ColumnInfo(name = "Name")
    private final String name;
    @ColumnInfo(name = "Address")
    private final String address;
    @ColumnInfo(name = "Phone")
    private final String phone;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @NonNull
    public String getCusId() {
        return cusId;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerLocalEntity(String name, String address, @NonNull String cusId, String phone) {
        this.name = name;
        this.address = address;
        this.cusId = cusId;
        this.phone = phone;
    }
}

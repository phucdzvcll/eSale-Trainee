package com.hqsoft.esales.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AR_SALESPERSON")
public class SalespersonLocalEntity {
    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    @NonNull
    public String getSlsperId() {
        return slsperId;
    }

    @ColumnInfo(name = "SlsperID")
    @PrimaryKey
    @NonNull
    private final String slsperId;
    @ColumnInfo(name = "FullName")
    private final String fullName;
    @ColumnInfo(name = "Address")
    private final String address;
    @ColumnInfo(name = "Password")
    private final String password;

    public SalespersonLocalEntity(String fullName, String address, String password, @NonNull String slsperId) {
        this.fullName = fullName;
        this.address = address;
        this.password = password;
        this.slsperId = slsperId;
    }
}

package com.hqsoft.esales.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "IN_INVENTORY")
public class InventoryLocalEntity {
    @PrimaryKey
    @ColumnInfo(name = "InvtID")
    @NonNull
    private final String id;
    @ColumnInfo(name = "Name")
    private final String name;
    @ColumnInfo(name = "Unit")
    private final String unit;
    @ColumnInfo(name = "Price")
    private final double price;

    public String getName() {
        return name;
    }
    @NonNull
    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public InventoryLocalEntity(String name,@NonNull String id, String unit, double price) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.price = price;
    }
}

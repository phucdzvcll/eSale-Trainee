package com.hqsoft.esales.domain.entities;

public class InventoryEntity {
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public String getPrice() {
        return price;
    }

    final String name;
    final String id;
    final String unit;
    final String price;

    public InventoryEntity(String name, String id, String unit, String price) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.price = price;
    }
}

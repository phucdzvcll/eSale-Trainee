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

    public double getPrice() {
        return price;
    }

    final String name;
    final String id;
    final String unit;
    final double price;

    public InventoryEntity(String name, String id, String unit, double price) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.price = price;
    }
}

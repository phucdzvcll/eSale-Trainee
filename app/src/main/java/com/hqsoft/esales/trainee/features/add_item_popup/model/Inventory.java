package com.hqsoft.esales.trainee.features.add_item_popup.model;

public class Inventory {
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public Double getPrice() {
        return price;
    }

    private final String name;
    private final String id;
    private final String unit;
    private final Double price;

    public Inventory(String name, String id, String unit, Double price) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.price = price;
    }
}

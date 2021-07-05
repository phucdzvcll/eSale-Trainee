package com.hqsoft.esales.trainee.features.add_item_popup.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Inventory implements Parcelable {
    protected Inventory(Parcel in) {
        name = in.readString();
        id = in.readString();
        unit = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
    }

    public static final Creator<Inventory> CREATOR = new Creator<Inventory>() {
        @Override
        public Inventory createFromParcel(Parcel in) {
            return new Inventory(in);
        }

        @Override
        public Inventory[] newArray(int size) {
            return new Inventory[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(unit);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
    }
}

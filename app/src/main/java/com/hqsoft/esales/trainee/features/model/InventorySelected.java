package com.hqsoft.esales.trainee.features.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hqsoft.esales.trainee.features.add_item_popup.model.Inventory;

public class InventorySelected implements Parcelable {
    private final Inventory inventory;
    private final int amount;

    protected InventorySelected(Parcel in) {
        inventory = in.readParcelable(Inventory.class.getClassLoader());
        amount = in.readInt();
    }

    public static final Creator<InventorySelected> CREATOR = new Creator<InventorySelected>() {
        @Override
        public InventorySelected createFromParcel(Parcel in) {
            return new InventorySelected(in);
        }

        @Override
        public InventorySelected[] newArray(int size) {
            return new InventorySelected[size];
        }
    };

    public Inventory getInventory() {
        return inventory;
    }

    public int getAmount() {
        return amount;
    }

    public InventorySelected(Inventory inventory, int amount) {
        this.inventory = inventory;
        this.amount = amount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(inventory, flags);
        dest.writeInt(amount);
    }
}

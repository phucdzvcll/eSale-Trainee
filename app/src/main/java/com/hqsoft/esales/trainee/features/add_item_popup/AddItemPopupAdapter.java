package com.hqsoft.esales.trainee.features.add_item_popup;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.add_item_popup.model.Inventory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class AddItemPopupAdapter extends RecyclerView.Adapter<AddItemPopupAdapter.AddItemViewHolder> {
    private final ArrayList<Inventory> inventories = new ArrayList<>();
    private final ArrayList<InventorySelected> inventoriesSelected = new ArrayList<>();

    void addData(@NonNull List<Inventory> cuss) {
        inventories.clear();
        inventories.addAll(cuss);
        notifyDataSetChanged();
    }

    public ArrayList<InventorySelected> getInventoriesSelected() {
        return inventoriesSelected;
    }

    void addListInventoriesSelected(List<InventorySelected> inSelected){
        inventoriesSelected.clear();
        inventoriesSelected.addAll(inSelected);
    }

    @NonNull
    @Override
    public AddItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView =
                inflater.inflate(R.layout.item_add_item_popup, parent, false);

        return new AddItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddItemViewHolder holder, int position) {
        Inventory inventory = inventories.get(position);
        holder.nameItem.setText(inventory.getName());
        holder.itemPrice.setText(MessageFormat.format("{0}", inventory.getPrice()));
        holder.itemProperty.setText(inventory.getUnit());
        String stt = (position + 1) + "";
        setUpInventoryAmount(inventory.getId(),holder.itemAmount);
        holder.itemAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    int exitsIndex = -1;
                    for (int i = 0; i < inventoriesSelected.size(); i++) {
                        if (inventoriesSelected.get(i).inventory.getId().equals(inventory.getId())) {
                            exitsIndex = i;
                            break;
                        }
                    }
                    if (exitsIndex > -1) {
                        InventorySelected newInventory = new InventorySelected(inventoriesSelected.get(exitsIndex).getInventory(), Integer.parseInt(s.toString()));
                        inventoriesSelected.set(exitsIndex,newInventory);
                    } else {
                        inventoriesSelected.add(new InventorySelected(inventory, Integer.parseInt(s.toString())));
                    }

                    Log.d("hhhhhhhh", s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        holder.indexItem.setText(stt);
        if (position % 2 == 0) {
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        } else {
            holder.linearLayout.setBackgroundColor(Color.LTGRAY);
        }
    }

    private void setUpInventoryAmount(String id,EditText itemAmount) {
        if(inventoriesSelected.size() > 0){
            for (int i = 0;i<inventoriesSelected.size();i++){
                if(inventoriesSelected.get(i).inventory.getId().equals(id)){
                    itemAmount.setText(MessageFormat.format("{0}", inventoriesSelected.get(i).getAmount()));
                    break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return inventories.size();
    }


    public static class AddItemViewHolder extends RecyclerView.ViewHolder {
        final TextView indexItem;
        final TextView nameItem;
        final TextView itemProperty;
        final TextView itemPrice;
        final EditText itemAmount;
        final LinearLayout linearLayout;

        public AddItemViewHolder(View itemView) {
            super(itemView);
            this.indexItem = itemView.findViewById(R.id.indexItem);
            this.nameItem = itemView.findViewById(R.id.itemName);
            this.itemProperty = itemView.findViewById(R.id.itemProperty);
            this.itemPrice = itemView.findViewById(R.id.itemPrice);
            this.itemAmount = itemView.findViewById(R.id.itemAmount);
            this.linearLayout = itemView.findViewById(R.id.itemAddPopup);
        }
    }

    public static class InventorySelected implements Parcelable {
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
}

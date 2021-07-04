package com.hqsoft.esales.trainee.features.add_item_popup;

import android.content.Context;
import android.graphics.Color;
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


    void addData(@NonNull List<Inventory> cuss) {
        inventories.clear();
        inventories.addAll(cuss);
        notifyDataSetChanged();
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
        holder.indexItem.setText(stt);
        if (position % 2 == 0) {
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        } else {
            holder.linearLayout.setBackgroundColor(Color.LTGRAY);
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
}

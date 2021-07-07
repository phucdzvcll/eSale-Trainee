package com.hqsoft.esales.trainee.features.order;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.model.InventorySelected;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private final ArrayList<InventorySelected> inventoriesSelected = new ArrayList<>();

    public ArrayList<InventorySelected> getListInventoriesSelected() {
        return inventoriesSelected;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView =
                inflater.inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        InventorySelected inventorySelected = inventoriesSelected.get(position);
        String stt = (position + 1) + "";
        holder.indexOrder.setText(stt);
        holder.idOrder.setText(inventorySelected.getInventory().getId());
        holder.describeOrder.setText(inventorySelected.getInventory().getUnit());
        holder.priceOrder.setText(MessageFormat.format("{0}", inventorySelected.getInventory().getPrice()));
        holder.amountOrder.setText(MessageFormat.format("{0}", inventorySelected.getAmount()));
        holder.totalPricePerOrder.setText(MessageFormat.format("{0}", inventorySelected.getAmount() * inventorySelected.getInventory().getPrice()));
        if (position % 2 == 0) {
            holder.itemOrderLinear.setBackgroundColor(Color.WHITE);
        } else {
            holder.itemOrderLinear.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return inventoriesSelected.size();
    }


    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        final TextView indexOrder, idOrder, describeOrder, priceOrder, amountOrder, totalPricePerOrder;
        final LinearLayout itemOrderLinear;

        public OrderViewHolder(View itemView) {
            super(itemView);
            this.indexOrder = itemView.findViewById(R.id.indexOrder);
            this.idOrder = itemView.findViewById(R.id.idOrder);
            this.describeOrder = itemView.findViewById(R.id.describeOrder);
            this.priceOrder = itemView.findViewById(R.id.priceOrder);
            this.amountOrder = itemView.findViewById(R.id.amountOrder);
            this.totalPricePerOrder = itemView.findViewById(R.id.totalPricePerOrder);
            this.itemOrderLinear = itemView.findViewById(R.id.itemOrderLinear);
        }
    }

    public void addData(@NonNull List<InventorySelected> inSelected) {
        inventoriesSelected.clear();
        inventoriesSelected.addAll(inSelected);
        notifyDataSetChanged();
    }
}

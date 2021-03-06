package com.hqsoft.esales.trainee.features.order_list;

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
import com.hqsoft.esales.trainee.features.order_list.model.SalesOrder;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder> {
    private final ArrayList<SalesOrder> salesOrders = new ArrayList<>();

    void addData(@NonNull List<SalesOrder> cuss) {
        salesOrders.clear();
        salesOrders.addAll(cuss);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View orderView =
                inflater.inflate(R.layout.item_order_list, parent, false);

        return new OrderListViewHolder(orderView);
    }

    @Override
    public void onBindViewHolder(OrderListViewHolder holder, int position) {
        SalesOrder salesOrder = salesOrders.get(position);

        double total = salesOrder.getOrderAmt();
        holder.totalPerOrder.setText(MessageFormat.format("{0}", total));
        holder.nameOrder.setText(salesOrder.getOrderNbr());

        String stt = (position + 1) + "";
        holder.indexOrder.setText(stt);
        if (position % 2 == 0) {
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        } else {
            holder.linearLayout.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return salesOrders.size();
    }


    public static class OrderListViewHolder extends RecyclerView.ViewHolder {
        final TextView indexOrder;
        final TextView nameOrder;
        final TextView totalPerOrder;
        final LinearLayout linearLayout;

        public OrderListViewHolder(View itemView) {
            super(itemView);
            this.indexOrder = itemView.findViewById(R.id.indexOrder);
            this.nameOrder = itemView.findViewById(R.id.orderName);
            this.totalPerOrder = itemView.findViewById(R.id.totalPerOrder);
            this.linearLayout = itemView.findViewById(R.id.itemOrder);
        }
    }
}

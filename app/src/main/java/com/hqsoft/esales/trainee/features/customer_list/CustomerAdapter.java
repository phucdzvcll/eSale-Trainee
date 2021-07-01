package com.hqsoft.esales.trainee.features.customer_list;

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
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {
    private ArrayList<Customer> customers;
    final OnItemRecyclerViewClick onItemRecyclerViewClick;

    public CustomerAdapter(OnItemRecyclerViewClick onItemRecyclerViewClick) {
        this.onItemRecyclerViewClick = onItemRecyclerViewClick;
    }

    void addData(List<Customer> cuss) {
        if (customers == null) {
            customers = new ArrayList<>();
        } else {
            customers.clear();
        }
        customers.addAll(cuss);
        notifyDataSetChanged();
    }

    Customer getItem(int position) {
        return customers.get(position);
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView =
                inflater.inflate(R.layout.item_customer_list, parent, false);

        return new CustomerViewHolder(studentView);
    }

    @Override
    public void onBindViewHolder(CustomerAdapter.CustomerViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.address.setText(customer.getAddress());
        String phoneNum = "ĐT: " + customer.getPhone();
        holder.phone.setText(phoneNum);
        holder.name.setText(customer.getName());
        String stt = (position + 1) + "";
        holder.index.setText(stt);
        if (position % 2 == 0) {
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        } else {
            holder.linearLayout.setBackgroundColor(Color.LTGRAY);
        }
        holder.itemView.setOnClickListener(v -> onItemRecyclerViewClick.onClick(v, position));
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }


    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        final TextView index;
        final TextView name;
        final TextView phone;
        final TextView address;
        final LinearLayout linearLayout;

        public CustomerViewHolder(View itemView) {
            super(itemView);
            this.index = itemView.findViewById(R.id.index);
            this.name = itemView.findViewById(R.id.customerName);
            this.phone = itemView.findViewById(R.id.phone);
            this.address = itemView.findViewById(R.id.address);
            this.linearLayout = itemView.findViewById(R.id.itemCustomer);
        }
    }
}

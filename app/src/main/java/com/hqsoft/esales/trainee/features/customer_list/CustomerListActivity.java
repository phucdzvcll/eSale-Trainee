package com.hqsoft.esales.trainee.features.customer_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomerListActivity extends AppCompatActivity implements OnItemRecyclerViewClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        setupRecyclerView();
    }

    void setupRecyclerView() {
        CustomerAdapter customerAdapter = new CustomerAdapter(this);
        customerAdapter.addData(createListCustomer());
        RecyclerView recyclerView = findViewById(R.id.customerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customerAdapter);
    }

    List<Customer> createListCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Khách Hàng A", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID1", "1234567890"));
        customers.add(new Customer("Khách Hàng B", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID2", "1234567890"));
        customers.add(new Customer("Khách Hàng C", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID3", "1234567890"));
        customers.add(new Customer("Khách Hàng D", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID4", "1234567890"));
        customers.add(new Customer("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        return customers;
    }

    @Override
    public void onClick(View view, int position) {
        startActivity(new Intent(this, OrderListActivity.class));
    }
}
package com.hqsoft.esales.trainee.features.customer_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerListActivity extends AppCompatActivity implements OnItemRecyclerViewClick {
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        setupRecyclerView();
    }

    void setupRecyclerView() {
        customerAdapter = new CustomerAdapter(this);
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
        Toast.makeText(this, "Long Click: " +customerAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
    }
}
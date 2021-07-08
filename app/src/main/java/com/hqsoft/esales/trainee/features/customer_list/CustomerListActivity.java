package com.hqsoft.esales.trainee.features.customer_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;
import com.hqsoft.esales.trainee.features.customer_list.viewmodel.CustomerViewModel;
import com.hqsoft.esales.trainee.features.customer_list.viewmodel.CustomerViewModelFactory;
import com.hqsoft.esales.trainee.features.login.LoginActivity;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

public class CustomerListActivity extends AppCompatActivity implements OnItemRecyclerViewClick {
    final CustomerAdapter customerAdapter = new CustomerAdapter(this);
    public static String KEY = "Customer_key";
    private CustomerViewModel customerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        setupRecyclerView();
        createCustomerViewModel();
        customerViewModel.getCuListMutableLiveData().observe(this, customerAdapter::addData);
        search();
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestData();
    }

    private void search(){
        EditText search = findViewById(R.id.searchCuss);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                customerViewModel.getDataBySearch(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void requestData() {
        customerViewModel.requestListCustomer();
    }

    void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.customerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customerAdapter);
    }

    void createCustomerViewModel() {
        customerViewModel = new ViewModelProvider(this, new CustomerViewModelFactory(this)).get(CustomerViewModel.class);
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent1 = getIntent();
        String SlsperID = intent1.getStringExtra(LoginActivity.KEY);
        Customer customer = customerAdapter.getCustomer(position);
        Intent intent = new Intent(this, OrderListActivity.class);
        intent.putExtra(KEY, customer.getCusId());
        if (SlsperID != null) {
            intent.putExtra(LoginActivity.KEY, SlsperID);
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}
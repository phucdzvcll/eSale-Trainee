package com.hqsoft.esales.trainee.features.customer_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.CustomerDAO;
import com.hqsoft.esales.data.database.InventoryDAO;
import com.hqsoft.esales.data.entity.CustomerLocalEntity;
import com.hqsoft.esales.data.entity.InventoryLocalEntity;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.domain.use_cases.CustomerListUseCase;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

import java.util.List;

public class CustomerListActivity extends AppCompatActivity implements OnItemRecyclerViewClick {
    final CustomerAdapter customerAdapter = new CustomerAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        setupRecyclerView();
        requestData();
    }

    private void requestData() {
        AppDatabase db = AppDatabase.getInstance(this);
        InventoryDAO inventoryDAO = db.inventoryDAO();
        List<InventoryLocalEntity> listCustomer1 = inventoryDAO.getListInventory();
        Log.d("hhhhhhhhhhhhhhhhhh",listCustomer1.get(0).getId()+"");
        List<Customer> listCustomer = createListCustomer();
        if (listCustomer != null) {
            customerAdapter.addData(listCustomer);
        } else {
            //todo handle error case
        }
    }

    void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.customerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customerAdapter);
    }

    @Nullable
    List<Customer> createListCustomer() {
        CustomerListUseCase customerListUseCase = new CustomerListUseCase();
        ResultPair<CustomerListUseCase.Result, UseCaseError> resultPair = customerListUseCase.execute(new UseCaseParam.EmptyParam());
        CustomerListUseCase.Result success = resultPair.getSuccess();
        CustomerListMapper customerListMapper = new CustomerListMapper();
        if (success != null) {
            return customerListMapper.mapList(success.getCustomerEntityList());
        } else {
            return null;
        }
    }

    @Override
    public void onClick(View view, int position) {
        startActivity(new Intent(this, OrderListActivity.class));
    }
}
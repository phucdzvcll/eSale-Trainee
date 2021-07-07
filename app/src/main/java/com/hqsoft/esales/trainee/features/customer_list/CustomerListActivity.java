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
import com.hqsoft.esales.data.mapper.CustomerLocalMapper;
import com.hqsoft.esales.data.repository.CustomerRepositoryImpl;
import com.hqsoft.esales.domain.repository.CustomerRepository;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.domain.use_cases.CustomerListUseCase;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;
import com.hqsoft.esales.trainee.features.login.LoginActivity;
import com.hqsoft.esales.trainee.features.order_list.OrderListActivity;

import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomerListActivity extends AppCompatActivity implements OnItemRecyclerViewClick {
    final CustomerAdapter customerAdapter = new CustomerAdapter(this);
    public static String KEY = "Customer_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        setupRecyclerView();
        requestData();
    }

    private void requestData() {
        Objects.requireNonNull(createListCustomer())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Customer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<Customer> customers) {
                        customerAdapter.addData(customers);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        //todo handle error
                    }
                });
    }

    void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.customerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customerAdapter);
    }

    @Nullable
    Single<List<Customer>> createListCustomer() {
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        CustomerDAO customerDAO = appDatabase.customerDAO();
        CustomerLocalMapper customerLocalMapper = new CustomerLocalMapper();
        CustomerRepository customerRepository = new CustomerRepositoryImpl(customerDAO, customerLocalMapper);
        CustomerListUseCase customerListUseCase = new CustomerListUseCase(customerRepository);
        Single<CustomerListUseCase.Result> resultRx = customerListUseCase.execute(new UseCaseParam.EmptyParam());
        CustomerListMapper customerListMapper = new CustomerListMapper();
        return resultRx.flatMap((Function<CustomerListUseCase.Result, SingleSource<List<Customer>>>) result ->
                Single.just(customerListMapper.mapList(result.getCustomerEntityList()))
        );
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
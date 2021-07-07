package com.hqsoft.esales.trainee.features.customer_list.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.CustomerDAO;
import com.hqsoft.esales.data.mapper.CustomerLocalMapper;
import com.hqsoft.esales.data.repository.CustomerRepositoryImpl;
import com.hqsoft.esales.domain.repository.CustomerRepository;
import com.hqsoft.esales.domain.use_cases.CustomerListUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.trainee.features.customer_list.CustomerListMapper;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomerViewModel extends ViewModel {

    @SuppressLint("StaticFieldLeak")
    final private Context context;

    public CustomerViewModel(Context context) {
        this.context = context;
    }

    private final MutableLiveData<List<Customer>> cuListMutableLiveData = new MutableLiveData<>();

    public void requestListCustomer(){
        loadData();
    }

    public MutableLiveData<List<Customer>> getCuListMutableLiveData(){
        return cuListMutableLiveData;
    }

    private void loadData() {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        CustomerDAO customerDAO = appDatabase.customerDAO();
        CustomerLocalMapper customerLocalMapper = new CustomerLocalMapper();
        CustomerRepository customerRepository = new CustomerRepositoryImpl(customerDAO, customerLocalMapper);
        CustomerListUseCase customerListUseCase = new CustomerListUseCase(customerRepository);
        CustomerListMapper customerListMapper = new CustomerListMapper();
        Single<CustomerListUseCase.Result> resultSingle = customerListUseCase.execute(new UseCaseParam.EmptyParam());
        resultSingle.flatMap((Function<CustomerListUseCase.Result, SingleSource<List<Customer>>>) result ->
                Single.just(customerListMapper.mapList(result.getCustomerEntityList()))
        ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new SingleObserver<List<Customer>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<Customer> customers) {
                cuListMutableLiveData.postValue(customers);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                //todo handle error
            }
        });

    }
}

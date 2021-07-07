package com.hqsoft.esales.trainee.features.login.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.SalespersonDAO;
import com.hqsoft.esales.data.mapper.SalespersonLocalMapper;
import com.hqsoft.esales.data.repository.LoginRepositoryImpl;
import com.hqsoft.esales.domain.entities.SalesPersonEntity;
import com.hqsoft.esales.domain.repository.LoginRepository;
import com.hqsoft.esales.domain.use_cases.LoginUseCase;
import com.hqsoft.esales.trainee.R;
import com.hqsoft.esales.trainee.features.customer_list.CustomerListActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<SalesPersonEntity> salesPersonEntityMutableLiveData = new MutableLiveData<>();
    @SuppressLint("StaticFieldLeak")
    private final Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void requestSales(String userName) {
        loadData(userName);
    }

    public LiveData<SalesPersonEntity> getSalesPersonEntityLiveData() {
        return salesPersonEntityMutableLiveData;
    }

    private void loadData(String userName) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        SalespersonDAO salespersonDAO = appDatabase.salespersonDAO();
        SalespersonLocalMapper salespersonLocalMapper = new SalespersonLocalMapper();
        LoginRepository loginRepository = new LoginRepositoryImpl(salespersonDAO, salespersonLocalMapper);
        LoginUseCase loginUseCase = new LoginUseCase(loginRepository);
        Single<SalesPersonEntity> resultRX = loginUseCase.execute(new LoginUseCase.Param(userName));
        resultRX
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SalesPersonEntity>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull SalesPersonEntity salesPersonEntity) {
                        salesPersonEntityMutableLiveData.postValue(salesPersonEntity);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        salesPersonEntityMutableLiveData.postValue(null);
                    }
                });
    }
}

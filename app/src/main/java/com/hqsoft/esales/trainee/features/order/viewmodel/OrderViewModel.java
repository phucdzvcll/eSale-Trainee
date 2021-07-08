package com.hqsoft.esales.trainee.features.order.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.database.SalesOrderDetDAO;
import com.hqsoft.esales.data.mapper.SalesOrderDeMapper;
import com.hqsoft.esales.data.mapper.SalesOrderEntityMapper;
import com.hqsoft.esales.data.repository.SaveToSalesOrderRepositoryImpl;
import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;
import com.hqsoft.esales.domain.use_cases.SaveOderUseCase;
import com.hqsoft.esales.trainee.features.model.InventorySelected;
import com.hqsoft.esales.trainee.features.order.OrderDetMapper;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OrderViewModel extends ViewModel {
    @SuppressLint("StaticFieldLeak")
    final private Context context;

    public OrderViewModel(Context context) {
        this.context = context;
    }

    public void requestSaveData(OrderEntity.SalesOrderEntity orderEntity, ArrayList<InventorySelected> inventorySelected) {
        saveData(orderEntity,inventorySelected);
    }

    private void saveData(OrderEntity.SalesOrderEntity orderEntity, ArrayList<InventorySelected> inventorySelected){
        OrderDetMapper orderDetMapper = new OrderDetMapper();
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        SalesOrderDAO salesOrderDAO = appDatabase.salesOrderDAO();
        SalesOrderDetDAO salesOrderDetDAO = appDatabase.salesOrderDetDAO();
        SalesOrderEntityMapper salesOrderEntityMapper = new SalesOrderEntityMapper();
        SalesOrderDeMapper salesOrderDeMapper = new SalesOrderDeMapper();
        SaveToSalesOrdRepository saveToSalesOrdRepository = new SaveToSalesOrderRepositoryImpl(salesOrderDAO, salesOrderDetDAO, salesOrderEntityMapper, salesOrderDeMapper);
        SaveOderUseCase saveOderUseCase = new SaveOderUseCase(saveToSalesOrdRepository);
        saveOderUseCase.execute(new SaveOderUseCase.Param(new OrderEntity(orderEntity,orderDetMapper.mapList(inventorySelected))))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SaveOderUseCase.Result>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(SaveOderUseCase.@NonNull Result result) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}

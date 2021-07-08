package com.hqsoft.esales.trainee.features.order_list.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.mapper.OrderListLocalMapper;
import com.hqsoft.esales.data.repository.OrderListRepositoryImpl;
import com.hqsoft.esales.domain.repository.OrderListRepository;
import com.hqsoft.esales.domain.use_cases.OrderListUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.trainee.features.order_list.OrderListMapper;
import com.hqsoft.esales.trainee.features.order_list.model.SalesOrder;

import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OrderListViewModel extends ViewModel {
    @SuppressLint("StaticFieldLeak")
    final private Context context;

    final private MutableLiveData<List<SalesOrder>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<SalesOrder>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void requestData(Date date) {
        getAllData(date);
    }


    private void getAllData(Date date) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        SalesOrderDAO salesOrderDAO = appDatabase.salesOrderDAO();
        OrderListLocalMapper orderListLocalMapper = new OrderListLocalMapper();
        OrderListRepository orderListRepository = new OrderListRepositoryImpl(salesOrderDAO, orderListLocalMapper);
        OrderListMapper orderListMapper = new OrderListMapper();
        OrderListUseCase orderListUseCase = new OrderListUseCase(orderListRepository);
        Single<OrderListUseCase.Result> result = orderListUseCase.execute(new OrderListUseCase.Param(date));
        result.flatMap((Function<OrderListUseCase.Result, SingleSource<List<SalesOrder>>>) result1 ->
                Single.just(orderListMapper.mapList(result1.getCustomerEntityList()))
        ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<SalesOrder>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<SalesOrder> salesOrders) {
                        listMutableLiveData.postValue(salesOrders);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        //TODO handle error
                    }
                });
    }

    public OrderListViewModel(Context context) {
        this.context = context;
    }
}

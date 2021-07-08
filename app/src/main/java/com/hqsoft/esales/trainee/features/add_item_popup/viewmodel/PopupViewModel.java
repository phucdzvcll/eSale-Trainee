package com.hqsoft.esales.trainee.features.add_item_popup.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hqsoft.esales.data.AppDatabase;
import com.hqsoft.esales.data.database.InventoryDAO;
import com.hqsoft.esales.data.mapper.InventoryLocalMapper;
import com.hqsoft.esales.data.repository.InventoryRepositoryImpl;
import com.hqsoft.esales.domain.SearchInventoryUseCase;
import com.hqsoft.esales.domain.repository.InventoryRepository;
import com.hqsoft.esales.domain.use_cases.InventoryListUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.hqsoft.esales.trainee.features.add_item_popup.InventoryMapper;
import com.hqsoft.esales.trainee.features.add_item_popup.model.Inventory;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PopupViewModel extends ViewModel {
    @SuppressLint("StaticFieldLeak")
    final private Context context;
    final private MutableLiveData<List<Inventory>> listMutableLiveData = new MutableLiveData<>();

    public PopupViewModel(Context context) {
        this.context = context;
    }

    public void requestData() {
        getAllData();
    }

    public LiveData<List<Inventory>> getListLiveData() {
        return listMutableLiveData;
    }

    public void getDataBySearch(String searchText) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        InventoryDAO inventoryDAO = appDatabase.inventoryDAO();
        InventoryLocalMapper inventoryLocalMapper = new InventoryLocalMapper();
        InventoryRepository inventoryRepository = new InventoryRepositoryImpl(inventoryDAO, inventoryLocalMapper);
        SearchInventoryUseCase searchInventoryUseCase = new SearchInventoryUseCase(inventoryRepository);
        Single<SearchInventoryUseCase.Result> result = searchInventoryUseCase.execute(new SearchInventoryUseCase.Param(searchText));
        InventoryMapper inventoryMapper = new InventoryMapper();
        result.flatMap((Function<SearchInventoryUseCase.Result, SingleSource<List<Inventory>>>) result1 ->
                Single.just(inventoryMapper.mapList(result1.getInventoryEntities()))
        ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Inventory>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Inventory> inventories) {
                        listMutableLiveData.postValue(inventories);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        //TODO handle error
                    }
                });
    }

    private void getAllData() {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        InventoryDAO inventoryDAO = appDatabase.inventoryDAO();
        InventoryLocalMapper inventoryLocalMapper = new InventoryLocalMapper();
        InventoryRepository inventoryRepository = new InventoryRepositoryImpl(inventoryDAO, inventoryLocalMapper);
        InventoryListUseCase inventoryListUseCase = new InventoryListUseCase(inventoryRepository);
        Single<InventoryListUseCase.Result> result = inventoryListUseCase.execute(new UseCaseParam.EmptyParam());
        InventoryMapper inventoryMapper = new InventoryMapper();
        result.flatMap((Function<InventoryListUseCase.Result, SingleSource<List<Inventory>>>) result1 ->
                Single.just(inventoryMapper.mapList(result1.getInventoryEntities()))
        ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Inventory>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Inventory> inventories) {
                        listMutableLiveData.postValue(inventories);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        //TODO handle error
                    }
                });
    }
}

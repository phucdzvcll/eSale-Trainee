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
        saveOderUseCase.execute(new SaveOderUseCase.Param(new OrderEntity(orderEntity,orderDetMapper.mapList(inventorySelected))));
    }
}

package com.hqsoft.esales.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hqsoft.esales.data.entity.InventoryLocalEntity;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;

import java.util.Date;
import java.util.List;

@Dao
public interface SalesOrderDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SalesOrderLocalEntity> salesOrderLocalEntities);

    @Insert()
    void insert(SalesOrderLocalEntity salesOrderLocalEntity);

    @Query("DELETE from OM_SALESORD")
    void deleteAllSalesOrder();

    @Query("Select * from OM_SALESORD where OrderDate = :timestamp")
    List<SalesOrderLocalEntity> getListSalesOrder(Long timestamp);

}

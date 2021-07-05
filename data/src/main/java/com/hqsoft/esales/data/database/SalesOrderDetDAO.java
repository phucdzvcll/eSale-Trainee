package com.hqsoft.esales.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hqsoft.esales.data.entity.SalesOrderDetLocalEntity;

import java.util.List;

@Dao
public interface SalesOrderDetDAO {
    @Insert()
    void insertAll(List<SalesOrderDetLocalEntity> salesOrderDetLocalEntities);

    @Query("DELETE from OM_SALESORDDET")
    void deleteAllSalesOrder();

    @Query("Select * from OM_SALESORDDET")
    List<SalesOrderDetLocalEntity> getListSalesOrder();
}

package com.hqsoft.esales.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hqsoft.esales.data.entity.SalesOrderDetLocalEntity;

import java.util.List;

@Dao
public interface SalesOrderDetDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SalesOrderDetLocalEntity> salesOrderDetLocalEntities);

    @Query("DELETE from OM_SALESORDDET")
    void deleteAllSalesOrder();

    @Query("Select * from OM_SALESORDDET")
    List<SalesOrderDetLocalEntity> getListSalesOrder();

    @Query("SELECT * From OM_SALESORDDET as v , OM_SALESORD as b Where v.OrderNbr == b.OrderNbr group by v.OrderNbr")
    List<SalesOrderDetLocalEntity> getListSalesOrder2();
}

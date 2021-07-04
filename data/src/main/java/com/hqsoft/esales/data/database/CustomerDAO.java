package com.hqsoft.esales.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hqsoft.esales.data.entity.CustomerLocalEntity;

import java.util.List;

@Dao
public interface CustomerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CustomerLocalEntity> customerLocalEntities);

    @Query("DELETE from AR_CUSTOMER")
    void deleteAllCustomer();

    @Query("Select * from AR_CUSTOMER")
    List<CustomerLocalEntity> getListCustomer();

    @Insert()
    void insertToTable(CustomerLocalEntity customerLocalEntity);
}



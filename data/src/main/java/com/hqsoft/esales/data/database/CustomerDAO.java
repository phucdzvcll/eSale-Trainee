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

    @Query("DELETE FROM AR_CUSTOMER")
    void deleteAllCustomer();

    @Query("SELECT * FROM AR_CUSTOMER")
    List<CustomerLocalEntity> getListCustomer();

    @Insert()
    void insertToTable(CustomerLocalEntity customerLocalEntity);

    @Query("SELECT * FROM AR_CUSTOMER WHERE Name LIKE  '%' || :search || '%' OR Address LIKE '%' || :search || '%' OR CustID LIKE '%' || :search || '%'")
    List<CustomerLocalEntity> getListCustomerBySearch(String search);
}



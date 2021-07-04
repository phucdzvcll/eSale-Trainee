package com.hqsoft.esales.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hqsoft.esales.data.entity.SalespersonLocalEntity;

import java.util.List;

@Dao
public interface SalespersonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SalespersonLocalEntity> salespersonLocalEntities);

    @Query("DELETE from AR_SALESPERSON")
    void deleteAllSalesperson();

    @Query("Select * from AR_SALESPERSON")
    List<SalespersonLocalEntity> getListSalesperson();
}

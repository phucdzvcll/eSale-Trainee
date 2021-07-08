package com.hqsoft.esales.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hqsoft.esales.data.entity.CustomerLocalEntity;
import com.hqsoft.esales.data.entity.InventoryLocalEntity;

import java.util.List;

@Dao
public interface InventoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<InventoryLocalEntity> inventoryLocalEntities);

    @Query("DELETE from IN_INVENTORY")
    void deleteAllInventory();

    @Query("Select * from IN_INVENTORY")
    List<InventoryLocalEntity> getListInventory();

    @Query("SELECT * FROM IN_INVENTORY WHERE Name LIKE  '%' || :search || '%' OR InvtID LIKE '%' || :search || '%' OR Price LIKE '%' || :search || '%'")
    List<InventoryLocalEntity> getListInventoriesBySearch(String search);
}

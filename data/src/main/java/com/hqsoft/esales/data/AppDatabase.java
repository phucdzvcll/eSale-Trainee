package com.hqsoft.esales.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.hqsoft.esales.data.database.CustomerDAO;
import com.hqsoft.esales.data.database.InventoryDAO;
import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.database.SalesOrderDetDAO;
import com.hqsoft.esales.data.database.SalespersonDAO;
import com.hqsoft.esales.data.entity.CustomerLocalEntity;
import com.hqsoft.esales.data.entity.InventoryLocalEntity;
import com.hqsoft.esales.data.entity.SalesOrderDetLocalEntity;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.data.entity.SalespersonLocalEntity;

@Database(entities = {
        CustomerLocalEntity.class,
        InventoryLocalEntity.class,
        SalesOrderLocalEntity.class,
        SalespersonLocalEntity.class,
        SalesOrderDetLocalEntity.class,
}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CustomerDAO customerDAO();

    public abstract InventoryDAO inventoryDAO();

    public abstract SalesOrderDAO salesOrderDAO();

    public abstract SalespersonDAO salespersonDAO();

    public abstract SalesOrderDetDAO salesOrderDetDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(final Context context) {
        String DATABASE_NAME = "myapp";
        String DATABASE_DIR = "database/myapp";
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .createFromAsset(DATABASE_DIR)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
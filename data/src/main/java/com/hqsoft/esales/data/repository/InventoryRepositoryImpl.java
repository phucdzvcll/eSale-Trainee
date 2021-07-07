package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.InventoryDAO;
import com.hqsoft.esales.data.entity.InventoryLocalEntity;
import com.hqsoft.esales.data.mapper.InventoryLocalMapper;
import com.hqsoft.esales.domain.entities.InventoryEntity;
import com.hqsoft.esales.domain.repository.InventoryRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class InventoryRepositoryImpl implements InventoryRepository {
    final InventoryDAO inventoryDAO;
    final InventoryLocalMapper inventoryLocalMapper;

    public InventoryRepositoryImpl(InventoryDAO inventoryDAO, InventoryLocalMapper inventoryLocalMapper) {
        this.inventoryDAO = inventoryDAO;
        this.inventoryLocalMapper = inventoryLocalMapper;
    }

    @Override
    public Single<List<InventoryEntity>> getListInventory() {
        List<InventoryLocalEntity> listLocalInventory = inventoryDAO.getListInventory();
        return Single.create(emitter ->
                emitter.onSuccess(inventoryLocalMapper.mapList(inventoryDAO.getListInventory()))
        );
    }
}

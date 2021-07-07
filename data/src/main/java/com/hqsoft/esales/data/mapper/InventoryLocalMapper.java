package com.hqsoft.esales.data.mapper;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.data.entity.InventoryLocalEntity;
import com.hqsoft.esales.domain.entities.InventoryEntity;

public class InventoryLocalMapper extends Mapper<InventoryLocalEntity, InventoryEntity> {
    @NonNull
    @Override
    public InventoryEntity map(@NonNull InventoryLocalEntity inventoryLocalEntity) {
        return new InventoryEntity(inventoryLocalEntity.getName(), inventoryLocalEntity.getId(), inventoryLocalEntity.getUnit(), inventoryLocalEntity.getPrice());
    }
}

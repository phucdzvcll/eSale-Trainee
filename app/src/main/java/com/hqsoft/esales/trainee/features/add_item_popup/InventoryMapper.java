package com.hqsoft.esales.trainee.features.add_item_popup;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.domain.entities.InventoryEntity;
import com.hqsoft.esales.trainee.features.add_item_popup.model.Inventory;

public class InventoryMapper extends Mapper<InventoryEntity, Inventory> {
    @NonNull
    @Override
    public Inventory map(@NonNull InventoryEntity inventoryEntity) {
        return new Inventory(inventoryEntity.getName(), inventoryEntity.getId(), inventoryEntity.getUnit(), inventoryEntity.getPrice());
    }
}

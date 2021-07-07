package com.hqsoft.esales.trainee.features.order;


import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.trainee.features.model.InventorySelected;

public class OrderDetMapper extends Mapper<InventorySelected, OrderEntity.SalesOrderDetEntity> {
    @NonNull
    @Override
    public OrderEntity.SalesOrderDetEntity map(@NonNull InventorySelected inventorySelected) {
        return new OrderEntity.SalesOrderDetEntity(inventorySelected.getInventory().getId(), inventorySelected.getAmount() * inventorySelected.getInventory().getPrice(), inventorySelected.getAmount());
    }
}

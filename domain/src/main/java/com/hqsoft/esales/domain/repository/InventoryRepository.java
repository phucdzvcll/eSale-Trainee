package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.InventoryEntity;

import java.util.List;

public interface InventoryRepository {
    List<InventoryEntity> getListInventory();
}

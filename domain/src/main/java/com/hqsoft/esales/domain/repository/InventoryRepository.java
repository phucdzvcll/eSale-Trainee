package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.InventoryEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface InventoryRepository {
    Single<List<InventoryEntity>> getListInventory();
}

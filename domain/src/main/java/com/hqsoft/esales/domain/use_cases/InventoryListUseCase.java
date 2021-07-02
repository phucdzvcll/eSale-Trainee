package com.hqsoft.esales.domain.use_cases;


import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.entities.InventoryEntity;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.ArrayList;
import java.util.List;

public class InventoryListUseCase extends UseCase<UseCaseParam.EmptyParam, InventoryListUseCase.Result> {

    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(UseCaseParam.EmptyParam emptyParam) {
        Result result = new Result(createListInventories());
        return new ResultPair<>(result, null);
    }

    List<InventoryEntity> createListInventories() {
        ArrayList<InventoryEntity> inventories = new ArrayList<>();
        inventories.add(new InventoryEntity("SP1", "Sản phẩm 1", "CHAI", "10000"));
        inventories.add(new InventoryEntity("SP2", "Sản phẩm 2", "LON", "15000"));
        inventories.add(new InventoryEntity("SP3", "Sản phẩm 3", "CHAI", "20000"));
        inventories.add(new InventoryEntity("SP4", "Sản phẩm 4", "LON", "17000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        inventories.add(new InventoryEntity("SP5", "Sản phẩm 5", "LON", "32000"));
        return inventories;
    }

    public static class Result {
        @NonNull
        public List<InventoryEntity> getInventoryEntities() {
            return inventoryEntities;
        }

        @NonNull
        final List<InventoryEntity> inventoryEntities;

        public Result(@NonNull List<InventoryEntity> inventoryEntities) {
            this.inventoryEntities = inventoryEntities;
        }
    }

}

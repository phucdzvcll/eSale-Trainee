package com.hqsoft.esales.domain.use_cases;


import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.InventoryEntity;
import com.hqsoft.esales.domain.repository.InventoryRepository;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.ArrayList;
import java.util.List;

public class InventoryListUseCase extends UseCase<UseCaseParam.EmptyParam, InventoryListUseCase.Result> {
    final InventoryRepository inventoryRepository;

    public InventoryListUseCase(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(UseCaseParam.EmptyParam emptyParam) {
        Result result = new Result(inventoryRepository.getListInventory());
        return new ResultPair<>(result, null);
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

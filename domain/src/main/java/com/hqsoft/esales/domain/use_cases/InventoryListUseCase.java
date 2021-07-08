package com.hqsoft.esales.domain.use_cases;


import androidx.annotation.NonNull;

import com.hqsoft.esales.domain.entities.InventoryEntity;
import com.hqsoft.esales.domain.repository.InventoryRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;

public class InventoryListUseCase extends RXUseCase<UseCaseParam.EmptyParam, InventoryListUseCase.Result> {
    final InventoryRepository inventoryRepository;

    public InventoryListUseCase(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Single<Result> execute(UseCaseParam.EmptyParam emptyParam) {
        return inventoryRepository.getListInventories().flatMap((Function<List<InventoryEntity>, SingleSource<Result>>) inventoryEntities ->
                Single.create((SingleOnSubscribe<Result>) emitter ->
                        emitter.onSuccess(new Result(inventoryEntities))
                ));
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

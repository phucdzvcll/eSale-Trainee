package com.hqsoft.esales.domain;


import androidx.annotation.NonNull;

import com.hqsoft.esales.domain.entities.InventoryEntity;
import com.hqsoft.esales.domain.repository.InventoryRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;

public class SearchInventoryUseCase extends RXUseCase<SearchInventoryUseCase.Param, SearchInventoryUseCase.Result> {
    final InventoryRepository inventoryRepository;

    public SearchInventoryUseCase(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Single<Result> execute(SearchInventoryUseCase.Param param) {
        return inventoryRepository.getListInventoriesBySearch(param.searchText).flatMap((Function<List<InventoryEntity>, SingleSource<Result>>) inventoryEntities ->
                Single.just(new Result(inventoryEntities))
        );
    }

    public static class Param implements UseCaseParam {
        final private String searchText;

        public String getSearchText() {
            return searchText;
        }

        public Param(String searchText) {
            this.searchText = searchText;
        }
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

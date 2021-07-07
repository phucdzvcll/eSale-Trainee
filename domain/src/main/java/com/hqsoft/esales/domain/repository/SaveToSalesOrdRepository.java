package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.use_cases.SaveOderUseCase;

import io.reactivex.rxjava3.core.Single;

public interface SaveToSalesOrdRepository {
    Single<SaveOderUseCase.Result> saveToSalesOrder(OrderEntity orderEntity);
}

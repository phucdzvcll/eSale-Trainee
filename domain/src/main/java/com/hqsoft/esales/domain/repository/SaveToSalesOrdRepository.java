package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.use_cases.SaveOderUseCase;

public interface SaveToSalesOrdRepository {
    SaveOderUseCase.Result saveToSalesOrder(OrderEntity orderEntity);
}

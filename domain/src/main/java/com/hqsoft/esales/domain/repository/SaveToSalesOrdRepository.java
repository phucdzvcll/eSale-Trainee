package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.SalesOrderEntity;

public interface SaveToSalesOrdRepository {
    void saveToSalesOrder(SalesOrderEntity salesOrderEntity);
}

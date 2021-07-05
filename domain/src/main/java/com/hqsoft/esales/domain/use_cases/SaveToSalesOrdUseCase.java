package com.hqsoft.esales.domain.use_cases;

import com.hqsoft.esales.domain.entities.SalesOrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;

public class SaveToSalesOrdUseCase {
    final SaveToSalesOrdRepository repository;

    public SaveToSalesOrdUseCase(SaveToSalesOrdRepository repository) {
        this.repository = repository;
    }

    public void execute(SalesOrderEntity salesPersonEntity) {
        repository.saveToSalesOrder(salesPersonEntity);
    }
}

package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.mapper.SalesOrderEntityMapper;
import com.hqsoft.esales.domain.entities.SalesOrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;

public class SaveToSalesOrderRepositoryImpl implements SaveToSalesOrdRepository {
    final SalesOrderDAO salesOrderDAO;
    final SalesOrderEntityMapper salesOrderEntityMapper;

    public SaveToSalesOrderRepositoryImpl(SalesOrderDAO salesOrderDAO, SalesOrderEntityMapper salesOrderEntityMapper) {
        this.salesOrderDAO = salesOrderDAO;
        this.salesOrderEntityMapper = salesOrderEntityMapper;
    }

    @Override
    public void saveToSalesOrder(SalesOrderEntity salesOrderEntity) {
        salesOrderDAO.insert(salesOrderEntityMapper.map(salesOrderEntity));
    }
}

package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.database.SalesOrderDetDAO;
import com.hqsoft.esales.data.entity.SalesOrderDetLocalEntity;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.data.mapper.SalesOrderDeMapper;
import com.hqsoft.esales.data.mapper.SalesOrderEntityMapper;
import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;
import com.hqsoft.esales.domain.use_cases.SaveOderUseCase;

import java.util.List;

public class SaveToSalesOrderRepositoryImpl implements SaveToSalesOrdRepository {
    final SalesOrderDAO salesOrderDAO;
    final SalesOrderDetDAO salesOrderDetDAO;
    final SalesOrderEntityMapper salesOrderEntityMapper;
    final SalesOrderDeMapper salesOrderDeMapper;

    public SaveToSalesOrderRepositoryImpl(SalesOrderDAO salesOrderDAO, SalesOrderDetDAO salesOrderDetDAO, SalesOrderEntityMapper salesOrderEntityMapper, SalesOrderDeMapper salesOrderDeMapper) {
        this.salesOrderDAO = salesOrderDAO;
        this.salesOrderDetDAO = salesOrderDetDAO;
        this.salesOrderEntityMapper = salesOrderEntityMapper;
        this.salesOrderDeMapper = salesOrderDeMapper;
    }

    @Override
    public SaveOderUseCase.Result saveToSalesOrder(OrderEntity orderEntity) {
        SalesOrderLocalEntity salesOrderLocalEntity = salesOrderEntityMapper.map(orderEntity.getSalesOrderEntity());
        List<SalesOrderDetLocalEntity> salesOrderDetLocalEntityList = salesOrderDeMapper.mapList(orderEntity.getOrderDetEntityList(), salesOrderLocalEntity.getOrderNbr());
        salesOrderDAO.insert(salesOrderLocalEntity);
        salesOrderDetDAO.insertAll(salesOrderDetLocalEntityList);
        return new SaveOderUseCase.Result();
    }
}

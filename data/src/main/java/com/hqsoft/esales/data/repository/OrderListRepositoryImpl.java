package com.hqsoft.esales.data.repository;

import android.util.Log;

import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.data.mapper.OrderListLocalMapper;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.domain.repository.OrderListRepository;

import java.util.List;

public class OrderListRepositoryImpl implements OrderListRepository {
    final SalesOrderDAO salesOrderDAO;
    final OrderListLocalMapper orderListLocalMapper;

    public OrderListRepositoryImpl(SalesOrderDAO salesOrderDetDAO, OrderListLocalMapper orderListLocalMapper) {
        this.salesOrderDAO = salesOrderDetDAO;
        this.orderListLocalMapper = orderListLocalMapper;
    }

    @Override
    public List<OrderListEntity> getOrderList() {
        List<SalesOrderLocalEntity> listSalesOrder = salesOrderDAO.getListSalesOrder();
        return orderListLocalMapper.mapList(listSalesOrder);
    }
}

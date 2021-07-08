package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.SalesOrderDAO;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.data.mapper.OrderListLocalMapper;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.domain.repository.OrderListRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class OrderListRepositoryImpl implements OrderListRepository {
    final SalesOrderDAO salesOrderDAO;
    final OrderListLocalMapper orderListLocalMapper;

    public OrderListRepositoryImpl(SalesOrderDAO salesOrderDetDAO, OrderListLocalMapper orderListLocalMapper) {
        this.salesOrderDAO = salesOrderDetDAO;
        this.orderListLocalMapper = orderListLocalMapper;
    }

    @Override
    public Single<List<OrderListEntity>> getOrderList(Date date) {
        return Single.create(emitter ->
                emitter.onSuccess(orderListLocalMapper.mapList(salesOrderDAO.getListSalesOrder(date.getTime())))
        );
    }
}

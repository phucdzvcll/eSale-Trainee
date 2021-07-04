package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.OrderListEntity;

import java.util.List;

public interface OrderListRepository {
    List<OrderListEntity> getOrderList();
}

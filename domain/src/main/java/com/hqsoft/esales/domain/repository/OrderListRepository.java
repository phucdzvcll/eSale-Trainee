package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.OrderListEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface OrderListRepository {
    Single<List<OrderListEntity>> getOrderList();
}

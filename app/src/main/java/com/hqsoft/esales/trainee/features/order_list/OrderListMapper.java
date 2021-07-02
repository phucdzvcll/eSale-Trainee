package com.hqsoft.esales.trainee.features.order_list;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.trainee.features.order_list.model.OrderList;

public class OrderListMapper extends Mapper<OrderListEntity, OrderList> {
    @NonNull
    @Override
    public OrderList map(@NonNull OrderListEntity orderListEntity) {
        return new OrderList(orderListEntity.getOrderNbr(), orderListEntity.getSlsperId(), orderListEntity.getCustomerId(), orderListEntity.getOrderAmt(), orderListEntity.getOrderQty(), orderListEntity.getOrderDate(), orderListEntity.getRemark());
    }

}

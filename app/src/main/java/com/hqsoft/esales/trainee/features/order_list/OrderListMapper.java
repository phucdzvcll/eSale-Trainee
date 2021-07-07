package com.hqsoft.esales.trainee.features.order_list;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.trainee.features.order_list.model.SalesOrder;

public class OrderListMapper extends Mapper<OrderListEntity, SalesOrder> {
    @NonNull
    @Override
    public SalesOrder map(@NonNull OrderListEntity orderListEntity) {
        return new SalesOrder(orderListEntity.getOrderNbr(), orderListEntity.getSlsperId(), orderListEntity.getCustomerId(), orderListEntity.getOrderAmt(), orderListEntity.getOrderQty(), orderListEntity.getOrderDate(), orderListEntity.getRemark());
    }

}

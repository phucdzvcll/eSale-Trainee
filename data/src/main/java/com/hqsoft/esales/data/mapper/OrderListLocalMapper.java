package com.hqsoft.esales.data.mapper;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.domain.entities.OrderListEntity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class OrderListLocalMapper extends Mapper<SalesOrderLocalEntity, OrderListEntity> {
    @NonNull
    @Override
    public OrderListEntity map(@NonNull SalesOrderLocalEntity salesOrderLocalEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        return new OrderListEntity(salesOrderLocalEntity.getOrderNbr(), salesOrderLocalEntity.getSlsperId(), salesOrderLocalEntity.getCustomerId(), salesOrderLocalEntity.getOrderAmt(), salesOrderLocalEntity.getOrderQty(), formatter.format(salesOrderLocalEntity.getOrderDate()), salesOrderLocalEntity.getRemark());
    }
}

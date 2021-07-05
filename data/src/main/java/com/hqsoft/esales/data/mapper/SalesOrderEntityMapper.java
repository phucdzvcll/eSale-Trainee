package com.hqsoft.esales.data.mapper;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.domain.entities.SalesOrderEntity;

public class SalesOrderEntityMapper extends Mapper<SalesOrderEntity, SalesOrderLocalEntity> {
    @NonNull
    @Override
    public SalesOrderLocalEntity map(@NonNull SalesOrderEntity salesOrderEntity) {
        return new SalesOrderLocalEntity(salesOrderEntity.getOrderNbr(), salesOrderEntity.getSlsperId(), salesOrderEntity.getCustomerId(), salesOrderEntity.getOrderAmt(), salesOrderEntity.getOrderQty(), salesOrderEntity.getOrderDate(), salesOrderEntity.getRemark());
    }
}

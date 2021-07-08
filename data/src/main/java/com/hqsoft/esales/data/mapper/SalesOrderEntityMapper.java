package com.hqsoft.esales.data.mapper;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.data.entity.SalesOrderLocalEntity;
import com.hqsoft.esales.domain.entities.OrderEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SalesOrderEntityMapper extends Mapper<OrderEntity.SalesOrderEntity, SalesOrderLocalEntity> {
    @NonNull
    @Override
    public SalesOrderLocalEntity map(@NonNull OrderEntity.SalesOrderEntity salesOrderEntity) {
        return new SalesOrderLocalEntity(salesOrderEntity.getCustomerId() + randomTime(), salesOrderEntity.getSlsperId(), salesOrderEntity.getCustomerId(), salesOrderEntity.getOrderAmt(), salesOrderEntity.getOrderQty(), salesOrderEntity.getOrderDate(), salesOrderEntity.getRemark());
    }

    private int randomTime() {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date = c.getTime();
        return (int) date.getTime();
    }
}

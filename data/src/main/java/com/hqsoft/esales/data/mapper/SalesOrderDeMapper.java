package com.hqsoft.esales.data.mapper;

import com.hqsoft.esales.data.entity.SalesOrderDetLocalEntity;
import com.hqsoft.esales.domain.entities.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class SalesOrderDeMapper {
    public SalesOrderDetLocalEntity mapper(OrderEntity.SalesOrderDetEntity salesOrderDetEntity, String orderNbr, int lineRef) {
        return new SalesOrderDetLocalEntity(orderNbr, lineRef, salesOrderDetEntity.getInvtd(), salesOrderDetEntity.getLineAmt(), salesOrderDetEntity.getLineQty());
    }

    public List<SalesOrderDetLocalEntity> mapList(List<OrderEntity.SalesOrderDetEntity> salesOrderDetEntities, String orderNbr) {
        ArrayList<SalesOrderDetLocalEntity> salesOrderDetLocalEntities = new ArrayList<>();
        for (int i = 0; i < salesOrderDetEntities.size(); i++) {
            salesOrderDetLocalEntities.add(mapper(salesOrderDetEntities.get(i), orderNbr, i));
        }
        return salesOrderDetLocalEntities;
    }
}

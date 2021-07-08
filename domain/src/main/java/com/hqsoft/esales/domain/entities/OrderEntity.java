package com.hqsoft.esales.domain.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderEntity{

    final SalesOrderEntity salesOrderEntity;
    final List<SalesOrderDetEntity> salesOrderDetEntityList;

    public SalesOrderEntity getSalesOrderEntity() {
        return salesOrderEntity;
    }

    public List<SalesOrderDetEntity> getOrderDetEntityList() {
        return salesOrderDetEntityList;
    }

    public OrderEntity(SalesOrderEntity salesOrderEntity, List<SalesOrderDetEntity> salesOrderDetEntityList) {
        this.salesOrderEntity = salesOrderEntity;
        this.salesOrderDetEntityList = salesOrderDetEntityList;
    }

    public static class SalesOrderEntity {
        private final String slsperId;
        private final String customerId;
        private final double orderAmt;
        private final double orderQty;
        private final Date orderDate;
        private final String remark;

        public String getSlsperId() {
            return slsperId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public double getOrderAmt() {
            return orderAmt;
        }

        public double getOrderQty() {
            return orderQty;
        }

        public Date getOrderDate() {
            return orderDate;
        }

        public String getRemark() {
            return remark;
        }

        public SalesOrderEntity(String slsperId, String customerId, double orderAmt, double orderQty, String remark) {
            this.slsperId = slsperId;
            this.customerId = customerId;
            this.orderAmt = orderAmt;
            this.orderQty = orderQty;
            this.orderDate = getTime();
            this.remark = remark;
        }
    }

    private static Date getTime() {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
        return c.getTime();
    }

    public static class SalesOrderDetEntity {
        final String invId;
        final double lineAmt;
        final double lineQty;

        public String getInvtd() {
            return invId;
        }

        public double getLineAmt() {
            return lineAmt;
        }

        public double getLineQty() {
            return lineQty;
        }

        public SalesOrderDetEntity(String invId, double lineAmt, double lineQty) {
            this.invId = invId;
            this.lineAmt = lineAmt;
            this.lineQty = lineQty;
        }
    }
}



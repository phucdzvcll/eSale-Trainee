package com.hqsoft.esales.domain.entities;

import java.util.Date;

public class SalesOrderEntity {
    private final String orderNbr;
    private final String slsperId;
    private final String customerId;
    private final double orderAmt;
    private final double orderQty;
    private final Date orderDate;
    private final String remark;

    public String getOrderNbr() {
        return orderNbr;
    }

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

    public SalesOrderEntity(String orderNbr, String slsperId, String customerId, double orderAmt, double orderQty, String remark) {
        this.orderNbr = orderNbr;
        this.slsperId = slsperId;
        this.customerId = customerId;
        this.orderAmt = orderAmt;
        this.orderQty = orderQty;
        this.orderDate = new Date();
        this.remark = remark;
    }
}

package com.hqsoft.esales.domain.entities;

public class OrderListEntity {
    public String getOrderNbr() {
        return orderNbr;
    }

    public String getSlsperId() {
        return slsperId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getOrderAmt() {
        return orderAmt;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getRemark() {
        return remark;
    }

    final String orderNbr;
    final String slsperId;
    final String customerId;
    final int orderAmt;
    final int orderQty;
    final String orderDate;
    final String remark;

    public OrderListEntity(String orderNbr, String slsperId, String customerId, int orderAmt, int orderQty, String orderDate, String remark) {
        this.orderNbr = orderNbr;
        this.slsperId = slsperId;
        this.customerId = customerId;
        this.orderAmt = orderAmt;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.remark = remark;
    }
}

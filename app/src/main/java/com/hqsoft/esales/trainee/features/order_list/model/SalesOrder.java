package com.hqsoft.esales.trainee.features.order_list.model;

public class SalesOrder {
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

    private final String orderNbr;
    private final String slsperId;
    private final String customerId;
    private final int orderAmt;
    private final int orderQty;
    private final String orderDate;
    private final String remark;

    public SalesOrder(String orderNbr, String slsperId, String customerId, int orderAmt, int orderQty, String orderDate, String remark) {
        this.orderNbr = orderNbr;
        this.slsperId = slsperId;
        this.customerId = customerId;
        this.orderAmt = orderAmt;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.remark = remark;
    }
}

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

    public double getOrderAmt() {
        return orderAmt;
    }

    public double getOrderQty() {
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
    private final double orderAmt;
    private final double orderQty;
    private final String orderDate;
    private final String remark;

    public SalesOrder(String orderNbr, String slsperId, String customerId, double orderAmt, double orderQty, String orderDate, String remark) {
        this.orderNbr = orderNbr;
        this.slsperId = slsperId;
        this.customerId = customerId;
        this.orderAmt = orderAmt;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.remark = remark;
    }
}

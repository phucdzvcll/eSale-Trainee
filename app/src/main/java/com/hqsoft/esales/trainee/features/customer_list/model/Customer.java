package com.hqsoft.esales.trainee.features.customer_list.model;

public class Customer {
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCusId() {
        return cusId;
    }

    public String getPhone() {
        return phone;
    }

    public Customer(String name, String address, String cusId, String phone) {
        this.name = name;
        this.address = address;
        this.cusId = cusId;
        this.phone = phone;
    }

    private final String name;
    private final String address;
    private final String cusId;
    private final String phone;
}

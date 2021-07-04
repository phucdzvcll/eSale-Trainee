package com.hqsoft.esales.domain.entities;

public class SalesPersonEntity {
    final String slsperID;
    final String password;
    final String name;
    final String address;

    public String getSlsperID() {
        return slsperID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public SalesPersonEntity(String slsperID, String password, String name, String address) {
        this.slsperID = slsperID;
        this.password = password;
        this.name = name;
        this.address = address;
    }
}

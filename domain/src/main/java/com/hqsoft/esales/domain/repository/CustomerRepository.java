package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.CustomerEntity;

import java.util.List;

public interface CustomerRepository {
    List<CustomerEntity> getListCustomer();
}

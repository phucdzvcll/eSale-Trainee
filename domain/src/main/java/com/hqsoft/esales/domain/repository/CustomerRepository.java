package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.CustomerEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface CustomerRepository {
//    List<CustomerEntity> getListCustomer();

    Single<List<CustomerEntity>> getListCustomerRX();
}

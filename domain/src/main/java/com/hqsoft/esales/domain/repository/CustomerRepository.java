package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.CustomerEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface CustomerRepository {
    Single<List<CustomerEntity>> getListCustomerRX();

    Single<List<CustomerEntity>> getListCustomerBySearchRX(String searchText);
}

package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.CustomerDAO;
import com.hqsoft.esales.data.mapper.CustomerLocalMapper;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.repository.CustomerRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class CustomerRepositoryImpl implements CustomerRepository {
    final CustomerDAO customerDAO;
    final CustomerLocalMapper customerLocalMapper;

    public CustomerRepositoryImpl(CustomerDAO customerDAO, CustomerLocalMapper customerLocalMapper) {
        this.customerDAO = customerDAO;
        this.customerLocalMapper = customerLocalMapper;
    }

    @Override
    public Single<List<CustomerEntity>> getListCustomerRX() {
        return Single.create(emitter ->
                emitter.onSuccess(customerLocalMapper.mapList(customerDAO.getListCustomer()))
        );
    }

    @Override
    public Single<List<CustomerEntity>> getListCustomerBySearchRX(String searchText) {
        return Single.create(emitter ->
                emitter.onSuccess(customerLocalMapper.mapList(customerDAO.getListCustomerBySearch(searchText)))
        );
    }
}

package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.CustomerDAO;
import com.hqsoft.esales.data.entity.CustomerLocalEntity;
import com.hqsoft.esales.data.mapper.CustomerLocalMapper;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    final CustomerDAO customerDAO;
    final CustomerLocalMapper customerLocalMapper;

    public CustomerRepositoryImpl(CustomerDAO customerDAO, CustomerLocalMapper customerLocalMapper) {
        this.customerDAO = customerDAO;
        this.customerLocalMapper = customerLocalMapper;
    }

    @Override
    public List<CustomerEntity> getListCustomer() {
        List<CustomerLocalEntity> listLocalCustomer = customerDAO.getListCustomer();
        return customerLocalMapper.mapList(listLocalCustomer);
    }
}

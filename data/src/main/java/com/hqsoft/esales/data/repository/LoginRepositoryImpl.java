package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.SalespersonDAO;
import com.hqsoft.esales.data.entity.SalespersonLocalEntity;
import com.hqsoft.esales.data.mapper.SalespersonLocalMapper;
import com.hqsoft.esales.domain.entities.SalesPersonEntity;
import com.hqsoft.esales.domain.repository.LoginRepository;

public class LoginRepositoryImpl implements LoginRepository {
    final SalespersonDAO salespersonDAO;
    final SalespersonLocalMapper salespersonLocalMapper;

    public LoginRepositoryImpl(SalespersonDAO salespersonDAO, SalespersonLocalMapper salespersonLocalMapper) {
        this.salespersonDAO = salespersonDAO;
        this.salespersonLocalMapper = salespersonLocalMapper;
    }

    @Override
    public SalesPersonEntity getSalesEntity(String slsperId) {
        SalespersonLocalEntity salespersonLocal = salespersonDAO.getSalesperson(slsperId);
        return salespersonLocalMapper.map(salespersonLocal);
    }
}

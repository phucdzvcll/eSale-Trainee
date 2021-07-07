package com.hqsoft.esales.data.repository;

import com.hqsoft.esales.data.database.SalespersonDAO;
import com.hqsoft.esales.data.mapper.SalespersonLocalMapper;
import com.hqsoft.esales.domain.entities.SalesPersonEntity;
import com.hqsoft.esales.domain.repository.LoginRepository;

import io.reactivex.rxjava3.core.Single;

public class LoginRepositoryImpl implements LoginRepository {
    final SalespersonDAO salespersonDAO;
    final SalespersonLocalMapper salespersonLocalMapper;

    public LoginRepositoryImpl(SalespersonDAO salespersonDAO, SalespersonLocalMapper salespersonLocalMapper) {
        this.salespersonDAO = salespersonDAO;
        this.salespersonLocalMapper = salespersonLocalMapper;
    }

    @Override
    public Single<SalesPersonEntity> getSalesEntityRX(String slsperId) {
        return Single.create(emitter ->
                emitter.onSuccess(salespersonLocalMapper.map(salespersonDAO.getSalesperson(slsperId)))
        );
    }
}

package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.SalesPersonEntity;

import io.reactivex.rxjava3.core.Single;

public interface LoginRepository {
    Single<SalesPersonEntity> getSalesEntityRX(String slsperId);
}

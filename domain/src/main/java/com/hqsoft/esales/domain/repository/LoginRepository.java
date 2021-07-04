package com.hqsoft.esales.domain.repository;

import com.hqsoft.esales.domain.entities.SalesPersonEntity;

public interface LoginRepository {
    SalesPersonEntity getSalesEntity(String slsperId);
}

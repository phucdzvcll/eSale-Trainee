package com.hqsoft.esales.data.mapper;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.data.entity.SalespersonLocalEntity;
import com.hqsoft.esales.domain.entities.SalesPersonEntity;

public class SalespersonLocalMapper extends Mapper<SalespersonLocalEntity, SalesPersonEntity> {
    @NonNull
    @Override
    public SalesPersonEntity map(@NonNull SalespersonLocalEntity salespersonLocalEntity) {
        return new SalesPersonEntity(salespersonLocalEntity.getSlsperId(), salespersonLocalEntity.getPassword(), salespersonLocalEntity.getFullName(), salespersonLocalEntity.getAddress());
    }
}

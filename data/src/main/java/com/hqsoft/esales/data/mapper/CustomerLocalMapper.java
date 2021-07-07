package com.hqsoft.esales.data.mapper;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.data.entity.CustomerLocalEntity;
import com.hqsoft.esales.domain.entities.CustomerEntity;

public class CustomerLocalMapper extends Mapper<CustomerLocalEntity, CustomerEntity> {
    @NonNull
    @Override
    public CustomerEntity map(@NonNull CustomerLocalEntity customerLocalEntity) {
        return new CustomerEntity(customerLocalEntity.getName(), customerLocalEntity.getAddress(), customerLocalEntity.getCusId(), customerLocalEntity.getPhone());
    }
}

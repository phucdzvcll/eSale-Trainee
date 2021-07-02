package com.hqsoft.esales.trainee.features.customer_list;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.mapper.Mapper;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.trainee.features.customer_list.model.Customer;

public class CustomerListMapper extends Mapper<CustomerEntity, Customer> {
    @NonNull
    @Override
    public Customer map(@NonNull CustomerEntity customerEntity) {
        return new Customer(customerEntity.getName(), customerEntity.getAddress(), customerEntity.getCusId(), customerEntity.getPhone());
    }
}

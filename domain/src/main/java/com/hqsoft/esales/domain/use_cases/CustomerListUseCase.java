package com.hqsoft.esales.domain.use_cases;


import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.repository.CustomerRepository;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.ArrayList;
import java.util.List;

public class CustomerListUseCase extends UseCase<UseCaseParam.EmptyParam, CustomerListUseCase.Result> {

    final CustomerRepository customerRepository;

    public CustomerListUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(UseCaseParam.EmptyParam emptyParam) {
        Result result = new Result(customerRepository.getListCustomer());

        return new ResultPair<>(result, null);
    }

    public static class Result {
        @NonNull
        public List<CustomerEntity> getCustomerEntityList() {
            return customerEntityList;
        }

        @NonNull
        final List<CustomerEntity> customerEntityList;

        public Result(@NonNull List<CustomerEntity> customerEntityList) {
            this.customerEntityList = customerEntityList;
        }
    }

}

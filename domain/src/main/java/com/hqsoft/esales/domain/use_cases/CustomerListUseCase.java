package com.hqsoft.esales.domain.use_cases;


import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.repository.CustomerRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;

public class CustomerListUseCase extends RXUseCase<UseCaseParam.EmptyParam, CustomerListUseCase.Result> {

    final CustomerRepository customerRepository;

    public CustomerListUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Single<Result> execute(UseCaseParam.EmptyParam emptyParam) {
        return customerRepository.getListCustomerRX().flatMap((Function<List<CustomerEntity>, SingleSource<Result>>) customerEntities ->
                Single.just(new Result(customerEntities))
        );
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

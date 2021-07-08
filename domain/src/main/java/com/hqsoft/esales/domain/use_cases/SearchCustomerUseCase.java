package com.hqsoft.esales.domain.use_cases;

import androidx.annotation.NonNull;

import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.repository.CustomerRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;

public class SearchCustomerUseCase extends RXUseCase<SearchCustomerUseCase.Param, SearchCustomerUseCase.Result> {
    final CustomerRepository customerRepository;

    public SearchCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Single<Result> execute(Param param) {
        return customerRepository.getListCustomerBySearchRX(param.searchText).flatMap((Function<List<CustomerEntity>, SingleSource<Result>>) customerEntities ->
                Single.create((SingleOnSubscribe<Result>) emitter ->
                        emitter.onSuccess(new Result(customerEntities))
                )
        );
    }

    public static class Param implements UseCaseParam {
        final private String searchText;

        public String getSearchText() {
            return searchText;
        }

        public Param(String searchText) {
            this.searchText = searchText;
        }
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

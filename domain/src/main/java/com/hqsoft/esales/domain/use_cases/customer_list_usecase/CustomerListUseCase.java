package com.hqsoft.esales.domain.use_cases.customer_list_usecase;


import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.CustomerEntity;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CustomerListUseCase extends UseCase<UseCaseParam.EmptyParam, CustomerListUseCase.Result> {

    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(UseCaseParam.EmptyParam emptyParam) {
        Result result = new Result(createListCustomer());
        return new ResultPair<>(result, null);
    }

    List<CustomerEntity> createListCustomer() {
        ArrayList<CustomerEntity> customers = new ArrayList<>();
        customers.add(new CustomerEntity("Khách Hàng A", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID1", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng B", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID2", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng C", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID3", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng D", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID4", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        customers.add(new CustomerEntity("Khách Hàng E", "72/24 Phan Đăng Lưu, P5, Phú Nhuận, HCM", "CustID5", "1234567890"));
        return customers;
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

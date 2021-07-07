package com.hqsoft.esales.domain.use_cases;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.domain.repository.OrderListRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;

public class OrderListUseCase extends RXUseCase<UseCaseParam.EmptyParam, OrderListUseCase.Result> {
    final OrderListRepository orderListRepository;

    public OrderListUseCase(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    public Single<Result> execute(UseCaseParam.EmptyParam emptyParam) {
        return orderListRepository.getOrderList().flatMap((Function<List<OrderListEntity>, SingleSource<Result>>) orderListEntities ->
                Single.just(new Result(orderListEntities))
        );
    }


    public static class Result {
        @NonNull
        public List<OrderListEntity> getCustomerEntityList() {
            return OrderListEntityEntities;
        }

        @NonNull
        final List<OrderListEntity> OrderListEntityEntities;

        public Result(@NonNull List<OrderListEntity> OrderListEntityEntities) {
            this.OrderListEntityEntities = OrderListEntityEntities;
        }
    }
}

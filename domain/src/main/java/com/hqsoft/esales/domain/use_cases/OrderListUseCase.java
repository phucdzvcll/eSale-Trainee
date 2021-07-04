package com.hqsoft.esales.domain.use_cases;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.domain.repository.OrderListRepository;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.List;

public class OrderListUseCase extends UseCase<UseCaseParam.EmptyParam, OrderListUseCase.Result> {
    final OrderListRepository orderListRepository;

    public OrderListUseCase(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(UseCaseParam.EmptyParam emptyParam) {
        OrderListUseCase.Result result = new OrderListUseCase.Result(orderListRepository.getOrderList());
        return new ResultPair<>(result, null);
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

package com.hqsoft.esales.domain.use_cases;

import androidx.annotation.NonNull;

import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.domain.repository.OrderListRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;

public class OrderListUseCase extends RXUseCase<OrderListUseCase.Param, OrderListUseCase.Result> {
    final OrderListRepository orderListRepository;

    public OrderListUseCase(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @Override
    public Single<Result> execute(OrderListUseCase.Param param) {
        return orderListRepository.getOrderList(param.date).flatMap((Function<List<OrderListEntity>, SingleSource<Result>>) orderListEntities ->
                Single.just(new Result(orderListEntities))
        );
    }

    public static class Param implements UseCaseParam{
        final private Date date;

        public Date getDate() {
            return date;
        }

        public Param(Date date) {
            this.date = date;
        }
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

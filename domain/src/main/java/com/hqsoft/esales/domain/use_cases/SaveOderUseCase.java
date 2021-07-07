package com.hqsoft.esales.domain.use_cases;

import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import io.reactivex.rxjava3.core.Single;

public class SaveOderUseCase extends RXUseCase<SaveOderUseCase.Param, SaveOderUseCase.Result> {
    final SaveToSalesOrdRepository repository;

    public SaveOderUseCase(SaveToSalesOrdRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Result> execute(Param param) {
        return repository.saveToSalesOrder(param.getOrderEntity());
    }

    public static class Result {
    }

    public final static class Param implements UseCaseParam {
        private OrderEntity getOrderEntity() {
            return orderEntity;
        }

        final private OrderEntity orderEntity;

        public Param(OrderEntity orderEntity) {
            this.orderEntity = orderEntity;
        }
    }
}

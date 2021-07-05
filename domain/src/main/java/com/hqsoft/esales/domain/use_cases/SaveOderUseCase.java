package com.hqsoft.esales.domain.use_cases;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.OrderEntity;
import com.hqsoft.esales.domain.repository.SaveToSalesOrdRepository;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

public class SaveOderUseCase extends UseCase<SaveOderUseCase.Param, SaveOderUseCase.Result> {
    final SaveToSalesOrdRepository repository;

    public SaveOderUseCase(SaveToSalesOrdRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(Param param) {
        Result result = repository.saveToSalesOrder(param.orderEntity);
        return new ResultPair<>(result,null);
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

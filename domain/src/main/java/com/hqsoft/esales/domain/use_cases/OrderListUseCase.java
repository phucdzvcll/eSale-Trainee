package com.hqsoft.esales.domain.use_cases;

import androidx.annotation.NonNull;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.OrderListEntity;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import java.util.ArrayList;
import java.util.List;

public class OrderListUseCase extends UseCase<UseCaseParam.EmptyParam, OrderListUseCase.Result> {

    @Override
    protected ResultPair<Result, UseCaseError> executeInternal(UseCaseParam.EmptyParam emptyParam) {
        OrderListUseCase.Result result = new OrderListUseCase.Result(createListOrder());
        return new ResultPair<>(result, null);
    }

    private List<OrderListEntity> createListOrder() {
        ArrayList<OrderListEntity> OrderListEntitys = new ArrayList<>();
        OrderListEntitys.add(new OrderListEntity("Sales10001", "Sales1", "CustId1", 35000, 3, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales10002", "Sales1", "CustId1", 50000, 5, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales20001", "Sales2", "CustId2", 40000, 2, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales30001", "Sales3", "CustId3", 51000, 3, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        OrderListEntitys.add(new OrderListEntity("Sales40001", "Sales4", "CustId4", 128000, 4, "2018-08-09", "Gi chú"));
        return OrderListEntitys;
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

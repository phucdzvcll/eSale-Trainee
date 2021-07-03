package com.hqsoft.esales.domain.use_cases.base;

import com.hqsoft.esales.common_jvm.common.ResultPair;

abstract public class UseCase<Params extends UseCaseParam, Result> {

    protected abstract ResultPair<Result, UseCaseError> executeInternal(Params params);

    public ResultPair<Result, UseCaseError> execute(Params params) {
        try {
            return executeInternal(params);
        } catch (Exception e) {
            UseCaseError commonError = new UseCaseError.CommonError(e.getMessage());
            return new ResultPair<>(null, commonError);
        }
    }
}

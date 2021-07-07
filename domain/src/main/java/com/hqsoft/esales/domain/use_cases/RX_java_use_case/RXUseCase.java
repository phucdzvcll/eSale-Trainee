package com.hqsoft.esales.domain.use_cases.RX_java_use_case;

import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import io.reactivex.rxjava3.core.Single;

public abstract class RXUseCase<Params extends UseCaseParam, Result> {

    public abstract Single<Result> execute(Params params);

}
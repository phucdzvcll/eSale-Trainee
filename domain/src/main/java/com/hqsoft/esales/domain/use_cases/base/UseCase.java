package com.hqsoft.esales.domain.use_cases.base;

abstract class UseCase<Params extends UseCaseParam, Result>{

    protected abstract Result executeInternal(Params params);

    Result execute(Params params){
         try{
             return executeInternal(params);
        }catch (Exception e){
            return null;
        }
    }
}

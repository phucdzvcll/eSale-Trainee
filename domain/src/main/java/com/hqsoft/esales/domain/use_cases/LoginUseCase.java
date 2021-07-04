package com.hqsoft.esales.domain.use_cases;

import com.hqsoft.esales.common_jvm.common.ResultPair;
import com.hqsoft.esales.domain.entities.SalesPersonEntity;
import com.hqsoft.esales.domain.repository.LoginRepository;
import com.hqsoft.esales.domain.use_cases.base.UseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseError;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

public class LoginUseCase extends UseCase<LoginUseCase.Param, SalesPersonEntity> {
    final LoginRepository loginRepository;

    public LoginUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    protected ResultPair<SalesPersonEntity, UseCaseError> executeInternal(Param param) {
        return new ResultPair<>(loginRepository.getSalesEntity(param.getParam()), null);
    }

    public final static class Param implements UseCaseParam {
        final String param;

        public String getParam() {
            return param;
        }

        public Param(String param) {
            this.param = param;
        }
    }
}

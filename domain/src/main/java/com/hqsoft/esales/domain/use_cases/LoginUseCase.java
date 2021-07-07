package com.hqsoft.esales.domain.use_cases;

import com.hqsoft.esales.domain.entities.SalesPersonEntity;
import com.hqsoft.esales.domain.repository.LoginRepository;
import com.hqsoft.esales.domain.use_cases.RX_java_use_case.RXUseCase;
import com.hqsoft.esales.domain.use_cases.base.UseCaseParam;

import io.reactivex.rxjava3.core.Single;

public class LoginUseCase extends RXUseCase<LoginUseCase.Param, SalesPersonEntity> {
    final LoginRepository loginRepository;

    public LoginUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Single<SalesPersonEntity> execute(Param param) {
        return loginRepository.getSalesEntityRX(param.getParam());
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

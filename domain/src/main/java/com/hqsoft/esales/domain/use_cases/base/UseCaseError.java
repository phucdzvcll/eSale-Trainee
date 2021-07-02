package com.hqsoft.esales.domain.use_cases.base;

public interface UseCaseError {
    final class CommonError implements UseCaseError{
        final String message;

        public CommonError(String message) {
            this.message = message;
        }
    }
}

package com.hqsoft.esales.common_jvm.common;


import androidx.annotation.Nullable;

public final class ResultPair<Success, Fail> {

    @Nullable
    public Success getSuccess() {
        return success;
    }

    @Nullable
    public Fail getFail() {
        return fail;
    }

    @Nullable
    final Success success;
    @Nullable
    final Fail fail;

    public ResultPair(@Nullable Success success, @Nullable Fail fail) {
        this.success = success;
        this.fail = fail;
    }

}

package com.hqsoft.esales.common_jvm.mapper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

abstract public class Mapper<Input, Output> {
    @NonNull
    abstract public Output map(@NonNull Input input);

    @NonNull
    public final List<Output> mapList(final @NonNull List<Input> inputs) {
        final ArrayList<Output> outputs = new ArrayList<>();
        for (Input input : inputs) {
            outputs.add(map(input));
        }
        return outputs;
    }
}
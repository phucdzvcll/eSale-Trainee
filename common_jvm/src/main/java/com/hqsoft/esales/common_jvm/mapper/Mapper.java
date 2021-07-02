package com.hqsoft.esales.common_jvm.mapper;

import java.util.ArrayList;
import java.util.List;

abstract class Mapper<Input, Output> {
    abstract Output map(Input input);

    List<Output> mapList(final List<Input> inputs) {
        final ArrayList<Output> outputs = new ArrayList<>();
        for (Input input : inputs) {
            outputs.add(map(input));
        }
        return outputs;
    }
}
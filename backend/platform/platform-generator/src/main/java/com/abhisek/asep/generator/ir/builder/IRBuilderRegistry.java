package com.abhisek.asep.generator.ir.builder;

import java.util.List;

public interface IRBuilderRegistry {

    void register(
            IRBuilder<?, ?> builder);

    List<IRBuilder<?, ?>> getBuilders();

}
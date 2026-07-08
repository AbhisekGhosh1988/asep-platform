package com.abhisek.asep.generator.ir.builder;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultIRBuilderRegistry
        implements IRBuilderRegistry {

    private final List<IRBuilder<?, ?>> builders =
            new ArrayList<>();

    @Override
    public void register(
            IRBuilder<?, ?> builder) {

        builders.add(builder);

    }

    @Override
    public List<IRBuilder<?, ?>> getBuilders() {

        return List.copyOf(builders);

    }

}
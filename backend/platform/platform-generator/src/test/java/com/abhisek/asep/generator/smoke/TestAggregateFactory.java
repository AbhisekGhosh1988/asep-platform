package com.abhisek.asep.generator.smoke;

import com.abhisek.asep.generator.model.AggregateModel;

public final class TestAggregateFactory {

    private TestAggregateFactory() {
    }

    public static AggregateModel projectAggregate() {

        return AggregateModel.builder()
                .name("Project")
                .build();

    }

}
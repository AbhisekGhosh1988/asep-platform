package com.abhisek.asep.generator.ir.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class IRBuildReport {

    private Instant startedAt;

    private Instant completedAt;

    private int artifactsProcessed;

    private int errors;

}
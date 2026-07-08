package com.abhisek.asep.generator.session;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationReport {

    private Instant startedAt;

    private Instant completedAt;

    private int generatedFileCount;

    private int warningCount;

    private int errorCount;

}
package com.abhisek.asep.generator.compiler.context;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilerStatistics {

    private long startedAt;

    private long finishedAt;

    private int generatedArtifacts;

    private int warnings;

    private int errors;

}
package com.abhisek.asep.generator.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class GenerationResult {

    private GenerationStatus status;

    @Builder.Default
    private List<GenerationArtifact> artifacts =
            new ArrayList<>();

}
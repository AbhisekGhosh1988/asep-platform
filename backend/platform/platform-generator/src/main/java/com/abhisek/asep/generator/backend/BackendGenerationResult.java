package com.abhisek.asep.generator.backend;

import lombok.Builder;
import lombok.Getter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BackendGenerationResult {

    private final List<Path> generatedFiles;

    @Builder
    public BackendGenerationResult(
            List<Path> generatedFiles) {

        this.generatedFiles =
                generatedFiles == null
                        ? new ArrayList<>()
                        : generatedFiles;

    }

}
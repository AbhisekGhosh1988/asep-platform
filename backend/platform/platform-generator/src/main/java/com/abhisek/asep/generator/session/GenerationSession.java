package com.abhisek.asep.generator.session;

import com.abhisek.asep.generator.model.ProjectGenerationModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationSession {

    @Builder.Default
    private String id =
            UUID.randomUUID().toString();

    private SessionStatus status;

    /**
     * Immutable project model.
     */
    private ProjectGenerationModel project;

    @Builder.Default
    private List<GeneratedFile> generatedFiles =
            new ArrayList<>();

    @Builder.Default
    private List<GenerationWarning> warnings =
            new ArrayList<>();

    @Builder.Default
    private List<GenerationError> errors =
            new ArrayList<>();

    private GenerationReport report;

}
package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectGenerationModel {

    private ProjectModel project;

    private WorkspaceModel workspace;

    private GenerationSettings settings;

    private GenerationMetadata metadata;

    private GenerationModel design;

}
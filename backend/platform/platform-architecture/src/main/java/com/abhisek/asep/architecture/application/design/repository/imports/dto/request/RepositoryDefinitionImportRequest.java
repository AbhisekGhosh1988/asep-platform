package com.abhisek.asep.architecture.application.design.repository.imports.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDefinitionImportRequest {

    @NotBlank
    private String aggregateId;

    @NotBlank
    private String name;

    private String description;

}
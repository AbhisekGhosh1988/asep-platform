package com.abhisek.asep.architecture.application.design.entity.imports.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityImportRequest {

    @NotBlank
    private String aggregateId;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Boolean rootEntity;

}
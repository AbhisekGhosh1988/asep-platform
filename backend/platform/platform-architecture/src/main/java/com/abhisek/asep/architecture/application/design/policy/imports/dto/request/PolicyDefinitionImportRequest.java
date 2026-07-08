package com.abhisek.asep.architecture.application.design.policy.imports.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDefinitionImportRequest {

    @NotBlank
    private String aggregateId;

    @NotBlank
    private String name;

    private String description;

}
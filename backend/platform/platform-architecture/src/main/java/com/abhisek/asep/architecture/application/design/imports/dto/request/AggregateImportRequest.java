package com.abhisek.asep.architecture.application.design.imports.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateImportRequest {

    @NotBlank
    private String microserviceId;

    @NotBlank
    private String name;

    private String description;

}
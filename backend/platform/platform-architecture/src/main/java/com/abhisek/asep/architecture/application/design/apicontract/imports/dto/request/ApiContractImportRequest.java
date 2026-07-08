package com.abhisek.asep.architecture.application.design.apicontract.imports.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiContractImportRequest {

    @NotBlank
    private String aggregateId;

    @NotBlank
    private String name;

    @NotBlank
    private String method;

    @NotBlank
    private String path;

    private String description;

}
package com.abhisek.asep.architecture.application.design.attribute.imports.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeImportRequest {

    @NotBlank
    private String entityId;

    @NotBlank
    private String name;

    @NotBlank
    private String dataType;

    @NotNull
    private Boolean required;

    @NotNull
    private Boolean nullable;

    @NotNull
    private Boolean unique;

    private Boolean collection;

    private String defaultValue;

    private Integer length;

    private Integer precision;

    private Integer scale;

    private String description;

}
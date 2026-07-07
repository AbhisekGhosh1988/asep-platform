package com.abhisek.asep.architecture.application.design.relationship.imports.dto.request;

import com.abhisek.asep.architecture.domain.enums.CascadeType;
import com.abhisek.asep.architecture.domain.enums.FetchType;
import com.abhisek.asep.architecture.domain.enums.RelationshipType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipImportRequest {

    @NotBlank
    private String sourceEntityId;

    @NotBlank
    private String targetEntityId;

    @NotNull
    private RelationshipType relationshipType;

    @NotBlank
    private String fieldName;

    private String mappedBy;

    @NotNull
    private CascadeType cascadeType;

    @NotNull
    private FetchType fetchType;

    @NotNull
    private Boolean optional;

    @NotNull
    private Boolean orphanRemoval;

    private String description;

}
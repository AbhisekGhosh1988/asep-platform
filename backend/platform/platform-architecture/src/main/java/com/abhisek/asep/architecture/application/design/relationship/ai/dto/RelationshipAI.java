package com.abhisek.asep.architecture.application.design.relationship.ai.dto;

import com.abhisek.asep.architecture.domain.enums.CascadeType;
import com.abhisek.asep.architecture.domain.enums.FetchType;
import com.abhisek.asep.architecture.domain.enums.RelationshipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipAI {

    private String sourceEntity;

    private String targetEntity;

    private RelationshipType relationshipType;

    private String fieldName;

    private String mappedBy;

    private CascadeType cascadeType;

    private FetchType fetchType;

    private Boolean optional;

    private Boolean orphanRemoval;

    private String description;

}
package com.abhisek.asep.architecture.application.design.relationship.query.dto;

import com.abhisek.asep.architecture.domain.enums.CascadeType;
import com.abhisek.asep.architecture.domain.enums.FetchType;
import com.abhisek.asep.architecture.domain.enums.RelationshipType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipDetailsResponse {

    private String id;

    private String sourceEntityId;

    private String targetEntityId;

    private RelationshipType relationshipType;

    private String fieldName;

    private String mappedBy;

    private CascadeType cascadeType;

    private FetchType fetchType;

    private Boolean optional;

    private Boolean orphanRemoval;

    private String description;

}
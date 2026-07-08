package com.abhisek.asep.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipModel {

    private String id;

    private String sourceEntity;

    private String targetEntity;

    private String relationshipType;

}
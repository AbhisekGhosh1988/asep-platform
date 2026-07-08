package com.abhisek.asep.architecture.application.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportRelationshipModel {

    private String id;

    private String name;

    private String description;

    private String sourceEntityId;

    private String targetEntityId;

    private String relationshipType;

    private boolean owningSide;

}
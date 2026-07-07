package com.abhisek.asep.architecture.application.design.entity.query.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String description;

    private Boolean rootEntity;

}
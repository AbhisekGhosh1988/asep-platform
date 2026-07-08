package com.abhisek.asep.architecture.application.design.specification.query.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationDefinitionDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String description;

}
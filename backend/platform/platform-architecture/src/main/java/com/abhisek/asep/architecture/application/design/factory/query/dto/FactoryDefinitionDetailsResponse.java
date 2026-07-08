package com.abhisek.asep.architecture.application.design.factory.query.dto;

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
public class FactoryDefinitionDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String description;

}
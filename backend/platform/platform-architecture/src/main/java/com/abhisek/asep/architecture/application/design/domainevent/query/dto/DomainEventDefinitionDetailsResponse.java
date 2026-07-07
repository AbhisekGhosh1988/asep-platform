package com.abhisek.asep.architecture.application.design.domainevent.query.dto;

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
public class DomainEventDefinitionDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String description;

}
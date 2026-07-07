package com.abhisek.asep.architecture.application.design.domainservice.query.dto;

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
public class DomainServiceDefinitionDetailsResponse {

    private String id;

    private String aggregateId;

    private String name;

    private String description;

}